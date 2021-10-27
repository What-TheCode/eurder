package com.example.eurder.controller;

import com.example.eurder.domain.order.OrderDTO;
import com.example.eurder.mapper.OrderMapper;
import com.example.eurder.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(path = "/order")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping(consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public void addOrder(@PathVariable(name = "customerId") String customerId,
                         @RequestBody List<OrderDTO> orderDTOList) {
        this.orderService.addOrders(customerId, orderDTOList);
    }
}
