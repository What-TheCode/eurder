package com.example.eurder.domain.item;

import com.example.eurder.domain.item.price.Price;

import java.util.UUID;

public class Item {
    private final String id;
    private final String name;
    private final String description;
    private final Price price;
    private int amount;

    public Item(String name, String description, Price price, int amount) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.description = description;
        this.price = price;
        this.amount = amount;
    }

    public Item(String id, String name, String description, Price price, int amount) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.amount = amount;
    }

    public String getId() {
        return id;
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

    public void decreaseAmount(int amountToDecrease) {
        this.amount -= amountToDecrease;
    }
}
