package com.example.eurder.service;

import com.example.eurder.domain.user.UserDTO;
import com.example.eurder.exception.InvalidUserException;
import com.example.eurder.mapper.CustomerMapper;
import com.example.eurder.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    private final UserRepository userRepository;
    private final CustomerMapper customerMapper;

    @Autowired
    public CustomerService(UserRepository userRepository, CustomerMapper customerMapper) {
        this.userRepository = userRepository;
        this.customerMapper = customerMapper;
    }

    public List<UserDTO> getCustomers(String adminId, String customerId) {
        if(!this.userRepository.isAdmin(adminId)) {
            throw new InvalidUserException("User has no access.");
        }
        return this.customerMapper.toDTO(this.userRepository.getCustomers(customerId));
    }

    public void registerCustomer(UserDTO customerDTO) {
        userRepository.registerCustomer(customerMapper.toEntity(customerDTO));
    }
}
