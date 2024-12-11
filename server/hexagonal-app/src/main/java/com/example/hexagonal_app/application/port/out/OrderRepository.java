package com.example.hexagonal_app.application.port.out;

import com.example.hexagonal_app.domain.Order;

import java.util.Optional;

public interface OrderRepository {
    void save(Order order);
    Optional<Order> findById(Long id);
}
