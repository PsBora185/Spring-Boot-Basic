package com.example.first;

public class User {
    String name;
    int age;
    String email;

    public User(String name, int age, String email) {
        this.age = age;
        this.email = email;
        this.name = name;
    }

    // getters are needed to return data

    public int getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }
}
