package com.example.eurder.domain.order;

import com.example.eurder.domain.itemGroup.ItemGroup;

import java.util.UUID;

public class Order {
    private final String id;
    private final String customerId;
    private final ItemGroup itemGroup;

    public Order(String customerId, ItemGroup itemGroup) {
        this.id = UUID.randomUUID().toString();
        this.customerId = customerId;
        this.itemGroup = itemGroup;
    }

    public String getId() {
        return id;
    }

    public String getCustomerId() {
        return customerId;
    }

    public ItemGroup getItemGroup() {
        return itemGroup;
    }
}
