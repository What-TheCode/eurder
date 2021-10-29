package com.example.eurder.domain.order;

import com.example.eurder.domain.itemGroup.CreateItemGroupDTO;
import com.example.eurder.domain.itemGroup.ItemgroupDTO;

import java.util.List;

public class OrderDTO {
    private final String orderId;
    private final List<ItemgroupDTO> itemGroupDTOS;

    public OrderDTO(String orderId, List<ItemgroupDTO> itemGroupDTOS) {
        this.orderId = orderId;
        this.itemGroupDTOS = itemGroupDTOS;
    }

    public String getOrderId() {
        return orderId;
    }

    public List<ItemgroupDTO> getItemGroupDTOS() {
        return itemGroupDTOS;
    }
}
