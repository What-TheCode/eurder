package com.example.eurder.domain.order;

import com.example.eurder.domain.itemGroup.ItemGroup;

import java.util.List;
import java.util.UUID;

public class Order {
    private final String id;
    private final String customerId;
    private final List<ItemGroup> itemGroups;

    public Order(String customerId, List<ItemGroup> itemGroup) {
        this.id = UUID.randomUUID().toString();
        this.customerId = customerId;
        this.itemGroups = itemGroup;
    }

    public String getId() {
        return id;
    }

    public String getCustomerId() {
        return customerId;
    }

    public List<ItemGroup> getItemGroups() {
        return itemGroups;
    }
}
