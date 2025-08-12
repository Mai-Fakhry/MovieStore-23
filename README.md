# 🎬 MovieStore-23

**MovieStore-23** is a **Java-based e-commerce application** that simulates a movie store where customers can browse, search, and “purchase” movies, while administrators can manage inventory.
It is built using **Object-Oriented Programming (OOP)** principles and a graphical user interface (GUI) for a more interactive experience.

---

## 📖 Table of Contents

1. [Features](#-features)
2. [Tech Stack](#-tech-stack)
3. [Installation & Running](#-installation--running-all-in-one)
4. [Project Structure](#-project-structure)
5. [Usage Guide](#-usage-guide)
6. [Future Improvements](#-future-improvements)

---

## 🚀 Features

### 🛒 For Customers

* **Browse Movies:** View a catalog of available movies through a clean and interactive GUI.
* **Search Functionality:** Quickly find movies by title or other keywords.
* **Shopping Cart:** Add movies to the cart for purchase.
* **Checkout Simulation:** Complete a simulated purchase process.

### 🛠️ For Admins

* **Inventory Management:** Add, update, or remove movie listings.
* **Data Validation:** Prevents invalid inputs such as missing details or negative pricing.
* **Persistent Data:** Changes are saved between sessions using serialized data files.

---

## 🛠️ Tech Stack

* **Language:** Java
* **GUI Framework:** Swing *(or JavaFX – update if needed)*
* **Build Tool:** Maven
* **Data Storage:** Serialized `.ser` files for persistence

---

## 📦 Installation & Running (All-in-One)

Open your terminal and run:

```bash
# Clone the repository
git clone https://github.com/Mai-Fakhry/MovieStore-23.git

# Enter the project folder
cd MovieStore-23

# Build the project with Maven
mvn clean compile

# Run the application (replace MainClass with your actual main class path)
mvn exec:java -Dexec.mainClass="your.main.ClassName"
```

> 💡 Example main class: `com.moviestore.Main`

---

## 📂 Project Structure

```
MovieStore-23/
├── src/main/java/       # Java source code
│   ├── ...              # Packages and classes for the app
├── pom.xml              # Maven configuration file
├── moviestore_data.ser  # Serialized data file for persistence
├── .gitignore           # Ignored files list
└── mvnw / mvnw.cmd      # Maven wrapper scripts
```

---

## 📖 Usage Guide

### 🛒 As a Customer:

1. Launch the application.
2. Browse available movies or search by title.
3. Add movies to the shopping cart.
4. Proceed to simulated checkout.

### 🛠️ As an Admin:

1. Log into the admin interface *(if implemented)*.
2. Add new movies with details such as title, genre, and price.
3. Update or remove existing movies.
4. Save changes before exiting to keep inventory updated.

---

## 🚧 Future Improvements

* 🎯 **Advanced Search Filters** (genre, rating, price range)
* 🗄 **Database Integration** (replace `.ser` with SQLite/MySQL)
* 📸 **Add Screenshots** for better visualization
* 🔐 **User Authentication** for customers and admins
* 📊 **Sales Reporting** for admins

---
