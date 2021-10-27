package com.example.eurder.repository;

import com.example.eurder.domain.item.Item;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class ItemRepository {
    private Map<String, Item> itemsById;
    private Logger logger = LoggerFactory.getLogger(ItemRepository.class);

    public ItemRepository() {
        this.itemsById = new ConcurrentHashMap<>();
    }

    public void addItem(Item item) {
        this.itemsById.put(item.getId(), item);
        logger.info(String.format("Item \"%s\" added", item.getName()));
    }
}
