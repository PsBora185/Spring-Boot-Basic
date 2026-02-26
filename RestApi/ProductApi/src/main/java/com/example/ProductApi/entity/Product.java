package com.example.ProductApi.entity;

public class Product {
    int id;
    String name;
    String category;
    double price;

    public Product(int id, String name, String category, double price) {
        this.category = category;
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}
