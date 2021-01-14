<%-- 
    Document   : EditProfile
    Created on : Jan 5, 2021, 8:34:34 PM
    Author     : Omar
--%>

<%@page import="java.sql.Statement"%>
<%@page import="com.org.DataBaseConnection"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<a href="../src/java/searchstudent.java"></a>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%   
            String username =  session.getAttribute("username").toString();
           String password = session.getAttribute("password").toString();
           String phone = session.getAttribute("phone").toString();
           int age = Integer.parseInt(session.getAttribute("age").toString().trim()) ;
           String fname = session.getAttribute("fname").toString();
           String lname = session.getAttribute("lname").toString();
           
        %>
      <form action="EditProfile" method="post">
        <div>
             <h1> Edit Profile</h1>
              
             <label> First Name </label> <br>
             <input type="text" name="fname" required onkeydown="return alphaOnly(event);"  value=<%= fname %> > <br>
             <label> Last Name </label> <br>
             <input type="text" name="lname" required onkeydown="return alphaOnly(event);" value=<%= lname %>  > <br>
             <label> Age </label> <br>
             <input type="number" name="age" required value=<%= age %> max="80" min="18" > <br>
                  <label> Phone Number </label> <br>
                  <input type="text" name="phone" required value=<%= phone %> minlength="11" maxlength="11"> <br>
             <label>Password</label> <br> 
             <input type="text" name="password" required value=<%= password%> maxlength="9" minlength="9"> <br>
             <label>Remember Me</label> <input type="checkbox" class="checkbox"> <br>
             <a href="index.html"> Sign Up?</a> <br>
             <button class="edit">EDIT</button>
      
            
            
        </div>
        
        </form>
        
        
        <style>
            div{
                               background-color: #11484D;

                    box-shadow: 2px 2px 20px 2px black ;
                    padding: 0px 0px 100px 30px ;
            }
            h2{
                 color:red;
                font-size: 50px;
               margin : -170px 0 0 160px  ;
            }
            h1{
                color:#87701B;
                font-size: 50px;
                padding : 40px 0 0 140px  ;
            }
            body{
                background-color:  #246B71 ;
                margin: 30px 640px ;
               
            }
               input {
                   padding-right: 30px;
                background-color: #226B71;
                text-align: center;
                min-height: 40px;
                min-width: 520px;
                margin: 0 10px 25px 10px ;
                border: 1px solid #11484D    ;
                border-radius: 5px;
            }
               label{
                opacity: 0.8;
                margin-left: 20px;
                font-weight: bold;
                font-size: 20px;
                color:#F1FFFF;
            }
            .edit{
                margin-top: 60px;
                padding: 10px 260px;
                background-color: #E99406;
                color: #F1FFFF;
                border: 1px solid #E99406 ; 
                border-radius: 10px;
                font-weight: bold;
                font-size: 18px;
                text-align: center;
                
            }
            a{
               text-decoration: none ;
               margin-left: 230px;
               margin-top: 20px;
               position: absolute;
               color: #87701B;
               font-weight: bold;
               font-size: 20px;

            }
            .checkbox{
                min-width: 0px;
                padding: 0px 0px ;
                min-height: 0px;
            }
          
        </style>
        <script>
            
            function alphaOnly(event) {
  var key = event.keyCode;
  return ((key >= 65 && key <= 90) || key == 8);
};
            
            
        </script>
    </body>
</html>
