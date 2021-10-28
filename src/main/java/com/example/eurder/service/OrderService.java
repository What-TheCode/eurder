package com.example.eurder.service;

import com.example.eurder.domain.itemGroup.ItemGroup;
import com.example.eurder.domain.itemGroup.ItemgroupDTO;
import com.example.eurder.domain.order.CreateOrderDTO;
import com.example.eurder.domain.order.Order;
import com.example.eurder.domain.order.OrderDTO;
import com.example.eurder.exception.InvalidOrderException;
import com.example.eurder.exception.NoAuthorizationException;
import com.example.eurder.mapper.OrderMapper;
import com.example.eurder.repository.CustomerRepository;
import com.example.eurder.repository.ItemRepository;
import com.example.eurder.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class OrderService {
    private static final LocalDate NEXT_DAY_SHIPPING = LocalDate.now().plusDays(1);
    private static final LocalDate NEXT_WEEK_SHIPPING = LocalDate.now().plusDays(7);

    private final OrderRepository orderRepository;
    private final CustomerRepository customerRepository;
    private final ItemRepository itemRepository;
    private final OrderMapper orderMapper;

    public OrderService(OrderRepository orderRepository, CustomerRepository customerRepository, ItemRepository itemRepository, OrderMapper orderMapper) {
        this.orderRepository = orderRepository;
        this.customerRepository = customerRepository;
        this.itemRepository = itemRepository;
        this.orderMapper = orderMapper;
    }

    public void addOrders(String customerId, CreateOrderDTO createOrderDTO) {
        if(customerRepository.getCustomers(customerId) == null) {
            throw new NoAuthorizationException("User has no access.");
        }
        if(createOrderDTO == null) {
            throw new InvalidOrderException("Invalid order.");
        }

//        orderDTO.getItemgroupDTO().stream()
//                .forEach(itemgroupDTO -> itemgroupDTO =
//                        ItemgroupDTO.newFullItemGroupDTO(
//                                itemgroupDTO.getItemId(),
//                                itemgroupDTO.getAmount(),
//                                this.calculateShippingDate(itemgroupDTO.getItemId())));

        Order order = this.orderMapper.toEntity(customerId, createOrderDTO);

        order.getItemGroup().stream()
                .forEach(itemGroup -> this.calculateShippingDate(itemGroup));

        //TODO check if this works
        this.orderRepository.addOrders(order);
    }


    //HELPER METHODS

    private void calculateShippingDate(ItemGroup itemGroup) {
        boolean isItemInStock = this.itemRepository.isItemInStock(itemGroup.getItemId());
        itemRepository.decreaseItemAmountByOne(itemGroup.getItemId());

        itemGroup.setShippingDate(isItemInStock ? NEXT_DAY_SHIPPING : NEXT_WEEK_SHIPPING);
    }

}
