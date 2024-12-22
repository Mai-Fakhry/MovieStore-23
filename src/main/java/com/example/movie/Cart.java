package com.example.movie;

import java.io.Serializable;

public class Cart implements Serializable  {
    private int size_of_cart = 0;
    private Product[] products;
    private Customer customer;  // Link to the customer who owns the cart

    // Constructor

    public Cart() {
        this.products = new Product[10];  // Assume a cart can hold 10 products initially
    }

    public Cart(Customer customer) {
        this.customer = customer;
        this.products = new Product[10];  // Assume a cart can hold 10 products initially
    }

    // Getters and Setters
    public Product[] getProducts() {
        return products;
    }

    public void setProducts(Product[] products) {
        this.products = products;
    }

    // Method to view items in the cart
    public void viewItems() {
        if (size_of_cart == 0) {
            System.out.println("Your cart is empty.");
        } else {
            System.out.println("Items in your cart:");
            for (int i = 0; i < size_of_cart; i++) {
                Product product = products[i];
                System.out.println("Name: " + product.getName());
                System.out.println("Price: " + product.getPrice());
                System.out.println("Category: " + product.getCategory());
                System.out.println("Serial number: " + product.getSerialNumber());
            }
        }
    }

    // Get the number of items in the cart
    public int getElementsInCart() {
        return size_of_cart;
    }

    // Method to add an item to the cart (retrieved from MovieStoreDatabase)
    public void addItem(String name) {
        // Check if the product exists in the database
        Product productToAdd = null;
        for (Product product : MovieStoreDatabase.products) {
            if (product.getName() == name) {
                productToAdd = product;
                break;
            }
        }

        if (productToAdd == null) {
            System.out.println("Product not found in the database.");
            return;
        }

        // Ensure there is space in the cart for a new product
        if (size_of_cart >= products.length) {
            System.out.println("Cart is full. Cannot add more items.");
            return;
        }

        products[size_of_cart] = productToAdd;  // Add the found product to the cart
        size_of_cart++;
        System.out.println(productToAdd.getName() + " has been added to the cart.");
    }

    // Method to delete a product from the cart by name
    public void deleteItem(String productName) {
        boolean found = false;

        // Search for the product by name
        for (int i = 0; i < size_of_cart; i++) {
            Product currentProduct = products[i];
            if (currentProduct.getName().equalsIgnoreCase(productName)) {
                found = true;

                // Shift all products after the deleted one to the left
                for (int j = i; j < size_of_cart - 1; j++) {
                    products[j] = products[j + 1];  // Shift left
                }

                // Nullify the last position (optional, to clear the reference)
                products[size_of_cart - 1] = null;
                size_of_cart--;  // Decrease the size of the cart
                System.out.println(productName + " has been removed from your cart.");
                break;
            }
        }

        if (!found) {
            System.out.println("Product not found in cart.");
        }
    }

    // Method to place an order for items in the cart
    public void placeOrder() {
        if (size_of_cart == 0) {
            System.out.println("Your cart is empty. Please add items to your cart before placing an order.");
            return;
        }

        // Calculate the total price of items in the cart
        double totalPrice = 0;
        for (int i = 0; i < size_of_cart; i++) {
            totalPrice += products[i].getPrice();
        }

        System.out.println("Placing order for the following items:");
        for (int i = 0; i < size_of_cart; i++) {
            System.out.println("- " + products[i].getName() + " | Price: " + products[i].getPrice());
        }

        System.out.println("Total price: " + totalPrice);

        // Check if the customer has enough balance
        if (customer.getBalance() >= totalPrice) {
            customer.setBalance(customer.getBalance() - totalPrice);  // Deduct the amount from the customer's balance
            System.out.println("Order placed successfully! Your balance has been updated.");
            System.out.println("Your new balance = "+customer.getBalance());
            this.clearCart();  // Clear the cart after the order
        } else {
            System.out.println("Insufficient balance. Please add funds to your account.");
        }
    }

    // Method to clear the cart after placing the order
    public void clearCart() {
        size_of_cart = 0;  // Reset cart size
        products = new Product[10];  // Optionally reset the products array
        System.out.println("Your cart is now empty.");
    }

    // Link the cart to the customer in the MovieStoreDatabase
    public static void linkCartToCustomer(Customer customer) {
        // Create a new cart for the customer if one doesn't exist
        Cart cart = new Cart(customer);

        customer.setCart(cart); // Ensure the customer object has a reference to their cart
        System.out.println("Cart has been created and linked to the customer.");
    }


}