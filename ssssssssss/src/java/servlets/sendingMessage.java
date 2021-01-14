/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Morcos
 */
@WebServlet(name = "sendingMessage", urlPatterns = {"/sendingMessage"})
public class sendingMessage extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet sendingMessage</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet sendingMessage at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        PrintWriter out = response.getWriter();
        boolean found = false;
        String senderName = session.getAttribute("username").toString(); //da ana
        String receiverName = request.getParameter("staffName"); //da el staff
        String message = request.getParameter("message");
        String currentStaff;
        Connection Con;
        try {
            Con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/webproject", "root", "root");
            Statement stmt = (Statement) Con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM staff");
            while (rs.next()) {
                currentStaff = rs.getString("username");
                if (currentStaff.equals(receiverName)) {
                    found = true;
                    break;
                }
            }
            if (found) {
                PreparedStatement pstmt = Con.prepareStatement("INSERT INTO messages(senderName , receiver , message) VALUES(?,?,?)");
                pstmt.setString(1, senderName);
                pstmt.setString(2, receiverName);
                pstmt.setString(3, message);
                int i = pstmt.executeUpdate();
                out.println("<html>\n"
                        + "  <head>\n"
                        + "\n"
                        + "  </head>\n"
                        + "  <body>\n"
                        + "    <p>your message has been sent successfully</p>\n"
                        + "  </body>\n"
                        + "</html>");
            }
            else{
                out.println("<html>\n"
                        + "  <head>\n"
                        + "\n"
                        + "  </head>\n"
                        + "  <body>\n"
                        + "    <p>your message has been sent unsuccessfully</p>\n"
                        + "  </body>\n"
                        + "</html>");
            }
            RequestDispatcher dispatcher = request.getRequestDispatcher("sendMessage.jsp");
            dispatcher.include(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(sendingMessage.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
