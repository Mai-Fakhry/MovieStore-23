package com.example.movie;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.IOException;

import static com.example.movie.MovieStoreDatabase.currentCustomer;

public class AddToCart {

    @FXML
    private Button addButton;  // "Add to Cart" button

    @FXML
    private TextField movieNameField;  // TextField to enter movie name

    @FXML
    private Button viewCartButton;  // "View Cart" button

    /**
     * Handles the event when the "Add to Cart" button is clicked.
     * It validates the input and adds the movie to the customer's cart if valid.
     */
    @FXML
    private void handleAddToCart(ActionEvent event) {
        String movieName = movieNameField.getText().trim();

        // Validate if movie name is provided
        if (movieName.isEmpty()) {
            showAlert(AlertType.ERROR, "Invalid Input", "Please enter a movie name.");
            return;
        }

        // Check if the movie exists in the catalog
        boolean movieFound = false;
        for (Product movie : MovieStoreDatabase.products) {
            if (movie.getName().equalsIgnoreCase(movieName)) {
                // Add the movie to the cart (assuming the cart is maintained at the customer level)
                if (currentCustomer != null && currentCustomer.getCart() != null) {
                    currentCustomer.getCart().addItem(movie.getName());
                    showAlert(AlertType.INFORMATION, "Added to Cart", "Movie has been added to your cart!");
                } else {
                    showAlert(AlertType.ERROR, "Cart Error", "No customer or cart found.");
                }
                movieFound = true;
                break;
            }
        }

        if (!movieFound) {
            showAlert(AlertType.ERROR, "Movie Not Found", "No movie found with the provided name.");
        }
    }
    @FXML
    private void handleReturnButtonAction(ActionEvent event) {
        try {
            // Get the current stage (window) and switch to the Welcome page (or the desired page)
            Stage stage = (Stage) addButton.getScene().getWindow(); // Get the current stage from the addButton or any other UI element
            FXMLLoader loader = new FXMLLoader(getClass().getResource("WelcomeCustomer.fxml")); // Adjust this path as needed
            Scene scene = new Scene(loader.load(), 800, 600);
            scene.getStylesheets().add(getClass().getResource("BG3.css").toExternalForm());
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            showAlert(AlertType.ERROR, "Scene Load Error", "Error loading the Welcome page.");
        }
    }

    /**
     * Handles the event when the "View Cart" button is clicked.
     * Navigates to the ViewCart page.
     */
    @FXML
    private void handleViewCart(ActionEvent event) {
        try {
            // Get the current stage and switch to the ViewCart scene
            Stage stage = (Stage) viewCartButton.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ViewCart.fxml"));
            Scene scene = new Scene(loader.load(), 800, 600);
            scene.getStylesheets().add(getClass().getResource("BG3.css").toExternalForm());
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            showAlert(AlertType.ERROR, "Scene Load Error", "Error loading the ViewCart page.");
        }
    }

    /**
     * Displays an alert box with the specified type, title, and content.
     */
    private void showAlert(AlertType alertType, String title, String content) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setContentText(content);
        alert.showAndWait();
    }
}
