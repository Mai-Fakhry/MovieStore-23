package com.example.movie;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class WelcomeAdminController {

    @FXML
    private Button AddProduct;

    @FXML
    private Button DeleteProduct;

    @FXML
    private Button Logout;

    @FXML
    private Button ViewCategory;

    @FXML
    private Button ViewMovies;

    @FXML
    private Button ViewReport;

    @FXML
    private Button WH;

    @FXML
    private Label welcomeText;

    // Initialize each button with an action to load the corresponding page
    @FXML
    private void initialize() {
        AddProduct.setOnAction(event -> navigateToPage("AddProduct.fxml"));
        DeleteProduct.setOnAction(event -> navigateToPage("DeleteProduct.fxml"));
        Logout.setOnAction(event -> handleLogout()); // Separate handling for Logout
        ViewCategory.setOnAction(event -> navigateToPage("ViewCategories.fxml"));
        ViewMovies.setOnAction(event -> navigateToPage("ViewProducts.fxml"));
        ViewReport.setOnAction(event -> navigateToPage("ViewReport.fxml"));
        WH.setOnAction(event -> navigateToPage("ViewWH.fxml"));
    }

    // General method to navigate to a page
    private void navigateToPage(String fxmlFile) {
        try {
            // Load the FXML file based on the button clicked
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFile));
            Scene scene = new Scene(loader.load(), 800, 600);
            scene.getStylesheets().add(getClass().getResource("BG3.css").toExternalForm());
            // Get the current stage and set the new scene
            Stage stage = (Stage) AddProduct.getScene().getWindow(); // You can use any button for this, e.g. AddProduct
            stage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error loading page: " + fxmlFile);
        }
    }

    // Separate method for handling the Logout button
    private void handleLogout() {
        try {
            // Load the FXML for the login page
            FXMLLoader loader = new FXMLLoader(getClass().getResource("hello-view.fxml"));
            Scene scene = new Scene(loader.load(), 400, 550); // Different dimensions for logout, if needed
            scene.getStylesheets().add(getClass().getResource("hello.css").toExternalForm());
            // Get the current stage and set the new scene
            Stage stage = (Stage) Logout.getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error loading the logout page: hello-view.fxml");
        }
    }
}
