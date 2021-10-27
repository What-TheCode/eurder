package com.example.eurder.mapper;

import com.example.eurder.domain.order.Order;
import com.example.eurder.domain.order.OrderDTO;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class OrderMapper {

    public List<Order> toEntity(List<OrderDTO> orderDTOList) {
        return orderDTOList.stream()
                .map(this::toEntity)
                .collect(Collectors.toList());
    }

    public Order toEntity(OrderDTO orderDTO) {
        return new Order(
                orderDTO.getCustomerId(),
                orderDTO.getItemGroup()
        );
    }

}
