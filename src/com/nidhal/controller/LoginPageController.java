package com.nidhal.controller;


import com.nidhal.model.DataBaseConnecction;
import com.nidhal.view.ViewFactory;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class LoginPageController extends BaseController {

    public LoginPageController(ViewFactory viewFactory, String fxmlName) {
        super(viewFactory, fxmlName);
    }

    @FXML
    private Button btnAdd;

    @FXML
    private Button btnAllData;

    @FXML
    private Button btnDelete;

    @FXML
    private Button btnModify;

    @FXML
    private Button btnOption;

    @FXML
    private Button btnsubmit;

    @FXML
    private Label messageLabel;

    @FXML
    private Label patientFullName;

    @FXML
    private TextField textFieldForId;

    @FXML
    private Label welcomelabel;


    @FXML
    void showdata() {
        viewFactory.showAllData();
    }

    @FXML
    void addPatient() {
        viewFactory.showAddPatientWindow();
    }

    @FXML
    void modifyPatient() {
        viewFactory.showModifyPatientWindow();
    }

    @FXML
    void option() {
        viewFactory.showOptionWindow();
    }

    @FXML
    void deletePatient() {
        viewFactory.showDeletePatient();
    }



    @FXML
    public void checkId(){
        int idNumber = 0;
        try {
            idNumber = Integer.parseInt(textFieldForId.getText());
        } catch (NumberFormatException ex) {
            messageLabel.setText("PLEASE ENTER A NUMERIC VALUE");
        }
        try {
            Connection con = DataBaseConnecction.getDataBaseConnection();
            Statement statement = con.createStatement();
            String sql = "select firstName , lastName from patients_info where id = " + idNumber;
            ResultSet result = statement.executeQuery(sql);
            while (result.next())
                patientFullName.setText(result.getString("firstName") + " " + result.getString("lastName"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (patientFullName.getText().isEmpty()&& messageLabel.getText().isEmpty())
            messageLabel.setText("THERE IS NO PATIENT WITH THIS ID NUMBER");
    }


}

            /*
            *
            *
            *
            DatabaseMetaData dbMetaData = databaseConnection.getMetaData();
            System.out.println("database URL: " + dbMetaData.getURL());
            System.out.println("database username: " + dbMetaData.getUserName());
            System.out.println("database product name: " +dbMetaData.getDatabaseProductName());
            System.out.println("database product version: " + dbMetaData.getDatabaseProductVersion());
            System.out.println("JDBC driver name: " + dbMetaData.getDriverName());
            System.out.println("JDBC driver version: " + dbMetaData.getDriverVersion());
            System.out.println("JDBC driver major version: " + dbMetaData.getDriverMajorVersion());
            System.out.println("JDBC driver minor version: " + dbMetaData.getDriverMinorVersion());
            System.out.println("Max number of connections: " + dbMetaData.getMaxConnections());
            System.out.println("MaxTableNameLength: " + dbMetaData.getMaxTableNameLength());
            System.out.println("MaxColumnsInTable: " + dbMetaData.getMaxColumnsInTable());
            System.out.println("getclass: " + dbMetaData.getClass());
            System.out.println(" get connectio " + dbMetaData.getConnection());
            System.out.println("clients info " + dbMetaData.getClientInfoProperties());
            System.out.println("max row size  " + dbMetaData.getMaxRowSize());
            System.out.println(" mzxtablename leneght " + dbMetaData.getMaxTableNameLength());
            System.out.println(" systeminfo " + dbMetaData.getSystemFunctions());
               *
               *
               *
               */


