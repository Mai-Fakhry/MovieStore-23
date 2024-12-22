package com.example.movie;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Alert;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class PaymentController {

    @FXML
    private RadioButton BANK_TRANSFERRadio;

    @FXML
    private RadioButton CASH_ON_DELIVERYRadio;

    @FXML
    private RadioButton CREDIT_CARDRadio;

    @FXML
    private RadioButton DEBIT_CARDRadio;

    @FXML
    private RadioButton PAYPALRadio;

    @FXML
    private Button done;

    private ToggleGroup Payment; // Declare the ToggleGroup

    @FXML
    public void initialize() {
        // Initialize the ToggleGroup and assign it to the radio buttons
        Payment = new ToggleGroup();
        CREDIT_CARDRadio.setToggleGroup(Payment);
        DEBIT_CARDRadio.setToggleGroup(Payment);
        PAYPALRadio.setToggleGroup(Payment);
        BANK_TRANSFERRadio.setToggleGroup(Payment);
        CASH_ON_DELIVERYRadio.setToggleGroup(Payment);
    }

    // Action handler for the "Done" button
    @FXML
    void handleDoneAction(ActionEvent event) {
        RadioButton selectedRadioButton = (RadioButton) Payment.getSelectedToggle();

        if (selectedRadioButton != null) {
            // Get the selected payment method text
            String selectedPaymentMethod = selectedRadioButton.getText();

            // Show an alert with the selected payment method
            showAlert("Payment Successful", "You have successfully paid using: " + selectedPaymentMethod);

            // Clear the cart after successful payment
            clearCart();

            // After the alert, navigate to the next page (e.g., "PaymentConfirmation.fxml")
            goToPage("WelcomeCustomer.fxml");
        } else {
            showAlert("Error", "Please select a payment method.");
        }
    }

    // Helper method to clear the cart (replace with your actual cart clearing logic)
    private void clearCart() {
        Customer currentCustomer = getCurrentCustomer();
        if (currentCustomer != null) {
            Cart cart = currentCustomer.getCart();
            cart.clearCart(); // Assuming Cart class has a clear() method
            showAlert("Cart Cleared", "Your cart has been cleared.");
        } else {
            showAlert("Error", "Could not retrieve customer information.");
        }
    }

    // Helper method to get the current customer (replace with your actual customer fetching logic)
    private Customer getCurrentCustomer() {
        return MovieStoreDatabase.customers.get(0); // Example: returning the first customer
    }

    // Helper method to show an alert dialog
    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    // Helper method to navigate to another page
    private void goToPage(String fxmlFile) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFile));
            Parent root = loader.load();

            // Create a scene with specified dimensions and apply the CSS
            Scene scene = new Scene(root, 800, 600);
            scene.getStylesheets().add(getClass().getResource("BG3.css").toExternalForm());

            // Get the current stage and set the new scene
            Stage stage = (Stage) done.getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            showAlert("Error", "Failed to load the page: " + fxmlFile);
        }
    }

}
