package com.nidhal;


/**
 * @author Nidhal Naffati
 * Date : 03-April-2022
 */

import com.nidhal.view.ViewFactory;
import javafx.application.Application;
import javafx.stage.Stage;

public class Launcher extends Application {
    @Override
    public void start(Stage stage)  {
        ViewFactory viewFactory = new ViewFactory();
        viewFactory.showLoginWindow();
    }


    public static void main(String[] args) {
        launch();
    }
}
