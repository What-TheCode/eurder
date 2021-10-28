package com.example.eurder.service;

import com.example.eurder.domain.customer.Customer;
import com.example.eurder.domain.customer.CustomerDTO;
import com.example.eurder.domain.customer.address.Address;
import com.example.eurder.domain.customer.phoneNumber.CountryCode;
import com.example.eurder.domain.customer.phoneNumber.PhoneNumber;
import com.example.eurder.mapper.CustomerMapper;
import com.example.eurder.repository.CustomerRepository;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class CustomerServiceTests {

    private CustomerService customerService;
    private CustomerRepository customerRepository;
    private CustomerMapper customerMapper;

    private Customer customer1;
    private Customer customer2;

    @BeforeEach
    public void doBefore() {
        this.customerRepository = new CustomerRepository();
        this.customerMapper = new CustomerMapper();
        this.customerService = new CustomerService(this.customerRepository, this.customerMapper);

        this.customer1 = new Customer("Alexander",
                "VW",
                "alex@gmail.com",
                new Address("Dorpstraat",
                        101,
                        9000, "Gent"),
                new PhoneNumber(CountryCode.BELGIUM,
                        123456789));
        this.customer1 = new Customer("Lisa",
                "lv",
                "lisa@outlook.com",
                new Address("Dorpstraat",
                        101,
                        9000, "Gent"),
                new PhoneNumber(CountryCode.BELGIUM,
                        123456789));
    }

    @Test
    public void whenCustomerIsRegistered_thenCustomerIsPresentInRepository() {
        this.customerRepository.registerCustomer(customer1);

        Assertions.assertEquals(customer1, this.customerRepository.getCustomers(null));
    }



}
