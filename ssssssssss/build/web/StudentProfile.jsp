<%-- 
    Document   : Profile
    Created on : Jan 5, 2021, 7:58:57 PM
    Author     : Omar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
   <body>
       
        <h1><a href="EditProfile.jsp"> Edit Profile</a></h1>
        <h1><a href="OfficeHour.jsp">View Office Hours</a></h1>
        <h1><a href="appointment.jsp">Reserve an appointment</a></h1>
        <h1><a href="cancelAppointment.jsp">Cancel an appointment</a></h1>
        <h1><a href="sendMessage.jsp">Send message</a></h1>
        
        <form action="SearchForStaffSubject" method="post">
            <button type="submite">search</button>
        </form>
        <form action="GetStaffConact" method="post">
            <label> Enter the staff member UserNAme </label> <input type="text" required name="staffmemberusername">
            <button type="submite"> search</button>
        </form>
        
        
        
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
    </body>
</html>
  