package com.example.movie;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.geometry.Rectangle2D;
import javafx.stage.Screen;

import java.io.IOException;

public class LoginApplication extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        // Load FXML layout
        FXMLLoader fxmlLoader = new FXMLLoader(LoginApplication.class.getResource("login.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 400, 550);  // Initial window size
        scene.getStylesheets().add(getClass().getResource("BG3.css").toExternalForm());

        // Set title for the window
        stage.setTitle("Login");

        // Set the scene and ensure the window is centered
        stage.setScene(scene);


        // Show the window
        stage.show();

       stage.setResizable(false);
    }



    public static void main(String[] args) {
        launch();
    }
}
