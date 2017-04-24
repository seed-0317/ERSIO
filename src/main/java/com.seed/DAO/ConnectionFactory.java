package com.seed.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    private static final String URL = System.getenv("CONNECTIONURL");
    private static final String USERNAME = System.getenv("CONNECTIONUSER");
    private static final String PASSWORD = System.getenv("CONNECTIONPASSWORD");


    public static Connection createConnection() {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}

