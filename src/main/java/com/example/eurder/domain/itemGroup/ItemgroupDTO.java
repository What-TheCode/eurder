package com.example.eurder.domain.itemGroup;

import java.time.LocalDate;

public class ItemgroupDTO {
    private final String itemId;
    private final String itemName;
    private final int amount;
    private final LocalDate shippingDate;

    public ItemgroupDTO(String itemId, String itemName, int amount, LocalDate shippingDate) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.amount = amount;
        this.shippingDate = shippingDate;
    }

    public String getItemId() {
        return itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public int getAmount() {
        return amount;
    }

    public LocalDate getShippingDate() {
        return shippingDate;
    }
}
