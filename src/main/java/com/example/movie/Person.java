package com.example.movie;

import java.io.Serializable;
import java.util.Date;

public abstract class Person implements Serializable {
    protected String username;
    protected String password;
    protected Date dateOfBirth;
    protected Gender gender;
    String role;
    public Person() {}

    public Person(String username, String password, Date dateOfBirth, Gender gender ,String role) {
        this.username = username;
        this.password = password;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.role = role;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

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

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Gender getGender() {
        return this.gender;
    }

    public abstract void login(String username, String password);



}
