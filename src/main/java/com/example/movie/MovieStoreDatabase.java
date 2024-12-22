package com.example.movie;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;

public class MovieStoreDatabase {

    // Static ArrayLists to hold data
    public static ArrayList<Category> categories = new ArrayList<>();
    public static ArrayList<Product> products = new ArrayList<>();
    public static ArrayList<Orders> orders = new ArrayList<>();
    public static ArrayList<Customer> customers = new ArrayList<>();
    public static ArrayList<Admin> admins = new ArrayList<>();
    public static ArrayList<Cart> carts = new ArrayList<>();
    public static ArrayList<String> interests = new ArrayList<>();

    // Static field to hold the current logged-in customer
    public static Customer currentCustomer = null;

    // Save data to file
    public static void saveData() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("moviestore_data.ser"))) {
            out.writeObject(categories);
            out.writeObject(products);
            out.writeObject(orders);
            out.writeObject(customers);
            out.writeObject(admins);
            out.writeObject(carts);
            out.writeObject(interests);
            System.out.println("Data saved successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Load data from file
    @SuppressWarnings("unchecked")
    public static void loadData() {
        File file = new File("moviestore_data.ser");
        if (!file.exists()) {
            System.out.println("Data file not found. Initializing default data.");
            initializeDefaultData();
            saveData();
            return;
        }

        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(file))) {
            categories = (ArrayList<Category>) in.readObject();
            products = (ArrayList<Product>) in.readObject();
            orders = (ArrayList<Orders>) in.readObject();
            customers = (ArrayList<Customer>) in.readObject();
            admins = (ArrayList<Admin>) in.readObject();
            carts = (ArrayList<Cart>) in.readObject();
            interests = (ArrayList<String>) in.readObject();
            System.out.println("Data loaded successfully.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading data: " + e.getMessage());
            System.out.println("Reinitializing with default data.");
            initializeDefaultData();
            saveData();
        }
    }

    // Initialize default data
    private static void initializeDefaultData() {
        // Sample Categories
        categories.add(new Category("Action", new ArrayList<>()));
        categories.add(new Category("Comedy", new ArrayList<>()));
        categories.add(new Category("Drama", new ArrayList<>()));

        // Sample Products
        products.add(new Product(1, "Avengers: Endgame", 19.99, "Action"));
        products.add(new Product(2, "The Hangover", 14.99, "Comedy"));
        products.add(new Product(3, "The Godfather", 24.99, "Drama"));

        // Sample Customers
        customers.add(new Customer("John Doe", "0x01", new Date(2000 - 1900, 10, 5), 1500, "Cairo", Gender.MALE, interests));
        customers.add(new Customer("Lily", "f250", new Date(2001 - 1900, 2, 19), 1500, "Egypt", Gender.FEMALE, interests));

        // Sample Admins
        admins.add(new Admin("Ahmed", "23p0088"));
        admins.add(new Admin("Mai", "23p0108"));
        admins.add(new Admin("Rawan", "23p0309"));
        admins.add(new Admin("Mariam", "23p0147"));
    }

    // Methods to view data
    public static void viewCategory() {
        for (Category cat : categories) {
            System.out.println(cat.toString());
        }
    }

    public static void viewProducts() {
        for (Product product : products) {
            System.out.println(product.toString());
        }
    }

    public static void viewCustomers() {
        for (Customer customer : customers) {
            System.out.println(customer.toString());
        }
    }

    public static void addCustomer(Customer customer) {
        customers.add(customer);
        saveData();
    }

    public static void addProduct(Product product) {
        products.add(product);
        saveData();
    }

    public static void addOrder(Orders order) {
        orders.add(order);
        saveData();
    }

    // Load data at startup
    static {
        loadData();
    }

    public static void removeProduct(Product movieToDelete) {
        products.remove(movieToDelete);
    }

    // Method to get a product by name
    public static Product getProductByName(String productName) {
        for (Product product : products) {
            if (product.getName().equalsIgnoreCase(productName)) {
                return product;  // Return the product if found
            }
        }
        return null;  // Return null if not found
    }
}
