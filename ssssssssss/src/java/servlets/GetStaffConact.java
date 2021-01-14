/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import com.org.DataBaseConnection;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
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
 * @author Omar
 */
@WebServlet(name = "GetStaffConact", urlPatterns = {"/GetStaffConact"})
public class GetStaffConact extends HttpServlet {

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
            out.println("<title>Servlet GetStaffConact</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println( " <div class=\"result\"> ") ;
            out.println( "<span>"  + "</span>") ;
            out.println(" </div>");
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
        try {
            Connection con = DataBaseConnection.initializeDatabase();
            Statement stm = con.createStatement() ;
            String staffMemberUserName = request.getParameter("staffmemberusername");
            ResultSet result = stm.executeQuery("select * from staff") ;
            while(result.next())
            {
                if (staffMemberUserName.equals(result.getString("username")))
                {PrintWriter out = response.getWriter();
                   out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet GetStaffConact</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println( " <div class=\"result\"> ") ;
            out.println( "<span> Number : " + result.getString("phone") + "</span>") ;
            out.println( "<span> UserNAme : " + result.getString("username") + "</span>") ;
            out.println(" </div>");
            out.println("</body>");
            out.println("</html>");
                           RequestDispatcher dispatcher = request.getRequestDispatcher("StudentProfile.jsp");
                      dispatcher.include(request, response);
                }
            }
            
            
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(GetStaffConact.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GetStaffConact.class.getName()).log(Level.SEVERE, null, ex);
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
