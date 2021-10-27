package com.example.eurder.service;

import com.example.eurder.domain.item.ItemDTO;
import com.example.eurder.mapper.ItemMapper;
import com.example.eurder.repository.ItemRepository;
import org.springframework.stereotype.Service;

@Service
public class ItemService {
    private ItemRepository itemRepository;
    private ItemMapper itemMapper;

    public ItemService(ItemRepository itemRepository, ItemMapper itemMapper) {
        this.itemRepository = itemRepository;
        this.itemMapper = itemMapper;
    }

    public void registerItem(ItemDTO itemDTO) {
        this.itemRepository.addItem(this.itemMapper.toEntity(itemDTO));
    }
}
