package com.example.eurder.controller;

import com.example.eurder.domain.item.ItemDTO;
import com.example.eurder.exception.InvalidUserException;
import com.example.eurder.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

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
    public void registerItem(@RequestParam(name = "adminId") String adminId,
                             @RequestBody ItemDTO itemDTO) {
        try {
            this.itemService.registerItem(adminId, itemDTO);
        } catch (InvalidUserException exception) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, exception.getMessage());
        }

    }


}
