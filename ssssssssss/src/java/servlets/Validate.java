package servlets;


import com.org.DataBaseConnection;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.SecureRandom;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Random;
import javax.servlet.RequestDispatcher;

public class Validate extends HttpServlet {

    String name, subject, email, msg;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Connection con = DataBaseConnection.initializeDatabase();
          Statement stm = con.createStatement() ;
          
          
             
            String generatedPassword = generatePassword() ;
            String fName = request.getParameter("fname");
            String lName = request.getParameter("lname");
            String userName = request.getParameter("email");
            String gender = request.getParameter("gender");
            String phone = request.getParameter("phone");
            int age = Integer.parseInt(request.getParameter("age").trim());
            String role = request.getParameter("role");
           
      
            if (role.equals("student"))
            {
                String subjectOne = assignToRandomSubject()  ;
                 String subjectTwo = assignToRandomSubject()  ;
                 while ( subjectTwo.equals(subjectOne))
                 {
                     subjectTwo = assignToRandomSubject() ;
                 }
                 
                  String subjectThree = assignToRandomSubject()  ;
                   while ( subjectThree.equals(subjectOne) || subjectThree.equals(subjectTwo))
                 {
                     subjectThree = assignToRandomSubject() ;
                 }
            String SQL = "INSERT INTO student VALUES (?, ?, ? , ? , ? , ?,  ? , ? , ? , ?)";
             PreparedStatement pstmt = con.prepareStatement(SQL);
             pstmt.setString(1, fName);
             pstmt.setString(2, lName);
             pstmt.setString(3,gender);
             pstmt.setInt(4, age);
             pstmt.setString(5,phone);
             pstmt.setString(6, userName);
             pstmt.setString(7, generatedPassword);
             pstmt.setString(8, subjectOne);
             pstmt.setString(9, subjectTwo);
             pstmt.setString(10, subjectThree);
             pstmt.execute();
             pstmt.close();
            RequestDispatcher dispatcher = request.getRequestDispatcher("SignIn.html");
                      dispatcher.include(request, response);}
            if (role.equals("staff")) 
            {
                String subject = assignToRandomSubject() ;
                 String SQL = "INSERT INTO staff VALUES (?, ?, ? , ? , ? , ?,  ? , ?)";
             PreparedStatement pstmt = con.prepareStatement(SQL);
             pstmt.setString(1, fName);
             pstmt.setString(2, lName);
             pstmt.setString(3,gender);
             pstmt.setInt(4, age);
             pstmt.setString(5,phone);
             pstmt.setString(6, userName);
             pstmt.setString(7, generatedPassword);
             pstmt.setString(8,subject);
             pstmt.execute();
             pstmt.close();
             RequestDispatcher dispatcher = request.getRequestDispatcher("signinstaff.html");
                      dispatcher.include(request, response);
             }
//        PrintWriter out = response.getWriter();
//        response.setContentType("text/html");
//        name = "omar" ;
//        email = "omarshasdokry1811@gmail.com" ;
//        subject = "omar" ;
//        msg = "omar" ; 
//
//        final String username = "omarshokry1811@gmail.com"; //your email id
//        final String password = "181200015";// your password
//        Properties props = new Properties();
//        props.put("mail.smtp.auth", true);
//        props.put("mail.smtp.starttls.enable", true);
//        props.put("mail.smtp.host", "smtp.gmail.com");
//        props.put("mail.smtp.port", "587");
//        Session session = Session.getInstance(props,
//                new javax.mail.Authenticator() {
//                    @Override
//                    protected PasswordAuthentication getPasswordAuthentication() {
//                        return new PasswordAuthentication(username, password);
//                    }
//                });
//        try {
//            Message message = new MimeMessage(session);
//            message.setFrom(new InternetAddress(email));
//            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("omarshokry181@yahoo.com"));
//            MimeBodyPart textPart = new MimeBodyPart();
//            Multipart multipart = new MimeMultipart();
//            String final_Text = "Name: " + name + "    " + "Email: " + email + "    " + "Subject: " + subject + "    " + "Mesaage: " + msg;
//            textPart.setText(final_Text);
//            message.setSubject(subject);
//            multipart.addBodyPart(textPart);
//            message.setContent(multipart);
//            message.setSubject("Contact Details");
//            //out.println("Sending");
//            Transport.send(message);
//            out.println("<center><h2 style='color:green;'>Email Sent Successfully.</h2>");
//            out.println("Thank you " + name + ", your message has been submitted to us.</center>");
//        } catch (Exception e) {
//            out.println(e);
//        }
//        } catch (SQLException ex) {
//            Logger.getLogger(Validate.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(Validate.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }   catch (SQLException ex) {
            Logger.getLogger(Validate.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Validate.class.getName()).log(Level.SEVERE, null, ex);
        }

}
     public static String generatePassword()
    {
   
        final String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
 
        SecureRandom random = new SecureRandom();
        StringBuilder sb = new StringBuilder();
 
        for (int i = 0; i < 9; i++) {
            int randomIndex = random.nextInt(chars.length());
            sb.append(chars.charAt(randomIndex));
        }
 
        return sb.toString();
    }
     public String assignToRandomSubject()
     {
         ArrayList<String> subjects = new ArrayList<String>();
          subjects.add("Math");
          subjects.add("Web");
          subjects.add("Software");
          subjects.add("SystemAnalysis");
      SecureRandom random = new SecureRandom();
         int i = random.nextInt(4) ;
         return subjects.get(i);
     }
}
