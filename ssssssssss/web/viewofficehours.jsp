<%-- 
    Document   : viewofficehours
    Created on : Jan 12, 2021, 9:54:35 PM
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
            String day , r;
            int from , to;
        
       
        
            HttpSession session1 = request.getSession();
            String staffName = session1.getAttribute("username").toString();
            
           
               
                
                Class.forName("com.mysql.jdbc.Driver").newInstance();
                Connection Con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/webproject", "root", "root");
                Statement stmt = (Statement) Con.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM officehours ;");
            
        %>
        <table>
            <tr border="4">
                <th>Day</th>
                <th>From</th>
                <th>To</th>
            </tr>
            <%
                while(rs.next()){
                    String username = rs.getString("username");
                    r=rs.getString("state");
                    if(username.equals(staffName)&&r.equals("registered")){              
            %>
            <tr>
                <td>
                    <%
                        day = rs.getString("day");
                        out.println(day);
                    %>
                </td>
                <td>
                    <%
                        from = rs.getInt("fromhours");
                        out.println(from);
                    %>
                </td>
                <td>
                    <%
                       to = rs.getInt("tohours");
                        out.println(to);
                    %>
                </td>
            </tr>
        </table>
                    <form action="staff.jsp">
            <table>
                <tr>
                    
                    <td><input type="submit" value="return"></td>
                </tr>
            </table>
        </form>
        <%}}%>
       
    </body>
