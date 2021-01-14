<%-- 
    Document   : viewmessage
    Created on : Jan 13, 2021, 12:05:37 AM
    Author     : dell
--%>

    <%@page import="java.sql.*"%>
<head>
        <title>Office Hours</title>
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
            String message , student;
           
        
       
        
            HttpSession session1 = request.getSession();
            String staffName = session1.getAttribute("username").toString();
            
           
               
                
                Class.forName("com.mysql.jdbc.Driver").newInstance();
                Connection Con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/webproject", "root", "root");
                Statement stmt = (Statement) Con.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM messages;");
            
        %>
        <table>
            
           
            <%
                while(rs.next()){
                    String username = rs.getString("receiver");
                    if(username.equals(staffName)){               
            %>

            <tr>
                <td>
                    <%
                        message = rs.getString("message");
                        out.println(message);
                    %>
                </td>
                <td>
                    <%
                        String sender = rs.getString("senderName");
                        out.println(sender);
                    %>
                </td>
            </tr>
            </form
        </table>
                <form action="messagesofstaff" method="POST">
            <table>
                <tr> 
                    <td>Enter your reply </td>
                    <td><input type="text" name="message" ></td>
                </tr>
                                <tr> 
                    <td>to </td>
                    <td><input type="text" name="student" ></td>
                </tr>
              
                <tr>
                   
                    <td><input type="submit" value="Send"></td>
                </tr>
            </table></form>
               <form action="staff.jsp">
            <table>
                <tr>
                    
                    <td><input type="submit" value="return"></td>
                </tr>
            </table>
        </form>
        <%}}%>
