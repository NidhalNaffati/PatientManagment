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
    private Button btnDelete ;

    @FXML
    private Label messageLabel , welcomeLabel;

    @FXML
    private TextField textFieldForId;

    @FXML
    void deletePatient() {
        int idNumber = 0;
        try {
            idNumber = Integer.parseInt(textFieldForId.getText());
        } catch (NumberFormatException ex) {
            messageLabel.setText("PLEASE ENTER A NUMERIC VALUE");
        }
            try {
                Connection con = DataBaseConnecction.getDataBaseConnection();
                String sql = "delete from patients_info where id = " + "'" + idNumber + "'";
                int roweffected = con.createStatement().executeUpdate(sql);
                messageLabel.setText("DELETED SUCCESS ");

              //  messagelabel.wait(3000);
              //  messagelabel.setText("");

            } catch (SQLException ex) {
                ex.printStackTrace();
            } catch (NumberFormatException E) {
                messageLabel.setText("SET A CORRECT CIN NUMBER ");
            }
        }
}

