package com.example.movie;



public interface ECommerceOperations {
    // Show all users
    void showUsers();

    // Show all products
    void showProducts();

    // Show all orders
    void showOrders();

    // Add a new product
    void addProduct(Product product);

    // Update an existing product by its ID
    void updateProduct(int productId, Product updatedProduct);

    // Delete a product by its ID
    void deleteProduct(int productId);


}
