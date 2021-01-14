<%-- 
    Document   : canceloffice
    Created on : Jan 13, 2021, 1:31:44 PM
    Author     : dell
--%>

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
        <form action="cancelationoffice" method="POST">
            <table>
                <tr>
                <td>Enter officehour ID:</td>
                <td><input type="number" name="offID"></td></tr>
                <tr><td><input type="submit" value="cancel"></td></tr>
                    
                  </tr></table></form>
                <form action="staff.jsp">
            <table>
                <tr>
                    
                    <td><input type="submit" value="return"></td>
                </tr>
            </table>
        </form>
    </body>
</html>
