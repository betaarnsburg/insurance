package com.example.backendinsurance.controllers;

import com.example.backendinsurance.entities.Customer;
import com.example.backendinsurance.services.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/insurance/customer")
@CrossOrigin(origins = "http://localhost:4200/")
@AllArgsConstructor
public class CustomerController {
    private CustomerService customerService;

    @GetMapping
    public ResponseEntity<List<Customer>> getAllCustomers() {
        return ResponseEntity.ok(customerService.getAllCustomers());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable Long id) {
        return ResponseEntity.of(customerService.getCustomerById(id));
    }

    @PostMapping
    public ResponseEntity<Customer> createCustomer(@RequestBody @Validated Customer customer) {
        if(customer.getId() == null){
            return ResponseEntity.ok(customerService.saveCustomer(customer));
        }else {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping
    public ResponseEntity<Customer> updateCustomer(@RequestBody @Validated Customer customer) {
        if(customer.getId() == null){
            return ResponseEntity.badRequest().build();
        } else if(customerService.getCustomerById(customer.getId()).isEmpty()) {
            return ResponseEntity.notFound().build();
        } else{
            return ResponseEntity.ok(customerService.saveCustomer(customer));
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable Long id) {
        if(customerService.getCustomerById(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }else {
            customerService.deleteCustomer(id);
            return ResponseEntity.accepted().build();
        }
    }
}
