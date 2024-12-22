package com.example.movie;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class ViewWHController {

    @FXML
    private Button Return;

    // Method to handle the "Return" button click
    @FXML
    public void handleReturnButtonAction() {
        try {
            // Load the page to navigate to (replace "MainPage.fxml" with your desired page)
            FXMLLoader loader = new FXMLLoader(getClass().getResource("WelcomeAdmin.fxml")); // Ensure the correct path to MainPage.fxml
            Scene scene = new Scene(loader.load(), 800, 600); // Different dimensions for logout, if needed
            scene.getStylesheets().add(getClass().getResource("BG3.css").toExternalForm());

            // Get the current window (stage) and set the new scene
            Stage stage = (Stage) Return.getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error loading the return page.");
        }
    }
}
