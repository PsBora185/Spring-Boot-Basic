package com.example.second.entity;


public class User {
    String id;
    String name;
    String email;

    public User(String id, String name, String email) {
        this.email = email;
        this.id = id;
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
