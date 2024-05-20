package com.example.backendinsurance.components;

import com.example.backendinsurance.entities.Product;
import com.example.backendinsurance.repositories.ProductRepository;
import lombok.Data;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Component
@Transactional
@Data
public class SearchProduct {
    private final ProductRepository productRepository;

    public Optional<Product> searchProductByInfo(Integer age,
                                                 Boolean isDiabetics,
                                                 Boolean isHighBloodPressure,
                                                 Integer travelDays){
        double riskScore = 0.0;

        if(age < 12) {
            riskScore += 2.0;
        } else if(age < 18) {
            riskScore += 1.0;
        } else if(age < 30) {
            riskScore += 2.5;
        } else if(age < 50) {
            riskScore += 3.5;
        } else if(age < 70) {
            riskScore += 4.5;
        } else {
            riskScore += 6.0;
        }

        if(isDiabetics) {
            riskScore += 25.0;
        }

        if(isHighBloodPressure) {
            riskScore += 25.0;
        }

        if (travelDays <= 7) {
            riskScore += 2.0;
        } else if (travelDays <= 30){
            riskScore += 5.0;
        } else {
            riskScore += 15.0;
        }

        if(riskScore <= 10) {
            return productRepository.findById(1);
        } else if(riskScore <= 20) {
            return productRepository.findById(2);
        } else {
            return productRepository.findById(3);
        }
    }
}
