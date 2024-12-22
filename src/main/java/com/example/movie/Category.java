package com.example.movie;



import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Category implements Serializable{
    // Attributes
    private String name;
    private List<Product> arrayOfProducts;

    // Constructor to initialize category with a name and a list of products
    public Category(String name, ArrayList<Product> arrayOfProducts) {
        this.name = name;
        this.arrayOfProducts = arrayOfProducts != null ? arrayOfProducts : new ArrayList<Product>(); // Ensure it's never null
    }

    // Getter for name
    public String getName() {
        return name;
    }

    // Setter for name
    public void setName(String name) {
        this.name = name;
    }

    // Getter for arrayOfProducts
    public List<Product> getArrayOfProducts() {
        return arrayOfProducts;
    }

    // Setter for arrayOfProducts
    public void setArrayOfProducts(List<Product> arrayOfProducts) {
        this.arrayOfProducts = arrayOfProducts;
    }

    // Method to add a product to the category
    public void addProduct(Product product) {
        this.arrayOfProducts.add(product);
    }

    // Method to remove a product from the category
    public void removeProduct(Product product) {
        this.arrayOfProducts.remove(product);
    }

    // Method to display all products in the category
    public void viewProducts() {
        System.out.println("Products in category '" + name + "':");
        for (Product product : arrayOfProducts) {
            System.out.println(product.getName() + " - Price: " + product.getPrice());
        }
    }

    // Override toString to represent Category object
    @Override
    public String toString() {
        return "Category   "+ name;
    }
}