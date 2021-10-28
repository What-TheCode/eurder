package com.example.eurder.domain.itemGroup;

public class CreateItemGroupDTO {
    private String itemId;
    private int amount;

//    public CreateItemGroupDTO(String itemId, int amount) {
//        this.itemId = itemId;
//        this.amount = amount;
//    }

    public String getItemId() {
        return itemId;
    }

    public int getAmount() {
        return amount;
    }
}
