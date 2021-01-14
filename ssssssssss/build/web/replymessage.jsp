<%-- 
    Document   : replymessage
    Created on : Jan 12, 2021, 9:00:53 PM
    Author     : dell
--%>


<%@page import="java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Send Message</title>
        <style>
            .result{

                margin: 50px 300px;

                box-shadow: 2px 2px 20px 2px black ;
                background-color: #11484D;
                padding: 30px 90px 30px 120px ;

            }
            span{
                font-size: 20px;
                font-weight: bold;
                color: white;

            }
            body {
                background-color: #246B71;
            }
            #result{
                margin-left: auto;
                margin-right: auto;
            }


        </style>
    </head>
    <body>
        <%
            String senderName, message, messageID;
            String receiverName = session.getAttribute("username").toString();
            String currentReceiver;
            Connection Con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/webproject", "root", "root");
            Statement stmt = (Statement) Con.createStatement();
          

        %>
        <form action="sendmess" method="POST">
            <table>
                <tr>
                    <td>Enter reciever username:</td>
                    <td><input type="text" name="Name" placeholder="username"></td>
                </tr>
                <tr>
                    <td>Enter your message:</td>
                    <td><input type="text" name="message" placeholder="message"></td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" value="Send"></td>
                </tr>
            </table>
        </form>
       
   
        <form action="staff.jsp">
            <table>
                <tr>
                    
                    <td><input type="submit" value="return"></td>
                </tr>
            </table>
        </form>
    </body>
</html>

