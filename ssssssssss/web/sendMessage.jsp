<%-- 
    Document   : sendMessage
    Created on : Jan 12, 2021, 5:15:32 PM
    Author     : Morcos
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
            ResultSet rs = stmt.executeQuery("SELECT * FROM messages");

        %>
        <form action="sendingMessage" method="POST">
            <table>
                <tr>
                    <td>Enter staff username:</td>
                    <td><input type="text" name="staffName" placeholder="username"></td>
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
        <form action="StudentProfile.jsp" method="get">
            <table>
                <tr>
                    <td></td>
                    <td><input type="submit" value="return"></td>
                </tr>
            </table>
        </form> 
        <table border="2" cellspacing="3" id="result">
            <tr>
                <th>Sender</th>
                <th>Message</th>
            </tr>
            <%                    while (rs.next()) {
                    currentReceiver = rs.getString("receiver");
                    if (currentReceiver.equals(receiverName)) {


            %>
            <tr>

                <td>
                    <%                        senderName = rs.getString("senderName");
                        out.println(senderName);
                    %>
                </td>
                <td>
                    <%
                        message = rs.getString("message");
                        out.println(message);
                    %>
                </td>
            </tr>
            <%}
                }%>
        </table>

    </body>
</html>
