package com.example.movie;


import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Registration implements Serializable{

    public static Customer registerCustomer() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Customer Registration");

        String username = "";
        while (username.isEmpty()) {
            try {
                System.out.print("Enter username: ");
                username = scanner.nextLine();

                if (username.isEmpty()) {
                    throw new IllegalArgumentException("Username cannot be empty.");
                }

                // Check if the username already exists in the database
                for (Customer customer : MovieStoreDatabase.customers) {
                    if (customer.getUsername().equals(username)) {
                        throw new IllegalArgumentException("This username is already registered. Please use a different username.");
                    }
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                username = ""; // Reset username to re-prompt the user
            }
        }

        String password = "";
        while (password.isEmpty()) {
            try {
                System.out.print("Enter password: ");
                password = scanner.nextLine();
                if (password.isEmpty()) {
                    throw new IllegalArgumentException("Password cannot be empty.");
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        Date dateOfBirth = null;
        while (dateOfBirth == null) {
            try {
                System.out.print("Enter date of birth (yyyy-MM-dd): ");
                String dobInput = scanner.nextLine();
                dateOfBirth = new SimpleDateFormat("yyyy-MM-dd").parse(dobInput);
            } catch (ParseException e) {
                System.out.println("Invalid date format. Please try again.");
            }
        }

        double balance = -1;
        while (balance < 0) {
            try {
                System.out.print("Enter initial balance: ");
                balance = Double.parseDouble(scanner.nextLine());
                if (balance < 0) {
                    throw new IllegalArgumentException("Balance cannot be negative.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid number. Please enter a valid balance.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        String address = "";
        while (address.isEmpty()) {
            try {
                System.out.print("Enter address: ");
                address = scanner.nextLine();
                if (address.isEmpty()) {
                    throw new IllegalArgumentException("Address cannot be empty.");
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        Gender gender = null;
        while (gender == null) {
            try {
                System.out.print("Enter gender (MALE/FEMALE/OTHER): ");
                String genderInput = scanner.nextLine().toUpperCase();
                gender = Gender.valueOf(genderInput);
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid gender. Please try again.");
            }
        }

        List<String> interests = new ArrayList<>();
        System.out.println("Enter interests (type 'done' to finish): ");
        while (true) {
            try {
                String interest = scanner.nextLine();
                if (interest.equalsIgnoreCase("done")) {
                    break;
                }
                if (interest.isEmpty()) {
                    throw new IllegalArgumentException("Interest cannot be empty.");
                }
                interests.add(interest);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        // Create a new Customer object
        Customer customer = new Customer(username, password, dateOfBirth, balance, address, gender, interests);

        // Add the new customer to the database
        MovieStoreDatabase.customers.add(customer);

        System.out.println("Registration successful!");
        return customer;
    }
}
