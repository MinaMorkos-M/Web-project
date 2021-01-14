<%-- 
    Document   : OfficeHour
    Created on : Jan 11, 2021, 6:11:41 PM
    Author     : Morcos
--%>

<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.Statement"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
        <form action="ValidateStaffOfficeHours" method="POST">
            <table>
                <tr>
                    <td>Enter staff username</td>
                    <td><input type="text" name="staffName" placeholder="username"></td>
                </tr>
                <tr>
                    <td><input type="submit" value="Enter"></td>
                    <td></td>
                </tr>
            </table>
        </form>
        <form action="StudentProfile.jsp">
            <table>
                <tr>
                    
                    <td><input type="submit" value="return"></td>
                </tr>
            </table>
        </form>
    </body>
</html>

