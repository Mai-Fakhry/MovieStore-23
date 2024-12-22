package com.example.movie;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

import static com.example.movie.MovieStoreDatabase.currentCustomer;

public class ViewCart {

    @FXML
    private VBox cartItemsVBox;  // VBox to display items in the cart

    @FXML
    private Button payButton;  // Payment button

    @FXML
    private Button yesButton;  // Yes button for confirmation

    // Initialize the cart by displaying items from the current customer's cart
    @FXML
    public void initialize() {
        // Clear any previous cart items from the view
        cartItemsVBox.getChildren().clear();

        // Check if the current customer exists and has a cart
        if (currentCustomer != null && currentCustomer.getCart() != null) {
            Cart customerCart = currentCustomer.getCart();  // Get the customer's cart

            // Check if the cart is not empty
            if (customerCart.getElementsInCart() > 0) {
                // Display each item in the cart
                for (int i = 0; i < customerCart.getElementsInCart(); i++) {
                    Product product = customerCart.getProducts()[i];
                    Text productText = new Text(product.getName() + " - $" + product.getPrice());
                    cartItemsVBox.getChildren().add(productText);
                }
            } else {
                // Display a message if the cart is empty
                Text emptyMessage = new Text("Your cart is empty.");
                cartItemsVBox.getChildren().add(emptyMessage);
            }
        } else {
            showAlert(AlertType.ERROR, "Error", "No customer found or no cart linked.");
        }
    }

    // Handle the payment button click (simplified)
    @FXML
    void handlePayment(ActionEvent event) {
        // Check if the current customer and their cart exist
        if (currentCustomer != null && currentCustomer.getCart() != null) {
            Cart customerCart = currentCustomer.getCart();

            // Check if the cart has items
            if (customerCart.getElementsInCart() > 0) {
                // Calculate the total price of the cart items
                double totalPrice = 0;
                for (int i = 0; i < customerCart.getElementsInCart(); i++) {
                    totalPrice += customerCart.getProducts()[i].getPrice();
                }

                // Show an alert with the total price
                showAlert(AlertType.INFORMATION, "Payment Total", "Your total payment is $" + totalPrice);
               // Remove items from the VBox (clear cart view)
                cartItemsVBox.getChildren().clear();  // This will clear the VBox

                // Optional: Update cart or customer state if needed, for example, marking items as paid, or emptying the cart
                customerCart.clearCart(); // You might need a method to clear the cart items
                // Switch to the Payment page (or any other page)
                switchScene("Payment.fxml");
            } else {
                // Show an error if the cart is empty
                showAlert(AlertType.ERROR, "Empty Cart", "Your cart is empty. Add items to the cart before proceeding.");
            }
        } else {
            // Show an error if there is no customer or cart
            showAlert(AlertType.ERROR, "Error", "No customer found or no cart linked.");
        }
    }

    // Handle the 'Yes' button click (confirmation of the action)
    @FXML
    void handleConfirmation(ActionEvent event) {
        // Switch to another page (e.g., AddToCart)
        switchScene("AddToCart.fxml");
    }

    // Helper method to show alerts with custom content
    private void showAlert(AlertType alertType, String title, String content) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setContentText(content);
        alert.showAndWait();
    }

    // Helper method to switch between scenes
    private void switchScene(String fxmlFile) {
        try {
            // Get the current stage from the event source (using payButton)
            Stage stage = (Stage) payButton.getScene().getWindow();  // Using payButton instead of yesButton

            // Load the new FXML file and apply the CSS styles
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFile));
            Scene scene = new Scene(loader.load(), 800, 600);
            scene.getStylesheets().add(getClass().getResource("BG3.css").toExternalForm());

            // Set the new scene to the stage
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            showAlert(AlertType.ERROR, "Scene Load Error", "Error loading scene: " + fxmlFile);
        }
    }
}
