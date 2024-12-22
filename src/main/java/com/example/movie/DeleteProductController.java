package com.example.movie;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class DeleteProductController {

    @FXML
    private Button Delete;

    @FXML
    private TextField MovieName;

    @FXML
    private Button Return;

    @FXML
    private Button ViewMovies;

    @FXML
    private void handleDeleteProduct(ActionEvent event) {
        String movieName = MovieName.getText().trim();

        if (movieName.isEmpty()) {
            showAlert(Alert.AlertType.ERROR, "Validation Error", "Movie name cannot be empty.");
            return;
        }

        Product movieToDelete = null;
        for (Product product : MovieStoreDatabase.products) {
            if (product.getName().equalsIgnoreCase(movieName)) {
                movieToDelete = product;
                break;
            }
        }

        if (movieToDelete != null) {
            MovieStoreDatabase.products.remove(movieToDelete);
            MovieStoreDatabase.saveData();



            showAlert(Alert.AlertType.INFORMATION, "Success", "Movie deleted successfully!");
            clearFields();
        } else {
            showAlert(Alert.AlertType.ERROR, "Error", "Movie not found in the database.");
        }
    }

    private void showAlert(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    private void clearFields() {
        MovieName.clear();
    }

    @FXML
    private void handleViewMovies(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("viewProducts.fxml"));
            Parent root = loader.load();

            // Set up the scene with specified size and CSS styling
            Scene scene = new Scene(root, 800, 600);
            scene.getStylesheets().add(getClass().getResource("BG3.css").toExternalForm());

            // Set the new scene on the current stage
            Stage stage = (Stage) ViewMovies.getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            showAlert(Alert.AlertType.ERROR, "Error", "Failed to load the View Movies page.");
        }
    }

    @FXML
    private void handleReturn(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("WelcomeAdmin.fxml"));
            Parent root = loader.load();

            // Set up the scene with specified size and CSS styling
            Scene scene = new Scene(root, 800, 600);
            scene.getStylesheets().add(getClass().getResource("BG3.css").toExternalForm());

            // Set the new scene on the current stage
            Stage stage = (Stage) Return.getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            showAlert(Alert.AlertType.ERROR, "Error", "Failed to load the Main Menu page.");
        }
    }

}
