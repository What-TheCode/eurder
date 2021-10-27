package com.example.eurder.repository;

import com.example.eurder.domain.order.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class OrderRepository {
    private final Map<String, Order> ordersById;
    private final Logger logger = LoggerFactory.getLogger(OrderRepository.class);

    public OrderRepository() {
        this.ordersById = new ConcurrentHashMap<>();
    }

    public void addOrders(List<Order> orders) {
        orders.forEach(
                order -> this.ordersById.put(order.getId(), order)
        );
    }
}
