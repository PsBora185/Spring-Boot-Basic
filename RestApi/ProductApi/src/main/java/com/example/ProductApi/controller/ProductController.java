package com.example.ProductApi.controller;

import com.example.ProductApi.entity.Product;
import com.example.ProductApi.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping()
    public ResponseEntity<List<Product>> products() {
        return ResponseEntity.ok(productService.findAll());
    }

    @GetMapping("/{productId}")
    public ResponseEntity<Product> productById(@PathVariable("productId") int id) {

        if (!productService.exist(id))
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(productService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Product> addProduct(@RequestBody Product product) {
        if (productService.exist(product.getId()))
            return ResponseEntity.status(HttpStatus.ALREADY_REPORTED)
                    .body(productService.findById(product.getId()));

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(productService.add(product));
    }

    @DeleteMapping("/{productId}")
    public ResponseEntity<String> deleteProduct(
            @PathVariable("productId") int id,
            @RequestHeader("Role") String role) {

        if (!role.equalsIgnoreCase("admin"))
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body("Access Denied.");

        if (!productService.exist(id))
            return ResponseEntity.notFound().build();

        productService.deleteById(id);
        return ResponseEntity.ok("Product deleted.");
    }

    @GetMapping("/filter")
    public ResponseEntity<List<Product>> filterProducts(
            @RequestParam(required = false, defaultValue = "100000") double maxPrice
    ) {
        return ResponseEntity.ok(productService.filterByPrice(maxPrice));
    }

    @GetMapping("/search")
    public ResponseEntity<List<Product>> searchProducts(
            @RequestParam String category,
            @RequestParam(required = false, defaultValue = "100000") double maxPrice
    ) {
        return ResponseEntity.ok(productService.findByCategory(category, maxPrice));
    }

}
