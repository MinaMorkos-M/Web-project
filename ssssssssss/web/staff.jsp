<%-- 
    Document   : Staff
    Created on : Jan 11, 2021, 1:06:08 PM
    Author     : dell
--%>

<%@page import="com.org.DataBaseConnection"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
         <style>
          
                
              form{
                
                margin: 2px 30px;
                
               
                    background-color: #11484D;
                    padding: 10px 90px 30px 120px ;
                
            }
         
            body {
                 background-color: #246B71;
            }
        </style>
    </head>
    <body>
         <% Connection con = DataBaseConnection.initializeDatabase();
        HttpSession session1 = request.getSession();
            String staffName = session1.getAttribute("fname").toString();
        %>
        
        <h1> welcome to <%out.print(staffName);%> page </h1>
        <form action="viewmessage.jsp" method="post">
            <button type="submit">view student message</button></form>
        <form action="replymessage.jsp" method="post">
            <button type="subtmit">send message</button></form>
        <form action="sendstaff.jsp" method="post">
            <button type="subtmit">send staff message</button></form>
        <form action="searchstudent" method="post">
        <input type="text" name="searchh" placeholder="Search..">
        <button type="submit" >search for student</button></form>
        
        <form action="viewofficehours.jsp" method="post">
            <button type ="submi">View history of reservations </button></form>
        
        <form action="canceloffice.jsp" method="post">
            <button type="submit">cancel slot</button></form>
        <form action="specificoffice.jsp" method="post">
            <button type="submit">View specific reservations</button></form>
        <form action="createoffice.jsp" type="post">
            <button type="submit"> create office hours slots</button></form>
        <form action="updateofficehours.jsp" type="post">
            <button type="submit"> update  office hours slots</button></form>
        <form action="deleteoffice.jsp" method="post">
            <button type="submit"> delete office hours slots</button></form>
        
        
    </body>
</html>
