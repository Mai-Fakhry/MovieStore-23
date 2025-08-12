# 🎬 MovieStore-23

**MovieStore-23** is a **Java-based e-commerce application** that simulates a movie store where customers can browse, search, and “purchase” movies, while administrators can manage inventory.  
It is built using **Object-Oriented Programming (OOP)** principles and a graphical user interface (GUI) for a more interactive experience.

---

## 📖 Table of Contents
1. [Features](#-features)
2. [Tech Stack](#-tech-stack)
3. [Installation & Running](#-installation--running)
4. [Project Structure](#-project-structure)
5. [Usage Guide](#-usage-guide)
6. [Contributing](#-contributing)
7. [Future Improvements](#-future-improvements)
8. [License](#-license)

---

## 🚀 Features

### 🛒 For Customers
- **Browse Movies:** View a catalog of available movies through a clean and interactive GUI.
- **Search Functionality:** Quickly find movies by title or other keywords.
- **Shopping Cart:** Add movies to the cart for purchase.
- **Checkout Simulation:** Complete a simulated purchase process.

### 🛠️ For Admins
- **Inventory Management:** Add, update, or remove movie listings.
- **Data Validation:** Prevents invalid inputs such as missing details or negative pricing.
- **Persistent Data:** Changes are saved between sessions using serialized data files.

---

## 🛠️ Tech Stack
- **Language:** Java  
- **GUI Framework:** Swing / JavaFX 
- **Build Tool:** Maven  
- **Data Storage:** Serialized `.ser` files for persistence  

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
