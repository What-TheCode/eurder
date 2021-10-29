package com.example.eurder.service;

import com.example.eurder.domain.item.ItemDTO;
import com.example.eurder.exception.InvalidUserException;
import com.example.eurder.mapper.ItemMapper;
import com.example.eurder.repository.ItemRepository;
import com.example.eurder.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class ItemService {
    private ItemRepository itemRepository;
    private UserRepository userRepository;
    private ItemMapper itemMapper;

    public ItemService(ItemRepository itemRepository, UserRepository userRepository, ItemMapper itemMapper) {
        this.itemRepository = itemRepository;
        this.userRepository = userRepository;
        this.itemMapper = itemMapper;
    }

    public void registerItem(String adminId, ItemDTO itemDTO) {
        if(!this.userRepository.isAdmin(adminId)) {
            throw new InvalidUserException("User has no access.");
        }

        this.itemRepository.addItem(this.itemMapper.toEntity(itemDTO));
    }
}
