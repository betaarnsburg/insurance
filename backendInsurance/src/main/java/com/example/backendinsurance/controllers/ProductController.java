package com.example.backendinsurance.controllers;

import com.example.backendinsurance.entities.Product;
import com.example.backendinsurance.services.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/insurance/product")
@CrossOrigin(origins = "http://localhost:4200/")
@AllArgsConstructor
public class ProductController {
    private ProductService productService;

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        return ResponseEntity.ok(productService.findAllProducts());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Integer id) {
        return ResponseEntity.of(productService.findProductById(id));
    }
    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody @Validated Product product) {
        if (productService.findProductById(product.getId()).isPresent()) {
            return ResponseEntity.badRequest().build();
        }else {
            return ResponseEntity.ok(productService.saveProduct(product));
        }
    }
    @PutMapping
    public ResponseEntity<Product> updateProduct(@RequestBody @Validated Product product) {
        if (productService.findProductById(product.getId()).isPresent()) {
            return ResponseEntity.ok(productService.saveProduct(product));
        }else{
            return ResponseEntity.badRequest().build();
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Integer id) {
        if (productService.findProductById(id).isPresent()) {
            productService.deleteProduct(id);
            return ResponseEntity.accepted().build();
        }else {
            return ResponseEntity.notFound().build();
        }
    }
}
