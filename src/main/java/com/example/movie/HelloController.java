package com.example.movie;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import java.io.IOException;

public class HelloController {

    @FXML
    private Button log;

    @FXML
    private Button newAcc;

    @FXML
    private void initialize() {
        log.setOnAction(event -> switchScene("login.fxml")); // Scene for "Log"
        newAcc.setOnAction(event -> switchScene("Register.fxml")); // Scene for "New Account"
    }

    private void switchScene(String fxmlFile) {
        try {
            // Get the current stage
            Stage stage = (Stage) log.getScene().getWindow();

            // Load the new scene
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(fxmlFile));
            Scene scene = new Scene(fxmlLoader.load(), 400, 550);
            scene.getStylesheets().add(getClass().getResource("BG3.css").toExternalForm());
            // Set the new scene on the stage
            stage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
