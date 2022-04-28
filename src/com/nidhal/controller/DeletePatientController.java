package com.nidhal.controller;

import com.nidhal.model.DataBaseConnecction;
import com.nidhal.view.ViewFactory;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.sql.Connection;
import java.sql.SQLException;

public class DeletePatientController extends BaseController {


    public DeletePatientController(ViewFactory viewFactory, String fxmlName) {
        super(viewFactory, fxmlName);
    }

    @FXML
    private Button btndelete ;

    @FXML
    private Label messagelabel , welcomelabel;

    @FXML
    private TextField textfieldforCin;

    @FXML
    void deletePatient() {

        int idNumber;
        idNumber = Integer.parseInt(textfieldforCin.getText());
        if (idNumber < 100000000 || idNumber > 9999999) {
            try {
                Connection con = DataBaseConnecction.getDataBaseConnection();
                String sql = "delete from patients_info where id = " + "'" + idNumber + "'";
                int roweffected = con.createStatement().executeUpdate(sql);
                messagelabel.setText("DELETED SUCCESS ");

              //  messagelabel.wait(3000);
              //  messagelabel.setText("");

            } catch (SQLException ex) {
                ex.printStackTrace();
            } catch (NumberFormatException E) {
                messagelabel.setText("SET A CORRECT CIN NUMBER ");
            }
        }
        else
            messagelabel.setText("ONLY 8 NUMBERS");


    }
}

