/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import com.org.DataBaseConnection;
import com.org.staff;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
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
import javax.servlet.http.HttpSession;

/**
 *
 * @author Omar
 */
@WebServlet(name = "SearchForStaffSubject", urlPatterns = {"/SearchForStaffSubject"})
public class SearchForStaffSubject extends HttpServlet {

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
            out.println("<title>Servlet SearchForStaffSubject</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SearchForStaffSubject at " + request.getContextPath() + "</h1>");
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
            String subjectOne = "" ; 
             String subjectTwo = "" ;
              String subjectThree = "" ;
            
            
            Connection con = DataBaseConnection.initializeDatabase();
            Statement stm = con.createStatement() ;      
            ArrayList <staff> staffMembersForFirstSubject = new ArrayList<staff>() ;
            ArrayList <staff> staffMembersForSeconSubject = new ArrayList<staff>() ;
            ArrayList <staff> staffMembersForThirdSubject = new ArrayList<staff>() ;
            HttpSession session = request.getSession();
            String username = session.getAttribute("username").toString();
            ResultSet result = stm.executeQuery("select * from student") ;
            while (result.next())
            {
                if ( result.getString("username").equals(username)) 
                {
                    subjectOne = result.getString("subjectone");
                    subjectTwo = result.getString("subjecttwo");
                    subjectThree = result.getString("subjectthree");
                }
            }
            stm.close();
           stm = con.createStatement() ; 
             result =   stm.executeQuery("select * from staff") ; 
          while (result.next())
          {
              if (result.getString("subject").equals(subjectOne))
                      {
                          staff staff = new staff() ; 
                          staff.setName(result.getString("fname") + result.getString("lname"));
                          staff.setUserName(result.getString("username"));
                          staffMembersForFirstSubject.add(staff);
                      }
          }
          stm.close();
           stm = con.createStatement() ; 
             result =   stm.executeQuery("select * from staff") ; 
          while (result.next())
          {
              if (result.getString("subject").equals(subjectTwo))
                      {
                            staff staff = new staff() ; 
                          staff.setName(result.getString("fname") + result.getString("lname"));
                          staff.setUserName(result.getString("username"));
                          staffMembersForSeconSubject.add(staff);
                      }
          }
          stm.close();
           stm = con.createStatement() ; 
             result =   stm.executeQuery("select * from staff") ; 
          while (result.next())
          {
              if (result.getString("subject").equals(subjectThree))
                      {
                            staff staff = new staff() ; 
                          staff.setName(result.getString("fname") + result.getString("lname"));
                          staff.setUserName(result.getString("username"));
                          staffMembersForThirdSubject.add(staff);
                      }
          }
          
       
                      PrintWriter out = response.getWriter();
                          out.println("<!DOCTYPE html>");
                                out.println("<html>");
                                out.println("<head>");
                                out.println("<title>Servlet ValidateSignIn</title>");            
                                out.println("</head>");
                                out.println("<body>");
                                out.println( " <div class=\"result\"> ") ;
                                if ( staffMembersForFirstSubject.size() == 0)
                                {
                                    out.println("<h2> There are no any TAS or Doctors for the " + subjectOne + "</h2>");
                                }
                                else 
                                {
                                out.println("<h2> TAS For " +subjectOne + " Are : " + "</h2>");
                               for ( int i = 0 ; i <staffMembersForFirstSubject.size() ; i ++  ) {
                               out.println("<span > Name : " +staffMembersForFirstSubject.get(i).getName() + "</span>" );
                               out.println("<span > UserName : " +staffMembersForFirstSubject.get(i).getUserName() + "</span>" );
                               
                               }
                                }
                                if ( staffMembersForSeconSubject.size() == 0)
                                {
                                    out.println("<h2> There are no any TAS or Doctors for the " + subjectTwo + "</h2>");
                                }
                                else 
                                {
                               out.println("<h2> TAS For " +subjectTwo + " Are : " + "</h2>");
                                for ( int i = 0 ; i <staffMembersForSeconSubject.size() ; i ++  ) {
                               out.println("<span > Name : " +staffMembersForSeconSubject.get(i).getName() + "</span>" );
                               out.println("<span > UserName : " +staffMembersForSeconSubject.get(i).getUserName() + "</span>" );
                               
                               }
                                }
                                if ( staffMembersForThirdSubject.size() == 0)
                                {
                                    out.println("<h2> There are no any TAS or Doctors for the " + subjectThree + "</h2>");
                                }
                                else 
                                {
                                out.println("<h2> TAS For " +subjectThree + " Are : " + "</h2>");
                                 for ( int i = 0 ; i <staffMembersForThirdSubject.size() ; i ++  ) {
                               out.println("<span> Name : " +staffMembersForThirdSubject.get(i).getName() + "</span>" );
                               out.println("<span> UserName : " +staffMembersForThirdSubject.get(i).getUserName() + "</span>" );
                               
                               }
                                }
                                out.println(" </div>");
                                out.println("</body>");
                                out.println("</html>");
                           RequestDispatcher dispatcher = request.getRequestDispatcher("StudentProfile.jsp");
                      dispatcher.include(request, response);
                     
          
       
   
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(SearchForStaffSubject.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
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
