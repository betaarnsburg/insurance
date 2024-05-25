package com.example.backendinsurance.components;

import com.example.backendinsurance.entities.Product;
import com.example.backendinsurance.repositories.ProductRepository;
import lombok.Data;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Optional;

@Component
@Transactional
@Data
public class SearchProduct {
    private final ProductRepository productRepository;

    private static final double diabeticsRiskScore = 25.0;
    private static final double highBloodPressureRiskScore = 25.0;
    private static final Map<Integer, Double> travelDaysRiskScore = Map.of(
            7, 2.0,
            30, 5.0,
            Integer.MAX_VALUE, 15.0
    );
    private static final Map<Integer, Double> ageRiskScore = Map.of(
            12, 2.0,
            18, 1.0,
            30, 3.5,
            50, 6.5,
            70, 8.5,
            Integer.MAX_VALUE, 10.0
    );

    public Optional<Product> searchProductByInfo(Integer age,
                                                 Boolean diabetics,
                                                 Boolean highBloodPressure,
                                                 Integer travelDays) {
        double riskScore = getAgeRiskScore(age)
                + (diabetics ? diabeticsRiskScore : 0.0)
                + (highBloodPressure ? highBloodPressureRiskScore : 0.0)
                + getTravelDaysRiskScore(travelDays);
        if (riskScore <= 10.0) {
            return productRepository.findById(1);
        } else if (riskScore <= 20.0) {
            return productRepository.findById(2);
        } else {
            return productRepository.findById(3);
        }
    }

    private double getAgeRiskScore(Integer age) {
        return ageRiskScore.entrySet().stream()
                .filter(entry -> age <= entry.getKey())
                .findFirst()
                .map(Map.Entry::getValue)
                .orElse(0.0);
    }
    private double getTravelDaysRiskScore(Integer travelDays) {
        return travelDaysRiskScore.entrySet().stream()
                .filter(entry -> travelDays <= entry.getKey())
                .findFirst()
                .map(Map.Entry::getValue)
                .orElse(0.0);
    }
}
