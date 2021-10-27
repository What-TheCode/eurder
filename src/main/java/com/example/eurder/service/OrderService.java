package com.example.eurder.service;

import com.example.eurder.domain.order.OrderDTO;
import com.example.eurder.exception.InvalidOrderException;
import com.example.eurder.exception.NoAuthorizationException;
import com.example.eurder.mapper.OrderMapper;
import com.example.eurder.repository.CustomerRepository;
import com.example.eurder.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    private final OrderRepository orderRepository;
    private final CustomerRepository customerRepository;
    private final OrderMapper orderMapper;

    public OrderService(OrderRepository orderRepository, CustomerRepository customerRepository, OrderMapper orderMapper) {
        this.orderRepository = orderRepository;
        this.customerRepository = customerRepository;
        this.orderMapper = orderMapper;
    }

    public void addOrders(String customerId, List<OrderDTO> orderDTOList) {
        if(customerRepository.getCustomers(customerId) == null) {
            throw new NoAuthorizationException("User has no access.");
        }
        if(orderDTOList == null || orderDTOList.isEmpty()) {
            throw new InvalidOrderException("Invalid order.");
        }
        //TODO check if this works
        this.orderRepository.addOrders(this.orderMapper.toEntity(orderDTOList));
    }
}
