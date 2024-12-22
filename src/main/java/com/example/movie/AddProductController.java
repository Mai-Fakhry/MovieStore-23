package com.example.movie;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class AddProductController {

    @FXML
    private ComboBox<String> Category;

    @FXML
    private TextField Name;

    @FXML
    private TextField Price;

    @FXML
    private TextField SerialNumber;

    @FXML
    private Button Return;

    @FXML
    private Button ViewMovies;

    @FXML
    private Button add;

    @FXML
    private void handleAddProduct(ActionEvent event) {
        try {
            if (Name.getText().isEmpty() || Price.getText().isEmpty() || SerialNumber.getText().isEmpty() || Category.getValue() == null) {
                showAlert(Alert.AlertType.ERROR, "Validation Error", "All fields must be filled.");
                return;
            }

            double price;
            try {
                price = Double.parseDouble(Price.getText());
                if (price <= 0) throw new NumberFormatException();
            } catch (NumberFormatException e) {
                showAlert(Alert.AlertType.ERROR, "Validation Error", "Price must be a positive number.");
                return;
            }

            int serialNumber;
            try {
                serialNumber = Integer.parseInt(SerialNumber.getText());
                if (serialNumber <= 0) throw new NumberFormatException();
            } catch (NumberFormatException e) {
                showAlert(Alert.AlertType.ERROR, "Validation Error", "Serial number must be a positive integer.");
                return;
            }

            Product newProduct = new Product(serialNumber, Name.getText(), price, Category.getValue());
            MovieStoreDatabase.addProduct(newProduct);
            MovieStoreDatabase.saveData();


            showAlert(Alert.AlertType.INFORMATION, "Success", "Movie added successfully!");
            clearFields();
        } catch (Exception e) {
            showAlert(Alert.AlertType.ERROR, "Error", "An unexpected error occurred: " + e.getMessage());
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
        Name.clear();
        Price.clear();
        SerialNumber.clear();
        Category.setValue(null);
    }

    @FXML
    private void handleViewMovies(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("viewProducts.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root, 800, 600); // Set the scene size
            scene.getStylesheets().add(getClass().getResource("BG3.css").toExternalForm()); // Add CSS styling
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
            Scene scene = new Scene(root, 800, 600); // Set the scene size
            scene.getStylesheets().add(getClass().getResource("BG3.css").toExternalForm()); // Add CSS styling
            Stage stage = (Stage) Return.getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            showAlert(Alert.AlertType.ERROR, "Error", "Failed to load the Main Menu page.");
        }
    }

}
