<%-- 
    Document   : cancelAppointment
    Created on : Jan 12, 2021, 3:20:39 PM
    Author     : Morcos
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cancel appointment</title>
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
        <form action="cancelApp" method="POST">
            <table>
                <tr>
                    <td>Enter appointment ID:</td>
                    <td><input type="number" name="appID"></td>
                </tr>
                <tr>
                    <td><input type="submit" value="cancel appointment"></td>
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

