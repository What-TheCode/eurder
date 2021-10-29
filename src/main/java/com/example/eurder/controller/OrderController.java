package com.example.eurder.controller;

import com.example.eurder.domain.itemGroup.ItemgroupDTO;
import com.example.eurder.domain.order.CreateOrderDTO;
import com.example.eurder.domain.order.Order;
import com.example.eurder.domain.order.OrderDTO;
import com.example.eurder.exception.InvalidItemException;
import com.example.eurder.exception.InvalidOrderException;
import com.example.eurder.exception.NoAuthorizationException;
import com.example.eurder.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping(path = "/order")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public OrderDTO addOrder(@RequestParam(name = "customerId") String customerId,
                             @RequestBody CreateOrderDTO createOrderDTO) {
        try {
            return this.orderService.addOrders(customerId, createOrderDTO);
        } catch (NoAuthorizationException | InvalidOrderException | InvalidItemException exception) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, exception.getMessage());
        }
    }
}
