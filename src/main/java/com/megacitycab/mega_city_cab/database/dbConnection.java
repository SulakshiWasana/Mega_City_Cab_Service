package com.megacitycab.mega_city_cab.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class dbConnection {
    // Static instance of the class
    private static dbConnection instance;
    private Connection connection;

    // Database connection details
    private static final String URL = "jdbc:mysql://localhost:3306/megacitycab?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "Sula@123";

    // Private constructor to prevent instantiation
    private dbConnection() {
        try {
            // Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Create the database connection
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to initialize database connection.");
        }
    }

    // Static method to get the singleton instance
    public static dbConnection getInstance() {
        if (instance == null) {
            synchronized (dbConnection.class) {
                if (instance == null) {
                    instance = new dbConnection();
                }
            }
        }
        return instance;
    }

    // Method to get the database connection
    public Connection getConnection() {
        return connection;
    }
}
