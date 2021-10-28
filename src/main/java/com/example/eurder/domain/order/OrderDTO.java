package com.example.eurder.domain.order;

import com.example.eurder.domain.itemGroup.CreateItemGroupDTO;
import com.example.eurder.domain.itemGroup.ItemgroupDTO;

import java.util.List;

public class OrderDTO {
    private final List<ItemgroupDTO> itemGroupDTOS;

    public OrderDTO(List<ItemgroupDTO> itemGroupDTOS) {
        this.itemGroupDTOS = itemGroupDTOS;
    }

    public List<ItemgroupDTO> getItemGroupDTOS() {
        return itemGroupDTOS;
    }
}
