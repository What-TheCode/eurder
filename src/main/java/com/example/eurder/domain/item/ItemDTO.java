package com.example.eurder.domain.item;

import com.example.eurder.domain.item.price.Price;

public class ItemDTO {
    private final String name;
    private final String description;
    private final Price price;
    private final int amount;

    public ItemDTO(String name, String description, Price price, int amount) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Price getPrice() {
        return price;
    }

    public int getAmount() {
        return amount;
    }
}
