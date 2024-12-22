package com.example.movie;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

public class login {

    @FXML
    private ComboBox<String> accountTypeComboBox;

    @FXML
    private Button loginButton;

    @FXML
    private Label errorLabel;

    @FXML
    private Label successLabel;

    @FXML
    private PasswordField passwordField;

    @FXML
    private TextField usernameField;

    @FXML
    private void initialize() {
        // Set up account type ComboBox values

        accountTypeComboBox.setValue("Customer"); // Default value

        // Set up login button action handler
        loginButton.setOnAction(event -> {
            handleLogin();
        });
    }

    /**
     * Handles the login action when the login button is clicked.
     */
    private void handleLogin() {
        String username = usernameField.getText();
        String password = passwordField.getText();
        String accountType = accountTypeComboBox.getValue();

        // Clear previous messages
        errorLabel.setText("");
        successLabel.setText("");

        // Validate input fields
        if (username.isEmpty() || password.isEmpty() || accountType == null) {
            errorLabel.setText("All fields must be filled!");
            return;
        }

        boolean loginSuccessful = false;

        // Admin login
        if (accountType.equals("Admin")) {
            for (Admin admin : MovieStoreDatabase.admins) {
                if (admin.getUsername().equals(username) && admin.getPassword().equals(password)) {
                    loginSuccessful = true;
                    successLabel.setText("Login successful as Admin!");
                    switchScene("WelcomeAdmin.fxml");
                    break;
                }
            }
        }

        // Customer login
        else if (accountType.equals("Customer")) {
            for (Customer customer : MovieStoreDatabase.customers) {
                if (customer.getUsername().equals(username) && customer.getPassword().equals(password)) {
                    loginSuccessful = true;
                    successLabel.setText("Login successful as Customer!");

                    // Set the current customer
                    MovieStoreDatabase.currentCustomer = customer;

                    // Switch to the customer scene
                    switchScene("WelcomeCustomer.fxml");
                    break;
                }
            }
        }

        // If login is not successful
        if (!loginSuccessful) {
            errorLabel.setText("Invalid login credentials.");
        }
    }

    /**
     * Switches the scene to the specified FXML file.
     *
     * @param fxmlFile the FXML file to load
     */
    private void switchScene(String fxmlFile) {
        try {
            // Get the current stage
            Stage stage = (Stage) loginButton.getScene().getWindow();

            // Load the new FXML file
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFile));
            Scene scene = new Scene(loader.load(), 800, 600);
            scene.getStylesheets().add(getClass().getResource("BG3.css").toExternalForm());

            // Set the new scene
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            errorLabel.setText("Error loading the scene: " + fxmlFile);
        }
    }
}
