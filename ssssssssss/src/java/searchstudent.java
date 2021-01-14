/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.org.DataBaseConnection;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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
 * @author dell
 */
@WebServlet(urlPatterns = {"/searchstudent"})
public class searchstudent extends HttpServlet {

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
            Connection con = null;
            ResultSet RS;
            try {
                con = DataBaseConnection.initializeDatabase();
                String search = request.getParameter("searchh");
                //out.println(search);
                Statement Stmt = con.createStatement();
                RS = Stmt.executeQuery("select * from Student");

                String dbsearch = null;

                String s1 = null;
                //int i1 = 0;
                //int i12 = 0;
                while (RS.next()) {

                    dbsearch = RS.getString("username");
                    s1 = RS.getString("phone");

                }
                if (dbsearch == null ? search == null : dbsearch.equals(search)) {

                    out.println("<table border='1'>");
                    out.println(" <tr>");
                    out.println(" <th>name</th> ");
                    out.println(" <th> phone</th> ");

                    //out.println(" <th>tohours</th> "); 
                    out.println("</tr>");

                    out.println("<tr>");
                    out.println("<td>");
                    out.println(dbsearch);
                    out.println("</td>");
                    out.println("<td>");
                    out.println(s1);
                    out.println("</td>");
                    /*out.println("<td>");
                 out.println(i1); 
                 out.println("</td>");
                 out.println("<td>");
                 out.println(i12);
                 out.println("</td>");*/
                    out.println("</tr>");

                    out.println("</table>");

                }
                RequestDispatcher dispatcher = request.getRequestDispatcher("staff.jsp");
                dispatcher.include(request, response);
            } catch (SQLException ex) {
                Logger.getLogger(searchstudent.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(searchstudent.class.getName()).log(Level.SEVERE, null, ex);
            }
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

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        PrintWriter out = response.getWriter();

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
