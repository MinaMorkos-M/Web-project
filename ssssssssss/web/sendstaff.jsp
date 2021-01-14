<%-- 
    Document   : sendstaff
    Created on : Jan 13, 2021, 6:06:03 PM
    Author     : dell
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

    <%@page import="java.sql.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
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
        </style>
    </head>
    <body>
          <%
            
            String receiverName = session.getAttribute("username").toString();
            String staffsubject = session.getAttribute("subject").toString();
            Connection Con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/webproject", "root", "root");
            
           

        %>
        <form action="staffmessage" method="POST">
            <table>
                
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
