package com.example.eurder.mapper;

import com.example.eurder.domain.customer.Customer;
import com.example.eurder.domain.customer.CustomerDTO;
import com.example.eurder.domain.customer.address.Address;
import com.example.eurder.domain.customer.phoneNumber.PhoneNumber;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CustomerMapper {

    public List<CustomerDTO> toDTO(List<Customer> customers) {
        return customers.stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public CustomerDTO toDTO(Customer customer) {
        return new CustomerDTO(
                customer.getId(),
                customer.getFirstName(),
                customer.getLastName(),
                customer.getEmailAddress(),
                customer.getAddress(),
                customer.getPhoneNumber()
        );
    }

    public Customer toEntity(CustomerDTO customerDTO) {
        return new Customer(customerDTO.getFirstName(),
                customerDTO.getLastName(),
                customerDTO.getEmailAddress(),
                new Address(
                        customerDTO.getAddress().getStreetName(),
                        customerDTO.getAddress().getHouseNumber(),
                        customerDTO.getAddress().getPostalCode(),
                        customerDTO.getAddress().getCity()
                ),
                new PhoneNumber(
                        customerDTO.getPhoneNumber().getCountryCode(),
                        customerDTO.getPhoneNumber().getNumber()
                )
        );
    }

}
