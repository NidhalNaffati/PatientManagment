package com.nidhal;

import com.nidhal.view.ViewFactory;
import javafx.application.Application;
import javafx.stage.Stage;

public class Launcher extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        ViewFactory viewFactory = new ViewFactory();
        viewFactory.showLoginWindow();
    }


    public static void main(String[] args) {
        launch();
    }
}
