package com.example.hexagonal_app.application.port.in;

import com.example.hexagonal_app.domain.Order;

public interface OrderService {
    Order createOrder(String customerName);
    Order getOrderbyId(Long id);
}
