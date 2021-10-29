package com.example.eurder.repository;

import com.example.eurder.domain.customer.Customer;
import com.example.eurder.domain.customer.CustomerDTO;
import com.example.eurder.domain.customer.address.Address;
import com.example.eurder.domain.customer.phoneNumber.CountryCode;
import com.example.eurder.domain.customer.phoneNumber.PhoneNumber;
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

        //TESTDATA
        Customer customer = new Customer("Alexander",
                "VW",
                "alex@gmail.com",
                new Address("Dorpstraat",
                        101,
                        9000, "Gent"),
                new PhoneNumber(CountryCode.BELGIUM,
                        123456789));
        this.customersById.put(customer.getId(), customer);

        this.logger.info(String.format("ID customer: %s", customer.getId()));
    }

    public List<Customer> getCustomers(String customerId) {
        this.logger.info(String.format("All customers retrieved (amount: %s)", this.customersById.size()));
        return this.customersById.values().stream()
                .filter(customer -> customerId == null || customer.getId().equals(customerId))
                .collect(Collectors.toList());
    }

    public void registerCustomer(Customer customer) {
        this.customersById.put(customer.getId(), customer);
        this.logger.info(String.format("Customer \"%s\" created. Id: \"%s\"", customer.getFullName(), customer.getId()));
    }


    //HELPER METHODS
    public boolean isCustomer(String memberId) {
        return this.customersById.containsKey(memberId);
    }
}
