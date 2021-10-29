package com.example.eurder.domain.itemGroup;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CreateItemGroupDTO {
    @JsonProperty(value = "itemId")
    private String itemId;
    @JsonProperty(value = "amount")
    private int amount;

    @JsonCreator
    public CreateItemGroupDTO(String itemId, int amount) {
        this.itemId = itemId;
        this.amount = amount;
    }

    public String getItemId() {
        return itemId;
    }

    public int getAmount() {
        return amount;
    }
}
