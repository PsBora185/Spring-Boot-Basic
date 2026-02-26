package com.example.ProductApi.service;

import com.example.ProductApi.entity.Product;
import jakarta.annotation.PostConstruct;
import org.jspecify.annotations.Nullable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProductService {

    private final Map<Integer, Product> products = new HashMap<>();

    @PostConstruct
    public void initDb() {
        products.put(1, new Product(1, "Ludo", "Games", 50));
        products.put(2, new Product(1, "iqoo z9x", "Smartphone", 12000));
        products.put(3, new Product(3, "Yoga Mat", "Fitness", 1500));
        products.put(4, new Product(4, "Trimmer", "Electronics", 900));
        products.put(5, new Product(5, "Atomic Habits", "Books", 500));
        products.put(6, new Product(6, "Acer aspire lite", "Computers", 43000));
        products.put(7, new Product(7, "Nike Running Shoes", "Apparel", 6000));
    }

    public @Nullable List<Product> findAll() {
        return new ArrayList<>(products.values());
    }

    public boolean exist(int id) {
        return products.containsKey(id);
    }

    public @Nullable Product findById(int id) {
        return products.get(id);
    }

    public @Nullable Product add(Product product) {
        return products.put(product.getId(), product);
    }

    public void deleteById(int id) {
        products.remove(id);
    }

    public @Nullable List<Product> findByCategory(String category, double maxPrice) {
        return products.values().stream()
                .filter(p -> p.getCategory().equalsIgnoreCase(category) && p.getPrice() <= maxPrice)
                .toList();
    }

    public @Nullable List<Product> filterByPrice(double maxPrice) {
        return products.values().stream()
                .filter(p -> p.getPrice() <= maxPrice)
                .toList();
    }
}
