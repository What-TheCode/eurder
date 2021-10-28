package com.example.eurder.domain.itemGroup;

import java.time.LocalDate;
import java.util.UUID;

public class ItemGroup {
    private final String itemId;
    private final int amount;
    private LocalDate shippingDate;

    public ItemGroup(String itemId, int amount, LocalDate shippingDate) {
        this.itemId = itemId;
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

    public void setShippingDate(LocalDate shippingDate) {
        this.shippingDate = shippingDate;
    }
}
