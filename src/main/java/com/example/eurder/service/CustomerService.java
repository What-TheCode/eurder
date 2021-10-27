package com.example.eurder.service;

import com.example.eurder.domain.customer.CustomerDTO;
import com.example.eurder.mapper.CustomerMapper;
import com.example.eurder.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    @Autowired
    public CustomerService(CustomerRepository customerRepository, CustomerMapper customerMapper) {
        this.customerRepository = customerRepository;
        this.customerMapper = customerMapper;
    }

    public List<CustomerDTO> getCustomers() {
        return this.customerMapper.toDTO(this.customerRepository.getCustomers());
    }

    public void registerCustomer(CustomerDTO customerDTO) {
        customerRepository.registerCustomer(customerMapper.toEntity(customerDTO));
    }
}
