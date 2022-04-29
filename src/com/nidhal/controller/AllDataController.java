package com.nidhal.controller;


import com.nidhal.model.DataBaseConnecction;
import com.nidhal.model.Patient;
import com.nidhal.view.ViewFactory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class AllDataController extends BaseController implements Initializable {

    public AllDataController(ViewFactory viewFactory, String fxmlName) {
        super(viewFactory, fxmlName);
    }

    @FXML
    private TableView<Patient> tableViewForPatient;

    @FXML
    private TableColumn<Patient, Integer> idCall;

    @FXML
    private TableColumn<Patient, String> firstNameCall;

    @FXML
    private TableColumn<Patient, String> lastNameCall;

    @FXML
    private TableColumn<Patient, String> locationCall;

    @FXML
    private TableColumn<Patient, Integer> phoneNumberCall;

    @FXML
    private Button btnSearch;

    @FXML
    private TextField textFieldForSearch;


    ObservableList<Patient> patientList = FXCollections.observableArrayList() ;

    public void showData(){
        try {

            Connection con = DataBaseConnecction.getDataBaseConnection();
            ResultSet result = con.createStatement().executeQuery("select * from patients_info ");

            while (result.next()) {
                patientList.add(new Patient(
                        result.getInt("id") ,
                        result.getString("firstName") ,
                        result.getString("lastName") ,
                        result.getInt("phoneNumber") ,
                        result.getString("location") ));
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        idCall.setCellValueFactory(new PropertyValueFactory<>("id"));
        firstNameCall.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        lastNameCall.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        phoneNumberCall.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
        locationCall.setCellValueFactory(new PropertyValueFactory<>("location"));

        tableViewForPatient.setItems(patientList);
    }


    @FXML
    void refreshData() {
        patientList.clear();
        showData();
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        showData();
    }



    @FXML
    void searchForPatient( ) {
        int idNumber = 0;
        try {
            idNumber = Integer.parseInt(textFieldForSearch.getText());
        }catch (NumberFormatException ex) {}
       
        try {
            Connection con = DataBaseConnecction.getDataBaseConnection();
            ResultSet result = con.createStatement().executeQuery("select * from patients_info where id =  " + idNumber);

            patientList.clear();

            while (result.next()) {
                patientList.add(new Patient(
                        result.getInt("id") ,
                        result.getString("firstName") ,
                        result.getString("lastName") ,
                        result.getInt("phoneNumber") ,
                        result.getString("location") ));
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        idCall.setCellValueFactory(new PropertyValueFactory<>("id"));
        firstNameCall.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        lastNameCall.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        phoneNumberCall.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
        locationCall.setCellValueFactory(new PropertyValueFactory<>("location"));
        tableViewForPatient.setItems(patientList);

    }
}
