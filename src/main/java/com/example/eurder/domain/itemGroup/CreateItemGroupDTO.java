package com.example.eurder.domain.itemGroup;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CreateItemGroupDTO {
    @JsonProperty(value = "itemId")
    private String itemId;
    @JsonProperty(value = "amount")
    private int amount;

//    public CreateItemGroupDTO(String itemId, int amount) {
//        this.itemId = itemId;
//        this.amount = amount;
//    }

    public String getItem() {
        return itemId;
    }

    public int getAmount() {
        return amount;
    }
}
