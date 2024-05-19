package com.example.backendinsurance.services;

import com.example.backendinsurance.entities.Order;
import com.example.backendinsurance.repositories.OrderRepository;
import lombok.Data;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@Data
public class OrderService {
    private OrderRepository orderRepository;

    public List<Order> findAllOrders() {
        return orderRepository.findAll();
    }
    public Optional<Order> findOrderById(Long id) {
        return orderRepository.findById(id);
    }
    public Order saveOrder(Order order) {
        return orderRepository.save(order);
    }
    public void deleteOrderById(Long id) {
        orderRepository.deleteById(id);
    }
}
