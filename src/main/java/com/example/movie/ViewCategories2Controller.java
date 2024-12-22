package com.example.movie;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ViewCategories2Controller {

    @FXML
    private void handleReturnButtonClick(ActionEvent event) {
        try {
            // Load the FXML for the previous page
            FXMLLoader loader = new FXMLLoader(getClass().getResource("WelcomeCustomer.fxml"));
            Parent root = loader.load();

            // Create a scene with specified dimensions and apply the CSS
            Scene scene = new Scene(root, 800, 600);
            scene.getStylesheets().add(getClass().getResource("BG3.css").toExternalForm());

            // Get the current stage and set the new scene
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
