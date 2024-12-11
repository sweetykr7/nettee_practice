package com.example.hexagonal_app.application.service;

import com.example.hexagonal_app.application.port.in.OrderService;
import com.example.hexagonal_app.application.port.out.OrderRepository;
import com.example.hexagonal_app.domain.Order;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public Order createOrder(String customerName) {
        Order order = new Order(null, customerName);
        orderRepository.save(order);
        return order;
    }

    @Override
    public Order getOrderbyId(Long id) {
        return orderRepository.findById(id).orElseThrow(() -> new RuntimeException("Order not found"));
    }
}
