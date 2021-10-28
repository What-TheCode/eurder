package com.example.eurder.repository;

import com.example.eurder.domain.customer.Customer;
import com.example.eurder.domain.customer.address.Address;
import com.example.eurder.domain.customer.phoneNumber.CountryCode;
import com.example.eurder.domain.customer.phoneNumber.PhoneNumber;
import com.example.eurder.domain.item.Item;
import com.example.eurder.domain.item.price.Currency;
import com.example.eurder.domain.item.price.Price;
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

        Item item1 = new Item("Larry vs Harry Bullitt", "Best cargo bike", new Price(Currency.EUR, 3000), 1);
        Item item2 = new Item("Canyon SLX9", "Nice road bike", new Price(Currency.EUR, 6000), 1);

        this.itemsById.put(item1.getId(), item1);
        this.itemsById.put(item2.getId(), item2);

        this.logger.info(String.format("ID item 1: %s", item1.getId()));
        this.logger.info(String.format("ID item 2: %s", item2.getId()));
    }

    public void addItem(Item item) {
        this.itemsById.put(item.getId(), item);
        logger.info(String.format("Item \"%s\" added. Id: \"%s\"", item.getName(), item.getId()));
    }


    //HELPER METHODS
    public void decreaseItemAmountByOne(String itemId) {
        this.itemsById.entrySet().stream()
                .filter(entry -> entry.getKey().equals(itemId))
                .map(Map.Entry::getValue)
                .forEach(item -> item.decreaseAmountByOne());
    }

    public boolean isItemInStock(String itemId) {
        return this.itemsById.entrySet().stream()
                .filter(entry -> entry.getKey().equals(itemId))
                .map(Map.Entry::getValue)
                .mapToInt(item -> item.getAmount()).sum()
                > 0;
    }
}
