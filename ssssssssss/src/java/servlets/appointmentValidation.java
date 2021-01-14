/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
/*import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;*/
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
@WebServlet(name = "appointmentValidation", urlPatterns = {"/appointmentValidation"})
public class appointmentValidation extends HttpServlet {

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
            out.println("<title>Servlet appointmentValidation</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet appointmentValidation at " + request.getContextPath() + "</h1>");
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
        PrintWriter out = response.getWriter();
        boolean found = false;
        String staffName = request.getParameter("staffName");
        String day = request.getParameter("day");
        String from = request.getParameter("fromhours");
        String to = request.getParameter("tohours");
        Connection Con;
        try {
            Con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/webproject", "root", "root");
            Statement stmt = (Statement) Con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM officehours");
            String sn, d, f, t;
            while (rs.next()) {
                sn = rs.getString("username");
                d = rs.getString("day");
                f = rs.getString("fromhours");
                t = rs.getString("tohours");

                if (sn.equals(staffName) && d.equals(day) && f.equals(from) && t.equals(to)) {
                    String registered = rs.getString("state");
                    if (registered.equals("free")) {
                        String id = rs.getString("meetingID"); //should be sent with mail
                        found = true;
                        PreparedStatement pstmt = Con.prepareStatement("UPDATE officehours SET state ='registered' WHERE meetingID=? ;");
                        pstmt.setString(1, id);
                        //**************************************
                        /* String name, email, subject, msg;
                        response.setContentType("text/html");
                        name = "";
                        email = "";
                        subject = "canceled appointment";
                        msg = "your have a reserved appointment on " + day + " from" + from + " to" + to + " with" + staffName + " Meeting ID: " + id;

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
                        //**************************************
                        int i = pstmt.executeUpdate();
                        PreparedStatement pstmt2 = Con.prepareStatement("iNSERT INTO messages VALUES(?,?,?);");
                        pstmt2.setString(1, "System");
                        pstmt2.setString(2, staffName);
                        pstmt2.setString(3, "your have a reserved appointment on " + day + " from" + from + " to" + to + " with" + staffName + " Meeting ID: " + id);
                        pstmt2.execute();
                        out.println("<html>\n"
                                + "  <head>\n"
                                + "\n"
                                + "  </head>\n"
                                + "  <body>\n"
                                + "    <p>you have registered the appointment successfully</p>\n"
                                + "  </body>\n"
                                + "</html>");
                    }
                }

            }
            /*if (found) {
                String name, email, subject, msg;
                response.setContentType("text/html");
                name = "Mina";
                email = "omarshasdokry1811@gmail.com";
                subject = "Reserved appointment";
                msg = "your appointment has been reserved successfully";

                final String username = "omarshokry1811@gmail.com"; //your email id
                final String password = "181200015";// your password
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
                    message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("omarshokry181@yahoo.com"));
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
                }

            }*/
            RequestDispatcher dispatcher = request.getRequestDispatcher("appointment.jsp");
            dispatcher.include(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(appointmentValidation.class.getName()).log(Level.SEVERE, null, ex);
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
