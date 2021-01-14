package com.org;

import java.sql.*;

public class DataBaseConnection {

    public static Connection initializeDatabase()
            throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        String dbURL = "jdbc:mysql://localhost:3306/";
        String dbName = "webproject";
        String dbUsername = "root";
        String dbPassword = "root";

        Connection con = DriverManager.getConnection(dbURL + dbName,
                dbUsername,
                dbPassword);
        return con;
    }
}
