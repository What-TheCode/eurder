package com.example.eurder.domain.order;

import com.example.eurder.domain.item.price.Price;
import com.example.eurder.domain.itemGroup.CreateItemGroupDTO;
import com.example.eurder.domain.itemGroup.ItemgroupDTO;
import com.fasterxml.jackson.annotation.JsonCreator;

import java.util.List;

public class OrderDTO {
    private final String orderId;
    private final List<ItemgroupDTO> itemGroupDTOS;
    private final Price totalPrice;

    @JsonCreator
    public OrderDTO(String orderId, List<ItemgroupDTO> itemGroupDTOS, Price totalPrice) {
        this.orderId = orderId;
        this.itemGroupDTOS = itemGroupDTOS;
        this.totalPrice = totalPrice;
    }

    public String getOrderId() {
        return orderId;
    }

    public List<ItemgroupDTO> getItemGroupDTOS() {
        return itemGroupDTOS;
    }

    public Price getTotalPrice() {
        return totalPrice;
    }
}
