package com.example.eurder.domain.order;

import com.example.eurder.domain.itemGroup.CreateItemGroupDTO;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class CreateOrderDTO {
    @JsonProperty(value = "itemGroups")
    private List<CreateItemGroupDTO> itemGroups;

    @JsonCreator
    public CreateOrderDTO(List<CreateItemGroupDTO> itemGroups) {
        this.itemGroups = itemGroups;
    }

    public List<CreateItemGroupDTO> getItemGroups() {
        return itemGroups;
    }
}
