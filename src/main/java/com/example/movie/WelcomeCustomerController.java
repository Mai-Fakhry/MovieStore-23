package com.example.movie;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import java.io.IOException;

public class WelcomeCustomerController {

    @FXML
    private Button AddToCart;

    @FXML
    private Button Logoutbut;

    @FXML
    private Button PlaceOrder;

    @FXML
    private Button ViewCart;

    @FXML
    private Button ViewCategories;

    @FXML
    private Button ViewMovies;

    @FXML
    private void initialize() {
        // Set actions for the buttons
        AddToCart.setOnAction(event -> goToAddToCartPage());
        Logoutbut.setOnAction(event -> goToLoginPage());
        PlaceOrder.setOnAction(event -> goToPlaceOrderPage());
        ViewCart.setOnAction(event -> goToViewCartPage());
        ViewCategories.setOnAction(event -> goToViewCategoriesPage());
        ViewMovies.setOnAction(event -> goToViewMoviesPage());
    }

    // Method to navigate to the AddToCart page
    @FXML
    private void goToAddToCartPage() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("AddToCart.fxml")); // Update with actual FXML file name
            Scene scene = new Scene(loader.load(), 800, 600);
            scene.getStylesheets().add(getClass().getResource("BG3.css").toExternalForm());
            Stage currentStage = (Stage) AddToCart.getScene().getWindow();
            currentStage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error loading AddToCart page.");
        }
    }

    // Method to navigate to the Login page (logout)
    @FXML
    private void goToLoginPage() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("hello-view.fxml")); // Update with actual FXML file name
            Scene scene = new Scene(loader.load(), 400, 550);
            scene.getStylesheets().add(getClass().getResource("hello.css").toExternalForm());
            Stage currentStage = (Stage) Logoutbut.getScene().getWindow();
            currentStage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error loading Hello page.");
        }
    }

    // Method to navigate to the PlaceOrder page
    @FXML
    private void goToPlaceOrderPage() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Payment.fxml")); // Update with actual FXML file name
            Scene scene = new Scene(loader.load(), 800, 600);
            scene.getStylesheets().add(getClass().getResource("BG3.css").toExternalForm());
            Stage currentStage = (Stage) PlaceOrder.getScene().getWindow();
            currentStage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error loading PlaceOrder page.");
        }
    }

    // Method to navigate to the ViewCart page
    @FXML
    private void goToViewCartPage() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ViewCart.fxml")); // Update with actual FXML file name
            Scene scene = new Scene(loader.load(), 800, 600);
            scene.getStylesheets().add(getClass().getResource("BG3.css").toExternalForm());
            Stage currentStage = (Stage) ViewCart.getScene().getWindow();
            currentStage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error loading ViewCart page.");
        }
    }

    // Method to navigate to the ViewCategories page
    @FXML
    private void goToViewCategoriesPage() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ViewCategories2.fxml")); // Update with actual FXML file name
            Scene scene = new Scene(loader.load(), 800, 600);
            scene.getStylesheets().add(getClass().getResource("BG3.css").toExternalForm());
            Stage currentStage = (Stage) ViewCategories.getScene().getWindow();
            currentStage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error loading ViewCategories page.");
        }
    }

    // Method to navigate to the ViewMovies page
    @FXML
    private void goToViewMoviesPage() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ViewProducts2.fxml")); // Update with actual FXML file name
            Scene scene = new Scene(loader.load(), 800, 600);
            scene.getStylesheets().add(getClass().getResource("BG3.css").toExternalForm());
            Stage currentStage = (Stage) ViewMovies.getScene().getWindow();
            currentStage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error loading ViewMovies page.");
        }
    }
}
