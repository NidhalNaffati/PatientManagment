package com.nidhal.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnecction {
    public static Connection getDataBaseConnection() throws SQLException {
        Connection databaseConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo?serverTimezone=GMT", "doctor", "NIDnaf012");
        return databaseConnection;
    }
}
