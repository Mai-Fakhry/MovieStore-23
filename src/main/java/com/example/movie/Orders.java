package com.example.movie;

import java.io.Serializable;


public class Orders implements Serializable{

    // Data Items
    private double salary = 0;
    private String address;
    private int serialNumber;
    private PaymentMethod paymentMethod;  // Change to PaymentMethod enum
    private Cart cart;

    // Constructors
    public Orders() {
    }

    public Orders(String address, int serialNumber, PaymentMethod paymentMethod, Cart cart) {
        this.address = address;
        this.serialNumber = serialNumber;
        this.paymentMethod = paymentMethod;
        this.cart = cart;
    }

    // Getters and Setters
    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(int serialNumber) {
        this.serialNumber = serialNumber;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    // Override the toString method
    @Override
    public String toString() {
        return "Details {" +
                "Salary: " + salary +
                ", Address: '" + address + '\'' +
                ", Serial Number: " + serialNumber +
                ", Payment Method: '" + paymentMethod + '\'' +
                '}';
    }

    // Calculate Total Salary
    public void calculateTotalSalary() {
        if (cart == null) {
            System.out.println("No cart associated with this order.");
            return;
        }

        Product[] products = cart.getProducts();  // Get products from the cart

        if (products != null) {
            for (Product product : products) {
                if (product != null) {
                    salary += product.getPrice();  // Add product price to total salary
                }
            }
        }
    }

    // View Order information
    public void viewOrder() {
        if (cart == null || cart.getElementsInCart() == 0) {
            System.out.println("The cart is empty. No products to view.");
            return;
        }

        Product[] products = cart.getProducts();  // Get products from the cart
        for (Product product : products) {
            if (product != null) {
                product.viewProduct();  // Display product details
            }
        }

        // Print order summary using toString
        System.out.println(toString());
    }
}