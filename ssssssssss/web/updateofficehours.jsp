<%-- 
    Document   : updateofficehours
    Created on : Jan 13, 2021, 11:57:09 AM
    Author     : dell
--%>
<%@page import="java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
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
          <body>
        <%
            String senderName, message, messageID;
            String receiverName = session.getAttribute("username").toString();
            String currentReceiver;
            Connection Con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/webproject", "root", "root");
            Statement stmt = (Statement) Con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM messages");

        %>
        <form action="updatingoffice" method="POST">
            <table>
                <td>Enter officehour ID:</td>
                <td><input type="number" name="offID"></td></tr>
                
                
                
                  <tr>
                    <td>Enter day update</td>
                    <td><input type="text" name="day" placeholder="day"></td>
                </tr>
                <tr>
                    <td>Enter fromhoursupdate</td>
                    <td><input type="number" name="fromhours" placeholder="fromhours"></td>
                </tr>
                  <tr>
                    <td>Enter tohoursupdate</td>
                    <td><input type="number" name="tohours" placeholder="tohours"></td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" value="update"></td>
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
