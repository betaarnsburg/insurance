package com.example.backendinsurance.controllers;

import com.example.backendinsurance.entities.Order;
import com.example.backendinsurance.services.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/insurance/order")
@CrossOrigin(origins = "http://localhost:4200/")
@AllArgsConstructor
public class OrderController {
    private OrderService orderService;

    @GetMapping
    public ResponseEntity<List<Order>> getAllOrders() {
        return ResponseEntity.ok(orderService.findAllOrders());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable Long id) {
        return ResponseEntity.of(orderService.findOrderById(id));
    }
    @PostMapping
    public ResponseEntity<Order> createOrder(@RequestBody @Validated Order order) {
        if (orderService.findOrderById(order.getId()).isEmpty()) {
            return ResponseEntity.ok(orderService.saveOrder(order));
        }else {
            return ResponseEntity.badRequest().build();
        }
    }
    @PutMapping
    public ResponseEntity<Order> updateOrder(@RequestBody @Validated Order order) {
        if (orderService.findOrderById(order.getId()).isEmpty()) {
            return ResponseEntity.badRequest().build();
        } else{
            return ResponseEntity.ok(orderService.saveOrder(order));
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrder(@PathVariable Long id) {
        if (orderService.findOrderById(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        } else{
            orderService.deleteOrderById(id);
            return ResponseEntity.accepted().build();
        }
    }
}
