package net.pixeleon.khpi.oop.shop24.view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Shop24FX extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        try {
            BorderPane parentNode = FXMLLoader.load(getClass().getResource("shop24Scheme.fxml"));
            Scene scene = new Scene(parentNode, 720,480);
            primaryStage.setScene(scene);
            primaryStage.setTitle("Shop24");
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
