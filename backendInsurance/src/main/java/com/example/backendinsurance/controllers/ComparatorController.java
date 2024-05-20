package com.example.backendinsurance.controllers;

import com.example.backendinsurance.components.SearchProduct;
import com.example.backendinsurance.entities.Product;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/insurance/comparator")
@CrossOrigin(origins = "http://localhost:4200/")
@AllArgsConstructor
public class ComparatorController {
    private SearchProduct searchProduct;

    @GetMapping("/{age}/{isDiabetics}/{isHighBloodPressure}/{travelDays}")
    public ResponseEntity<Product> recommendProduct(@PathVariable("age") Integer age,
                                                    @PathVariable("isDiabetics") String isDiabetics,
                                                    @PathVariable("isHighBloodPressure") String isHighBloodPressure,
                                                    @PathVariable("travelDays") Integer travelDays) {
        return ResponseEntity.of(searchProduct.searchProductByInfo(age,
                Boolean.parseBoolean(isDiabetics),
                Boolean.parseBoolean(isHighBloodPressure),
                travelDays));
    }
}
