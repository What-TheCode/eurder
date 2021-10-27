package com.example.eurder.domain.item.price;

public class Price {
    private final Currency currency;
    private final int amount;

    public Price(Currency currency, int amount) {
        this.currency = currency;
        this.amount = amount;
    }

    public Currency getCurrency() {
        return currency;
    }

    public int getAmount() {
        return amount;
    }
}
