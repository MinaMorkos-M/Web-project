<%-- 
    Document   : createoffice
    Created on : Jan 13, 2021, 2:53:46 PM
    Author     : dell
--%>

    <%@page import="java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
            String day , r;
            int from , to;
        
       
        
            HttpSession session1 = request.getSession();
            String staffName = session1.getAttribute("username").toString();
            
           
               
                
                Class.forName("com.mysql.jdbc.Driver").newInstance();
                Connection Con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/webproject", "root", "root");
                Statement stmt = (Statement) Con.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM officehours ;");
            
        %>
          <form action="creationoffice" method="POST">
            <table>
                <tr>
                    <td>Enter meetingID</td>
                    <td><input type="text" name="id" placeholder="id"></td>
                </tr>
                <tr>
                    <td>Enter day</td>
                    <td><input type="text" name="day" ></td>
                </tr>
                <tr>
                    <td>Enter fromhours</td>
                    <td><input type="number" name="from"></td>
                </tr>
                 <tr>
                    <td>Enter tohours</td>
                    <td><input type="number" name="to"></td>
                </tr>
                <tr>
                    <td>Enter state</td>
                    <td><input type="text" name="state" placeholder="state"></td>
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
