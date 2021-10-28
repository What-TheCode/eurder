package com.example.eurder.domain.order;

import com.example.eurder.domain.itemGroup.CreateItemGroupDTO;

import java.util.List;

public class CreateOrderDTO {
    private List<CreateItemGroupDTO> createItemGroupDTOS;

//    public CreateOrderDTO(List<CreateItemGroupDTO> createItemGroupDTOS) {
//        this.createItemGroupDTOS = createItemGroupDTOS;
//    }

    public List<CreateItemGroupDTO> getCreateItemGroupDTOS() {
        return createItemGroupDTOS;
    }
}
