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
import javax.servlet.http.HttpSession;

/**
 *
 * @author Omar
 */
@WebServlet(name = "ValidateSignIn", urlPatterns = {"/ValidateSignIn"})
public class ValidateSignIn extends HttpServlet {

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
            out.println("<title>Servlet ValidateSignIn</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ValidateSignIn at " + request.getContextPath() + "</h1>");
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
            PrintWriter out = response.getWriter();
            Connection con = DataBaseConnection.initializeDatabase();
            Statement stm = con.createStatement() ;
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            ResultSet result = stm.executeQuery("select * from student") ;
            
            boolean userNameFound = false ; 
            while (result.next())
            {
                if (result.getString("username").equals(username))
                {
                    userNameFound = true ; 
                    if (result.getString("password").equals(password))
                    {
                        HttpSession session = request.getSession();
                        session.setAttribute("username", username);
                        session.setAttribute("fname", result.getString("fname"));
                        session.setAttribute("lname", result.getString("lname"));
                        session.setAttribute("age", result.getString("age"));
                        session.setAttribute("password", result.getString("password"));
                        session.setAttribute("phone", result.getString("phone"));

                          RequestDispatcher dispatcher = request.getRequestDispatcher("StudentProfile.jsp");
                      dispatcher.include(request, response);
                    }
                    
                    else 
                    {
                               out.println("<!DOCTYPE html>");
                                out.println("<html>");
                                out.println("<head>");
                                out.println("<title>Servlet ValidateSignIn</title>");            
                                out.println("</head>");
                                out.println("<body>");
                                out.println("<h2>INVALID PASSWORD! " + "</h2>");
                                out.println("</body>");
                                out.println("</html>");
                           RequestDispatcher dispatcher = request.getRequestDispatcher("SignIn.html");
                      dispatcher.include(request, response);
                      break ; 
                    }
                }
               
               
                
            if (!userNameFound)
            {
                        out.println("<!DOCTYPE html>");
                                out.println("<html>");
                                out.println("<head>");
                                out.println("<title>Servlet ValidateSignIn</title>");            
                                out.println("</head>");
                                out.println("<body>");
                                out.println("<h2> UserName Not Found! " + "</h2>");
                                out.println("</body>");
                                out.println("</html>");
                           RequestDispatcher dispatcher = request.getRequestDispatcher("SignIn.html");
                      dispatcher.include(request, response);
            }
            }
                           
                
        
        
        } catch (SQLException ex) {
            Logger.getLogger(ValidateSignIn.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ValidateSignIn.class.getName()).log(Level.SEVERE, null, ex);
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
