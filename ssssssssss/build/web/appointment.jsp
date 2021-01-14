<%-- 
    Document   : appointment
    Created on : Jan 11, 2021, 10:05:50 PM
    Author     : Morcos
--%>

<%@page import="java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Appointment</title>
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
        <form action="appointmentValidation" method="POST">
            <table>
                <tr>
                    <td>Enter staff username:</td>
                    <td><input type="text" name="staffName"></td>
                </tr>
                <tr>
                    <td>Choose day</td>
                    <td>
                        <input type="radio" name="day" value="saturday" required><label>Saturday</label>
                        <input type="radio" name="day" value="sunday" required><label>Sunday</label>
                        <input type="radio" name="day" value="monday" required><label>Monday</label>
                        <input type="radio" name="day" value="tuesday" required><label>Tuesday</label>
                        <input type="radio" name="day" value="wednesday" required><label>Wednesday</label>
                        <input type="radio" name="day" value="thursday" required><label>Thursday</label>
                        <input type="radio" name="day" value="friday" required><label>Friday</label>
                    </td>
                </tr>
                <tr>
                    <td>From</td>
                    <td><input type="number" name="fromhours" min="00" max="23"></td>
                </tr>
                <tr>
                    <td>to</td>
                    <td><input type="number" name="tohours" min="00" max="23"></td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" value="Reserve appointment"></td>
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

