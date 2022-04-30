package com.nidhal.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnecction {
    public static Connection getDataBaseConnection() throws SQLException {
        String databaseName = "demo" ;
        String url = "jdbc:mysql://localhost:3306/"+databaseName+"?";
        String user = "doctor" ;
        String password = "NIDnaf012" ;

        Connection databaseConnection = DriverManager.getConnection(url, user, password);
        return databaseConnection;
    }
}
