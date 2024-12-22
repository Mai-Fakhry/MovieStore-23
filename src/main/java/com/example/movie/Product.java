package com.example.movie;



import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class Product implements Serializable {
    private int serialNumber;
    private String name;
    private double price;
    private String category;
    private int stockQuantity; // Stock quantity for the product

    private static ArrayList<Product> productList = new ArrayList<>(); // To keep track of all products

    // Constructor
    public Product(int serialNumber, String name, double price, String category) {
        this.serialNumber = serialNumber;
        this.name = name;
        this.price = price;
        this.category = category;
        this.stockQuantity = 5;
        productList.add(this); // Adding the product to the product list
    }

    // Setters and Getters
    public void setSerialNumber(int serialNumber) {
        this.serialNumber = serialNumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getSerialNumber() {
        return serialNumber;
    }

    public  String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getCategory() {
        return category;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    // Method to view product details
    public void viewProduct() {
        System.out.println("Serial Number: " + serialNumber);
        System.out.println("Name: " + name);
        System.out.println("Price: $" + price);
        System.out.println("Category: " + category);
        System.out.println("Stock Quantity: " + stockQuantity);
    }

    @Override
    public String toString() {
        return "Product{" +
                "serialNumber=" + serialNumber +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", category='" + category + '\'' +
                ", stockQuantity=" + stockQuantity +
                '}';
    }

    // Method to check if the product is in stock
    public boolean isInStock() {
        return stockQuantity > 0;
    }

    // Static method to add a new product
    public static void addNewProduct() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n--- Add New Product ---");
        System.out.print("Enter Product Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Product Price: ");
        double price = scanner.nextDouble();

        System.out.print("Enter Product Category: ");
        scanner.nextLine(); // Consume newline
        String category = scanner.nextLine();

        System.out.print("Enter Initial Stock Quantity: ");
        int stockQuantity = scanner.nextInt();

        // Generate serial number based on the current size of the products list
        int serialNumber = MovieStoreDatabase.products.size() + 1;

        // Create and add the new product
        Product newProduct = new Product(serialNumber, name, price, category);
        MovieStoreDatabase.products.add(newProduct); // Add the product to the list

        System.out.println("Product added successfully!");
        System.out.println("Details:");
        newProduct.viewProduct();
    }


    // Method to sell a product (decreasing stock)
    public void sellProduct(int quantity) {
        if (stockQuantity >= quantity) {
            stockQuantity -= quantity;
            System.out.println("Sold " + quantity + " units of " + name);
        } else {
            System.out.println("Not enough stock to sell " + quantity + " units of " + name);
        }
    }

    // Static method to generate a product report
    public static void reportManagement() {
        int totalInStock = 0;
        int totalOutOfStock = 0;

        System.out.println("\n--- Product Report ---");
        for (Product product : productList) {
            System.out.println("---------------------------------");
            product.viewProduct();

            if (product.isInStock()) {
                totalInStock++;
            } else {
                totalOutOfStock++;
            }
        }

        System.out.println("---------------------------------");
        System.out.println("Total products in stock: " + totalInStock);
        System.out.println("Total products out of stock: " + totalOutOfStock);
    }

    // Static method to fetch a product by serial number and validate stock
    public static Product getProductBySerialNumber(int serialNumber) {
        for (Product product : productList) {
            if (product.getSerialNumber() == serialNumber) {
                if (product.isInStock()) {
                    return product;
                } else {
                    System.out.println("Product is out of stock.");
                    return null;
                }
            }
        }
        System.out.println("Product not found.");
        return null;
    }
}
