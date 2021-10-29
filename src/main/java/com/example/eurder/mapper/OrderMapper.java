package com.example.eurder.mapper;

import com.example.eurder.domain.item.price.Currency;
import com.example.eurder.domain.item.price.Price;
import com.example.eurder.domain.itemGroup.CreateItemGroupDTO;
import com.example.eurder.domain.itemGroup.ItemGroup;
import com.example.eurder.domain.itemGroup.ItemgroupDTO;
import com.example.eurder.domain.order.CreateOrderDTO;
import com.example.eurder.domain.order.Order;
import com.example.eurder.domain.order.OrderDTO;
import com.example.eurder.repository.ItemRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class OrderMapper {
    private final ItemRepository itemRepository;

    public OrderMapper(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public Order toEntity(String customerId, CreateOrderDTO createOrderDTO) {
        //TODO Currency absolutely not correct!
        return new Order(customerId,
                this.toEntity(createOrderDTO.getItemGroups()),
                new Price(Currency.EUR,
                        createOrderDTO.getItemGroups().stream()
                                .mapToInt(item -> itemRepository.calculateTotalPrice(item.getItemId(), item.getAmount()))
                                .sum()));
    }

    private List<ItemGroup> toEntity(List<CreateItemGroupDTO> createItemGroupDTOS) {
        return createItemGroupDTOS.stream()
                .map(this::toEntity)
                .collect(Collectors.toList());
    }

    private ItemGroup toEntity(CreateItemGroupDTO createItemGroupDTO) {
        return new ItemGroup(
                this.itemRepository.getItemById(createItemGroupDTO.getItemId()),
                createItemGroupDTO.getAmount()
        );
    }

    public OrderDTO toDTO(Order order) {
        return new OrderDTO(
                order.getId(),
                order.getItemGroups().stream()
                        .map(this::toDTO)
                        .collect(Collectors.toList()),
                order.getTotalPrice()
        );
    }

    private ItemgroupDTO toDTO(ItemGroup itemGroup) {
        return new ItemgroupDTO(
                itemGroup.getItem().getId(),
                itemRepository.getItemById(itemGroup.getItem().getId()).getName(),
                itemGroup.getAmount(),
                itemGroup.getShippingDate());
    }
}
