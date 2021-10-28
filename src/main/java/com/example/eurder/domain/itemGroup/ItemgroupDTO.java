package com.example.eurder.domain.itemGroup;

import java.time.LocalDate;

public class ItemgroupDTO {
    private final String itemId;
    private final int amount;
    private final LocalDate shippingDate;

    public static ItemgroupDTO newFullItemGroupDTO(String itemId, int amount, LocalDate shippingDate) {
        return new ItemgroupDTO(itemId, amount, shippingDate);
    }

    public static ItemgroupDTO newLimitedItemGroupDTO(String itemId, int amount) {
        return new ItemgroupDTO(itemId, amount, null);
    }

    public ItemgroupDTO(String itemId, int amount, LocalDate shippingDate) {
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
}
