<%-- 
    Document   : specificoffice
    Created on : Jan 14, 2021, 12:33:12 PM
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
    <body><form action="viewspecificofficehours.jsp" method="post">
            <input type ="text" name="dayselect">
            <input type="submit" value="select">
        </form>
    </body>
</html>
