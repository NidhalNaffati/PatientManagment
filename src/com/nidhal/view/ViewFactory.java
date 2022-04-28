package com.nidhal.view;

import com.nidhal.controller.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.util.ArrayList;
public class ViewFactory {


    private final ArrayList<Stage> activeStages;

    public ViewFactory() {
        activeStages = new ArrayList<Stage>();
    }

    public void showAllData() {
        BaseController controller = new AllDataController(this, "fxml/ShowData.fxml");
        initializeStage(controller);
    }

    public void showLoginWindow() {
        BaseController controller = new LoginPageController(this, "fxml/loginWindow.fxml");
        initializeStage(controller);
    }

    public void showDeletePatient() {
        BaseController controller = new DeletePatientController(this, "fxml/DeletePatientWindow.fxml");
        initializeStage(controller);
    }

    public void showAddPatientWindow() {
        BaseController controller = new AddPatientController(this, "fxml/AddPatientWindow.fxml");
        initializeStage(controller);
    }

    public void showModifyPatientWindow() {
        BaseController controller = new ModifyPatientController(this, "fxml/ModifyPatient.fxml");
        initializeStage(controller);
    }

    public void showOptionWindow() {
        BaseController controller = new OptionsController(this, "fxml/OptionWindow.fxml");
        initializeStage(controller);
    }


    // VIEW OPTION HANDELING

    private ColorTheme colorTheme = ColorTheme.DARK;
    private FontSize fontSize = FontSize.BIG;

    public ColorTheme getColorTheme() {
        return colorTheme;
    }

    public void setColorTheme(ColorTheme colorTheme) {
        this.colorTheme = colorTheme;
    }

    public FontSize getFontSize() {
        return fontSize;
    }

    public void setFontSize(FontSize fontSize) {
        this.fontSize = fontSize;
    }


    private void initializeStage(BaseController baseController) {
        System.out.println(getClass().getResource(baseController.getFxmlFile()));
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(baseController.getFxmlFile()));
        fxmlLoader.setController(baseController);
        Parent parent;
        try {
            parent = fxmlLoader.load();
            Scene scene = new Scene(parent);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setResizable(false);
            scene.getStylesheets().add(getClass().getResource("css/themeDark.css").toExternalForm());
            Image iconImage = new Image(getClass().getResourceAsStream("images/DoctorImage.png"));
            stage.getIcons().add(iconImage);
            stage.setScene(scene);
            stage.setTitle("PATIENT MANAGMENT ");
            stage.show();
            activeStages.add(stage);
        } catch (IllegalArgumentException e) {
            e.getCause();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void closeStage(Stage stageToClose) {
        stageToClose.close();
        activeStages.remove(stageToClose);
    }

    public void updateStyles() {
        for (Stage stage : activeStages) {
            Scene scene = stage.getScene();
            scene.getStylesheets().clear();
            scene.getStylesheets().add(getClass().getResource(ColorTheme.getCssPath(colorTheme)).toExternalForm());
            scene.getStylesheets().add(getClass().getResource(FontSize.getCssPath(fontSize)).toExternalForm());
        }
    }

}

