package com.example.eurder.controller;

import com.example.eurder.domain.customer.CustomerDTO;
import com.example.eurder.domain.item.ItemDTO;
import com.example.eurder.service.CustomerService;
import com.example.eurder.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(path = "/item")
public class ItemController {

    private final ItemService itemService;

    @Autowired
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    //TODO Admin id authentication
    @PostMapping(consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public void registerItem(@RequestBody ItemDTO itemDTO) {
        this.itemService.registerItem(itemDTO);
    }


}
