package com.example.eurder.service;

import com.example.eurder.domain.order.CreateOrderDTO;
import com.example.eurder.domain.order.Order;
import com.example.eurder.domain.order.OrderDTO;
import com.example.eurder.exception.InvalidItemException;
import com.example.eurder.exception.InvalidOrderException;
import com.example.eurder.exception.NoAuthorizationException;
import com.example.eurder.mapper.OrderMapper;
import com.example.eurder.repository.UserRepository;
import com.example.eurder.repository.ItemRepository;
import com.example.eurder.repository.OrderRepository;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    private final OrderRepository orderRepository;
    private final UserRepository userRepository;
    private final ItemRepository itemRepository;
    private final OrderMapper orderMapper;

    public OrderService(OrderRepository orderRepository, UserRepository userRepository, ItemRepository itemRepository, OrderMapper orderMapper) {
        this.orderRepository = orderRepository;
        this.userRepository = userRepository;
        this.itemRepository = itemRepository;
        this.orderMapper = orderMapper;
    }

    public OrderDTO addOrders(String customerId, CreateOrderDTO createOrderDTO) {
        if(!this.userRepository.isCustomer(customerId)) {
            throw new NoAuthorizationException("User has no access.");
        }
        if(createOrderDTO.getItemGroups().size() == 0) {
            throw new InvalidOrderException("Invalid order.");
        }
        if(!createOrderDTO.getItemGroups().stream()
                .allMatch(item -> this.itemRepository.isItem(item.getItem()))) {
            throw new InvalidItemException("Item does not exist.");
        }

        Order order = this.orderMapper.toEntity(customerId, createOrderDTO);

        order.getItemGroups().stream()
                .forEach(itemGroup -> itemRepository.getItemById(itemGroup.getItem().getId()).decreaseAmount(itemGroup.getAmount()));

        return this.orderMapper.toDTO(this.orderRepository.addOrders(order));
    }
}
