package com.example.movie;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class RegistrationController {

    @FXML
    private TextField usernameField, addressField, interestsField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private DatePicker birthDatePicker;

    @FXML
    private ComboBox<String> genderComboBox;

    @FXML
    private Label errorLabel;

    @FXML
    private void handleRegistration() {
        String username = usernameField.getText();
        String password = passwordField.getText();
        String address = addressField.getText();
        String interestsText = interestsField.getText();

        // Validate inputs
        if (username.isEmpty() || password.isEmpty() || address.isEmpty() || interestsText.isEmpty() || genderComboBox.getValue() == null || birthDatePicker.getValue() == null) {
            errorLabel.setText("Please fill all fields.");
            errorLabel.setVisible(true);
            return;
        }

        // Parse the date of birth
        LocalDate localDate = birthDatePicker.getValue();
        if (localDate == null) {
            errorLabel.setText("Invalid Date of Birth.");
            errorLabel.setVisible(true);
            return;
        }

        // Parse interests
        List<String> interests = Arrays.asList(interestsText.split(","));

        // Get the gender from the ComboBox
        String genderInput = genderComboBox.getValue();
        Gender gender;
        try {
            gender = Gender.valueOf(genderInput.toUpperCase());
        } catch (IllegalArgumentException e) {
            errorLabel.setText("Invalid gender.");
            errorLabel.setVisible(true);
            return;
        }

        // Create the Customer object
        Customer newCustomer = new Customer(username, password, java.sql.Date.valueOf(localDate), 0, address, gender, interests);

        // Add customer to the database (this step can be handled based on your system design)
        MovieStoreDatabase.customers.add(newCustomer);

        // Success message or redirection
        errorLabel.setText("Registration successful!");
        errorLabel.setVisible(true);

        // Clear the form fields after successful registration
        clearForm();

        // Now navigate to the next page
        navigateToHomePage();
    }

    private void clearForm() {
        usernameField.clear();
        passwordField.clear();
        addressField.clear();
        interestsField.clear();
        genderComboBox.getSelectionModel().clearSelection();
        birthDatePicker.setValue(null);
    }

    private void navigateToHomePage() {
        try {
            // Load the home page FXML file
            FXMLLoader loader = new FXMLLoader(getClass().getResource("WelcomeCustomer.fxml"));

            Scene homePageScene = new Scene(loader.load(), 800, 600);
            homePageScene.getStylesheets().add(getClass().getResource("BG3.css").toExternalForm());

            // Get the current stage (window)
            Stage stage = (Stage) errorLabel.getScene().getWindow();

            // Set the new scene
            stage.setScene(homePageScene);
            stage.setTitle("Home Page"); // Set title for the new window
            stage.show();
        } catch (IOException e) {
            errorLabel.setText("Failed to load the home page.");
            errorLabel.setVisible(true);
        }
    }
}
