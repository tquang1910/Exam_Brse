package com.vti.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCUTILS {
    private static Connection connection;

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        if (connection == null || connection.isClosed()) {
            String url = "jdbc:mysql://localhost:3306/final_exam?autoReconnect=true&useSSL=false&characterEncoding=latin1";
            String username = "root";
            String password = "root";

            // Step 1* register the driver class with DriverManager
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: get a Database Connection

            connection = DriverManager.getConnection(url, username, password);
//            System.out.println("Connection success! " + connection);
        }

        return connection;
    }

    public static void disconnect() throws SQLException {
        if (connection != null || !connection.isClosed()) {
            connection.close();
        }
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        if (connection != null || !connection.isClosed()) {
            connection.close();
        }
    }
}
