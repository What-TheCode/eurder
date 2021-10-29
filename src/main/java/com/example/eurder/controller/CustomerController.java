package com.example.eurder.controller;

import com.example.eurder.domain.customer.CustomerDTO;
import com.example.eurder.exception.InvalidUserException;
import com.example.eurder.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(path = "/customer")
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    //TODO Admin id authentication
    @GetMapping(produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public List<CustomerDTO> getCustomers(@RequestParam(name = "customerId", required = false) String customerId) {
        return customerService.getCustomers(customerId);
    }

    @PostMapping(consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public void registerCustomer(@RequestBody CustomerDTO customerDTO) {
        try {
            customerService.registerCustomer(customerDTO);
        } catch (InvalidUserException iue) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, iue.getMessage());
        }

    }
}
