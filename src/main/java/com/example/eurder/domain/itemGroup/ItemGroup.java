package com.example.eurder.domain.itemGroup;

import java.time.LocalDate;
import java.util.UUID;

public class ItemGroup {
    private final String itemId;
    private final int amount;
    private final LocalDate shippingDate;

    public ItemGroup(int amount, LocalDate shippingDate) {
        this.itemId = UUID.randomUUID().toString();
        this.amount = amount;
        this.shippingDate = shippingDate;
    }

    public String getItemId() {
        return itemId;
    }

    public int getAmount() {
        return amount;
    }

    public LocalDate getShippingDate() {
        return shippingDate;
    }
}
