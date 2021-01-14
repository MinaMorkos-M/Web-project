/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Morcos
 */
@WebServlet(name = "ValidateStaffOfficeHours", urlPatterns = {"/ValidateStaffOfficeHours"})
public class ValidateStaffOfficeHours extends HttpServlet {

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
            throws ServletException, IOException, ClassNotFoundException, InstantiationException, SQLException, IllegalAccessException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
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
        PrintWriter out = response.getWriter();
        try {
            String username = request.getParameter("staffName");
            String currentStaffName, currentDay, currentFrom, currentTo , state;
            Connection Con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/webproject", "root", "root");
            Statement stmt = (Statement) Con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM officehours");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet GetStaffConact</title>");
            out.println("</head>");
            out.println("<body>");
            
            while (rs.next()) {
                currentStaffName = rs.getString("username");
                if (currentStaffName.equals(username)) {
                    currentDay = rs.getString("day");
                    currentFrom = rs.getString("fromhours");
                    currentTo = rs.getString("tohours");
                    state = rs.getString("state");
                    //from.add(currentFrom);
                    //to.add(currentTo);
                    out.println("<div>");
                    out.println("<span> Day : " + currentDay + "</span>");
                    out.println("<span> From : " + currentFrom + "</span>");
                    out.println("<span> to : " + currentTo + "</span>");
                    out.println("<span> state : " + state + "</span>");
                    out.println(" </div>");
                }
            }
            
            out.println("</body>");
            out.println("</html>");
            RequestDispatcher dispatcher = request.getRequestDispatcher("OfficeHour.jsp");
            dispatcher.include(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(SearchForStaffSubject.class.getName()).log(Level.SEVERE, null, ex);
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
