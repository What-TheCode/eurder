package com.example.eurder.domain.order;

import com.example.eurder.domain.itemGroup.ItemGroup;

public class OrderDTO {
    private final String customerId;
    private final ItemGroup itemGroup;

    public OrderDTO(String customerId, ItemGroup itemGroup) {
        this.customerId = customerId;
        this.itemGroup = itemGroup;
    }

    public String getCustomerId() {
        return customerId;
    }

    public ItemGroup getItemGroup() {
        return itemGroup;
    }
}
