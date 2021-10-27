package com.example.eurder.mapper;

import com.example.eurder.domain.item.Item;
import com.example.eurder.domain.item.ItemDTO;
import org.springframework.stereotype.Component;

@Component
public class ItemMapper {

    public Item toEntity(ItemDTO itemDTO) {
        return new Item(
                itemDTO.getName(),
                itemDTO.getDescription(),
                itemDTO.getPrice(),
                itemDTO.getAmount()
        );
    }

}
