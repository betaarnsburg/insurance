package com.example.backendinsurance.services;

import com.example.backendinsurance.entities.Product;
import com.example.backendinsurance.repositories.ProductRepository;
import lombok.Data;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@Data
public class ProductService {
    private final ProductRepository productRepository;

    public List<Product> findAllProducts() {
        return productRepository.findAll();
    }
    public Optional<Product> findProductById(Integer id) {
        return productRepository.findById(id);
    }
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }
    public void deleteProduct(Integer id) {
        productRepository.deleteById(id);
    }
}
