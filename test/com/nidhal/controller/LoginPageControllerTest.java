package com.nidhal.controller;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.sql.*;

import static org.junit.jupiter.api.Assertions.*;

class LoginPageControllerTest {




/*

    @TestInstance()
    void setup() throws SQLException {
        databaseConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo?serverTimezone=GMT", "doctor", "NIDnaf012");
        System.out.println("Starting test ... \n Connecting to the data base  ");
    }
*/

    @Test
    void testSelect() throws SQLException {
        Connection databaseConnection ;
        databaseConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo?serverTimezone=GMT", "doctor", "NIDnaf012");
        int id = 14704001 ;
        try {
            Statement statement = databaseConnection.createStatement();
            String sql = "select * from patients_info where id = " + id;
            ResultSet result = statement.executeQuery(sql);
            while (result.next()) {
                System.out.println(result.getString(2) + " " + result.getString(3));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        assertEquals("nidhal naffati ","nidhal naffati " );

    }

}