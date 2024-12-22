package com.example.movie;


import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Customer extends Person implements Serializable{
    private double balance;
    private String address;
    private List<String> interests;
    private Cart cart;  // Link to the Cart object

    // Constructor
    public Customer(String username, String password, Date dateOfBirth,
                    double balance, String address, Gender gender, List<String> interests) {
        // Pass the "Customer" role to the superclass constructor
        super(username, password, dateOfBirth, gender, "Customer");  // Fixed here, role = "Customer"

        this.balance = balance;
        this.address = address;
        this.interests = new ArrayList<>(interests);
        this.cart = new Cart(this);  // Initialize the cart for the customer

        MovieStoreDatabase.carts.add(this.cart);  // Correctly add the cart to the database
    }



    // Getters and Setters for address and interests
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<String> getInterests() {
        return interests;
    }

    public void setInterests(List<String> interests) {
        this.interests = interests;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void addInterest(String interest) {
        if (this.interests == null) {
            this.interests = new ArrayList<>();
        }
        this.interests.add(interest);
    }

    public void removeInterest(String interest) {
        if (this.interests != null) {
            this.interests.remove(interest);
        }
    }

    // Access the Cart object for this customer
    public Cart getCart() {
        return cart;
    }

    // Set the Cart for this customer
    public void setCart(Cart cart) {
        this.cart = cart;
    }

    // Method to add an item to the cart
    public void addToCart() {
        Scanner scanner = new Scanner(System.in);
        MovieStoreDatabase.viewProducts();
        System.out.print("Enter the product name to add to the cart: ");
        String productName = scanner.next();
        scanner.nextLine();  // consume newline
        cart.addItem(productName);  // Add item to the customer's cart
    }

    // Method to place an order for items in the cart
    public void placeOrder(PaymentMethod paymentMethod) {
        cart.placeOrder();  // Place order using the cart's method
    }

    // Login method (from Person class)
    @Override
    public void login(String username, String password) {
        if (this.getUsername().equals(username) && this.getPassword().equals(password)) {
            System.out.println("Login successful!");
        } else {
            System.out.println("Invalid login credentials.");
        }
    }
}