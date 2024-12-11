package com.example.hexagonal_app.adapter.in.web;

import com.example.hexagonal_app.application.port.in.OrderService;
import com.example.hexagonal_app.domain.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private final OrderService orderService;
    private static final Logger logger = LoggerFactory.getLogger(OrderController.class);
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public ResponseEntity<Order> create(@RequestParam String customerName){
        Order order = orderService.createOrder(customerName);
        logger.info("Order id: {}", order.getId()); // 로그 출력 test
        logger.info("Order name: {}", order.getCustomerName()); // 로그 출력 test
        logger.info("44testOrder name: {}", order.getCustomerName()); // 로그 출력 test
        Order order2 = new Order(null, "test");
        return ResponseEntity.ok(order);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Order> getOrder(@PathVariable Long id){
        Order order = orderService.getOrderbyId(id);
        return ResponseEntity.ok(order);
    }
}
