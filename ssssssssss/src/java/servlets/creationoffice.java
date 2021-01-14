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
import java.sql.PreparedStatement;
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

/*import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;*/
/**
 *
 * @author dell
 */
@WebServlet(name = "creationoffice", urlPatterns = {"/creationoffice"})
public class creationoffice extends HttpServlet {

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

            try {
                con = DataBaseConnection.initializeDatabase();
                Statement stm = con.createStatement();
                if (con != null) {
                    out.print("Office hours is set successfully ");
                }
                HttpSession session1 = request.getSession();
                String staffName = session1.getAttribute("username").toString();
                String id = request.getParameter("id");
                String day = request.getParameter("day");
                String state = request.getParameter("state");
                int toohours = Integer.parseInt(request.getParameter("to"));
                int fromohours = Integer.parseInt(request.getParameter("from"));
                String SQL = " iNSERT INTO officehours VALUES(? , ? ,?, ?, ?, ? );";
                try (PreparedStatement pstmt = con.prepareStatement(SQL)) {
                    pstmt.setString(1, id);
                    pstmt.setString(2, staffName);
                    pstmt.setString(3, day);
                    pstmt.setInt(4, fromohours);
                    pstmt.setInt(5, toohours);
                    pstmt.setString(6, state);
                    pstmt.execute();
                }

                /* String name, email, subject, msg;
                        response.setContentType("text/html");
                        name = "";
                        email = "";
                        subject = "canceled appointment";
                        msg = "your have a slot  on " + day + " from" + fromohours + " toohours" + to ;

                        final String username = ""; //your email id
                        final String password = "";// your password
                        Properties props = new Properties();
                        props.put("mail.smtp.auth", true);
                        props.put("mail.smtp.starttls.enable", true);
                        props.put("mail.smtp.host", "smtp.gmail.com");
                        props.put("mail.smtp.port", "587");
                        Session session = Session.getInstance(props,
                                new javax.mail.Authenticator() {
                            protected PasswordAuthentication getPasswordAuthentication() {
                                return new PasswordAuthentication(username, password);
                            }
                        });
                        try {
                            Message message = new MimeMessage(session);
                            message.setFrom(new InternetAddress(email));
                            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(""));
                            MimeBodyPart textPart = new MimeBodyPart();
                            Multipart multipart = new MimeMultipart();
                            String final_Text = "Name: " + name + "    " + "Email: " + email + "    " + "Subject: " + subject + "    " + "Mesaage: " + msg;
                            textPart.setText(final_Text);
                            message.setSubject(subject);
                            multipart.addBodyPart(textPart);
                            message.setContent(multipart);
                            message.setSubject("Contact Details");
                            //out.println("Sending");
                            Transport.send(message);
                            out.println("<center><h2 style='color:green;'>Email Sent Successfully.</h2>");
                            out.println("Thank you " + name + ", your message has been submitted to us.</center>");
                        } catch (Exception e) {
                            out.println(e);
                        }*/
                RequestDispatcher dispatcher = request.getRequestDispatcher("createoffice.jsp");
                dispatcher.include(request, response);
            } catch (SQLException ex) {
                Logger.getLogger(creationoffice.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(creationoffice.class.getName()).log(Level.SEVERE, null, ex);
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
        processRequest(request, response);
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
