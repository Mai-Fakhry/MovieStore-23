package com.example.movie;


import java.io.Serializable;
import java.util.Date;

public class Admin extends Person implements ECommerceOperations, Serializable {
    private String username;
    private String password;
    private Date dateOfBirth;
    private String role;
    private int workingHours; // New field for working hours

    // Constructor
    public Admin(String username, String password) {
        this.username = username;
        this.password = password;
        this.dateOfBirth = null; // Default value if not set
        this.role = "Admin"; // Default role for admin
        this.workingHours = 40; // Default working hours
    }

    // Overloaded constructor with all fields
    public Admin(String username, String password, Date dateOfBirth, String role, int workingHours) {
        this.username = username;
        this.password = password;
        this.dateOfBirth = dateOfBirth;
        this.role = role;
        this.workingHours = workingHours;
    }

    // Getters and setters
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getWorkingHours() {
        return workingHours;
    }

    public void setWorkingHours(int workingHours) {
        this.workingHours = workingHours;
    }

    // Login method
    @Override
    public void login(String username, String password) {
        if (this.username.equals(username) && this.password.equals(password)) {
            System.out.println("Login successful!");
        } else {
            System.out.println("Invalid login credentials.");
        }
    }

    // Implementation of ECommerceOperations interface
    @Override
    public void showUsers() {
        System.out.println("List of Users:");
        for (Customer customer : MovieStoreDatabase.customers) {
            System.out.println(customer);
        }
    }

    @Override
    public void showProducts() {
        System.out.println("List of Products:");
        for (Product product : MovieStoreDatabase.products) {
            System.out.println(product);
        }
    }

    @Override
    public void showOrders() {
        System.out.println("List of Orders:");
        for (Orders order : MovieStoreDatabase.orders) {
            System.out.println(order);
        }
    }

    @Override
    public void addProduct(Product product) {
        MovieStoreDatabase.products.add(product);
        System.out.println("Product added: " + product.getName());
    }

    @Override
    public void updateProduct(int productId, Product updatedProduct) {
        for (Product product : MovieStoreDatabase.products) {
            if (product.getSerialNumber() == productId) {
                int index = MovieStoreDatabase.products.indexOf(product);
                MovieStoreDatabase.products.set(index, updatedProduct);
                System.out.println("Product updated: " + updatedProduct.getName());
                return;
            }
        }
        System.out.println("Product not found with ID: " + productId);
    }

    @Override
    public void deleteProduct(int productId) {
        boolean removed = MovieStoreDatabase.products.removeIf(product -> product.getSerialNumber() == productId);
        if (removed) {
            System.out.println("Product deleted with ID: " + productId);
        } else {
            System.out.println("Product not found with ID: " + productId);
        }
    }

    // New method to show working hours
    public void showWorkingHours() {
        System.out.println("Admin " + this.username + " works " + this.workingHours + " hours per week.");
    }
}
