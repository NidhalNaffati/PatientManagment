package com.nidhal.controller;


import com.nidhal.model.DataBaseConnecction;
import com.nidhal.view.ViewFactory;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;


public class AddPatientController extends BaseController {
    
    public AddPatientController(ViewFactory viewFactory, String fxmlName) {
        super(viewFactory, fxmlName);
    }

    @FXML
    private Button btnadd;

    @FXML
    private Label Messagelabel , cinlabel , firstnamelelabel ,
            locationlaber , phonenumberlabel , scencelabel ,secondnamelabel;

    @FXML
    private TextField textFieldForId, textFieldForFirstName,textFieldForLocation ,
            textFieldForphoneNumber , textFieldForLastName;


    @FXML
    void addPatient()  {

        String firstName;        firstName = textFieldForFirstName.getText();
        String lastName;         lastName = textFieldForLastName.getText();
        String location ;        location=  textFieldForLocation.getText() ;
        int id;                  id = Integer.parseInt(textFieldForId.getText());
        int phoneNumber ;        phoneNumber =  Integer.parseInt(textFieldForphoneNumber.getText());


      //  Patient patient = new Patient(cinnumber,firstname,secondname,phonenumber,location);

      //  if (firstName != ""|| lastName != "" || location != "")
        //    if (cinnumber < 100000000 && cinnumber > 9999999 )
          //      if(    phonenumber  < 100000000 && phonenumber > 9999999   )
            try {
                Connection con = DataBaseConnecction.getDataBaseConnection();
                String info = "'" + id + "' , '" + firstName + "' , '" + lastName + "' , '  " + phoneNumber + "' , '" + location + " ' ";
                String sql = "insert into patients_info values (" + info + ") ";
                int roweffected = con.createStatement().executeUpdate(sql);
                Messagelabel.setText("PATEINT ADDED SUCESSFULY");
            } catch (NumberFormatException E) {
                E.getCause();
            } catch (SQLIntegrityConstraintViolationException E) {
                Messagelabel.setText("CIN NUMBER EXEST");
            } catch (SQLException E) {
                E.printStackTrace();
            } catch (Exception E) {
                E.printStackTrace();
            }
     //   else
       //     Messagelabel.setText("ERROR");
    }
}

