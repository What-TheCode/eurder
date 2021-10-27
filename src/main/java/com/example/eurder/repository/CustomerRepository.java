package com.example.eurder.repository;

import com.example.eurder.domain.customer.Customer;
import com.example.eurder.domain.customer.CustomerDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

@Repository
public class CustomerRepository {
    private final Map<String, Customer> customersById;
    private final Logger logger = LoggerFactory.getLogger(CustomerRepository.class);

    public CustomerRepository() {
        this.customersById = new ConcurrentHashMap<>();
    }

    public List<Customer> getCustomers() {
        this.logger.info(String.format("All customers retrieved (%s)", this.customersById.size()));
        return this.customersById.entrySet().stream()
                .map(set -> set.getValue())
                .collect(Collectors.toList());
    }

    public void registerCustomer(Customer customer) {
        this.customersById.put(customer.getId(), customer);
        this.logger.info(String.format("Customer with id %s created", customer.getId()));
    }
}
