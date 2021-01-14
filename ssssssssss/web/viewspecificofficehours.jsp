<%-- 
    Document   : viewspecificofficehours
    Created on : Jan 13, 2021, 1:58:09 AM
    Author     : dell
--%>
<%@page import="java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
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


    <% String day, r, d;
        int from, to;

        HttpSession session1 = request.getSession();
        String staffName = session1.getAttribute("username").toString();
        String s = request.getParameter("dayselect");

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
        <%                while (rs.next()) {
                String username = rs.getString("username");
                r = rs.getString("state");
                d = rs.getString("day");
                if (username.equals(staffName) && r.equals("registered") && d.equals(s)) {
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

    <%}
        }%>
    <form action="staff.jsp">
        <table>
            <tr>

                <td><input type="submit" value="return"></td>
            </tr>
        </table>
    </form>
</body>

</html>
