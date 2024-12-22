package com.example.movie;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class RegistrationApplication extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        // Load the FXML file for the registration form
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Register.fxml"));

        Scene scene = new Scene(fxmlLoader.load(), 400, 550);
        scene.getStylesheets().add(getClass().getResource("BG3.css").toExternalForm());// Rename to your stylesheet name if needed

        // Set window title
        stage.setTitle("User Registration");

        // Make window non-resizable for consistency
        stage.setResizable(false);

        // Set the scene and show the window
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        // Launch the JavaFX application
        launch();
    }
}
