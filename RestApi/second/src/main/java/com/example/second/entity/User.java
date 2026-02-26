package com.example.second.entity;


public class User {
    int id;
    String name;
    String email;

    public User(int id, String name, String email) {
        this.email = email;
        this.id = id;
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
