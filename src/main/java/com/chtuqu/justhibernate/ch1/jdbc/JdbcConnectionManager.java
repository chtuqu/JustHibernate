package com.chtuqu.justhibernate.ch1.jdbc;

import java.sql.*;

public class JdbcConnectionManager {
    private static Connection connection;

    private static String url = "jdbc:mysql://localhost:3306/jh?useSSL=false";
    private static String driverClass = "com.mysql.jdbc.Driver";
    private static String username = "idea";
    private static String password = "ideapass";

    static {
        establishConnection();
    }

    private JdbcConnectionManager() { }

    private static void establishConnection() {
        try {
            Class.forName(driverClass).newInstance();
            connection = DriverManager.getConnection(url, username, password);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static Connection getConnection() {
        return connection;
    }
}
