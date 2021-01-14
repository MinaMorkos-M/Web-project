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
            String day , found;
            int from , to;
        %>
        <form action="ValidateStaffOfficeHours" method="POST">
            <table>
                <tr>
                    <td>Enter staff username</td>
                    <td><input type="text" name="staffName"></td>
                </tr>
                <tr>
                    <td><input type="submit" value="Enter"></td>
                    <td></td>
                </tr>
            </table>
        </form>
        <%
            HttpSession session1 = request.getSession();
            found = session1.getAttribute("staffFound").toString();
            out.print(found);
            if (found.equals("true")) {
                String staffName = session1.getAttribute("staffName").toString();
                
                Class.forName("com.mysql.jdbc.Driver").newInstance();
                Connection Con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/webproject", "root", "root");
                Statement stmt = (Statement) Con.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM officehours ;");
            
        %>
        <table>
            <tr>
                <th>Day</th>
                <th>From</th>
                <th>To</th>
            </tr>
            <%
               /* while(rs.next()){
                    String username = rs.getString("username");
                    if(username.equals(staffName)){               
            */%>
            <tr>
                <td>
                    <%
                        //day = rs.getString("day");
                        //out.println(day);
                    %>
                </td>
                <td>
                    <%
                        //from = rs.getInt("fromhours");
                        //out.println(from);
                    %>
                </td>
                <td>
                    <%
                        //to = rs.getInt("tohours");
                        //out.println(to);
                    %>
                </td>
            </tr>
        </table>
        <%//}}%>
       
    </body>
   
