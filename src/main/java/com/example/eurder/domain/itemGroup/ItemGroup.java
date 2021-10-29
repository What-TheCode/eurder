package com.example.eurder.domain.itemGroup;

import com.example.eurder.domain.item.Item;

import java.time.LocalDate;

public class ItemGroup {
    private static final LocalDate NEXT_DAY_SHIPPING = LocalDate.now().plusDays(1);
    private static final LocalDate NEXT_WEEK_SHIPPING = LocalDate.now().plusDays(7);

    private final Item item;
    private final int amount;
    private final LocalDate shippingDate;

    public ItemGroup(Item item, int amount) {
        this.item = item;
        this.amount = amount;
        this.shippingDate = calculateShippingDate(item, amount);
    }

    public Item getItem() {
        return item;
    }

    public int getAmount() {
        return amount;
    }

    public LocalDate getShippingDate() {
        return shippingDate;
    }


    //HELPER METHODS
    private LocalDate calculateShippingDate(Item item, int amountRequestInOrder) {
        return item.getAmount() >= amountRequestInOrder ? NEXT_DAY_SHIPPING : NEXT_WEEK_SHIPPING;
    }
}
