package com.example.movie;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class ViewProductsController {

    @FXML
    private Button Return;

    @FXML
    private ComboBox<Product> view;

    @FXML
    public void initialize() {
        // Create an ObservableList for the ComboBox and populate it with the current products
        ObservableList<Product> productList = FXCollections.observableArrayList(MovieStoreDatabase.products);

        // Bind the ComboBox to the productList
        view.setItems(productList);

        // Set a StringConverter for the ComboBox to display product names
        view.setConverter(new javafx.util.StringConverter<>() {
            @Override
            public String toString(Product product) {
                return product != null ? product.getName() : "";
            }

            @Override
            public Product fromString(String string) {
                return null; // Not needed for this use case
            }
        });

        // Handle ComboBox selection changes (optional)
        view.setOnAction(event -> {
            Product selectedProduct = view.getSelectionModel().getSelectedItem();
            if (selectedProduct != null) {
                System.out.println("Selected Product: " + selectedProduct);
            }
        });
    }

    // Method to refresh the ComboBox when new products are added
    public void refreshComboBox() {
        view.setItems(FXCollections.observableArrayList(MovieStoreDatabase.products));
    }

    // Action for the "Return" button
    @FXML
    public void handleReturnButtonAction() {
        try {
            // Load the previous page (for example, MainPage.fxml)
            FXMLLoader loader = new FXMLLoader(getClass().getResource("WelcomeAdmin.fxml")); // Use the path to your main page
            Scene scene = new Scene(loader.load(), 800, 600);
            scene.getStylesheets().add(getClass().getResource("BG3.css").toExternalForm());

            // Get the current stage (window) and set the new scene
            Stage stage = (Stage) Return.getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error loading the return page.");
        }
    }
}
