package com.example.hexagonal_app.adapter.out.persistence;

import com.example.hexagonal_app.application.port.out.OrderRepository;
import com.example.hexagonal_app.domain.Order;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class OrderRepositoryAdapter implements OrderRepository {
    private final JpaOrderRepository jpaOrderRepository;

    public OrderRepositoryAdapter(JpaOrderRepository jpaOrderRepository) {
        this.jpaOrderRepository = jpaOrderRepository;
    }

    @Override
    public void save(Order order) {
        OrderEntity entity = new OrderEntity();
        entity.setCustomerName(order.getCustomerName());
        OrderEntity savedEntity = jpaOrderRepository.save(entity); // 저장 후 엔티티 반환
        order.setId(savedEntity.getId());
    }

    @Override
    public Optional<Order> findById(Long id){
        return jpaOrderRepository.findById(id)
                .map(entity -> new Order(entity.getId(), entity.getCustomerName()));
    }
}
