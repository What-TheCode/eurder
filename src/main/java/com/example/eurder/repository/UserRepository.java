package com.example.eurder.repository;

import com.example.eurder.domain.user.User;
import com.example.eurder.domain.user.UserRole;
import com.example.eurder.domain.user.address.Address;
import com.example.eurder.domain.user.phoneNumber.CountryCode;
import com.example.eurder.domain.user.phoneNumber.PhoneNumber;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

@Repository
public class UserRepository {
    private final Map<String, User> customersById;
    private final Logger logger = LoggerFactory.getLogger(UserRepository.class);

    public UserRepository() {
        this.customersById = new ConcurrentHashMap<>();

        //TESTDATA
        User admin = new User("Alexander",
                "VW",
                "alex@gmail.com",
                new Address("Dorpstraat",
                        101,
                        9000, "Gent"),
                new PhoneNumber(CountryCode.BELGIUM,
                        123456789),
                UserRole.ADMIN);
        User customer = new User("Lisa",
                "Vs",
                "lisa@outlook.com",
                new Address("Dorpstraat",
                        101,
                        9000, "Gent"),
                new PhoneNumber(CountryCode.BELGIUM,
                        987654321),
                UserRole.CUSTOMER);

        this.customersById.put(admin.getId(), admin);
        this.customersById.put(customer.getId(), customer);

        this.logger.info(String.format("ID admin: %s", admin.getId()));
        this.logger.info(String.format("ID customer: %s", customer.getId()));
    }

    public List<User> getCustomers(String customerId) {
        this.logger.info(String.format("All customers retrieved (amount: %s)", this.customersById.size()));
        return this.customersById.values().stream()
                .filter(user -> customerId == null || user.getId().equals(customerId))
                .collect(Collectors.toList());
    }

    public void registerCustomer(User user) {
        this.customersById.put(user.getId(), user);
        this.logger.info(String.format("Customer \"%s\" created. Id: \"%s\"", user.getFullName(), user.getId()));
    }


    //HELPER METHODS
    public boolean isCustomer(String memberId) {
        return this.customersById.containsKey(memberId) &&
                this.customersById.get(memberId).getUserRole() == UserRole.CUSTOMER;
    }

    public boolean isAdmin(String memberId) {
        return this.customersById.containsKey(memberId) &&
                this.customersById.get(memberId).getUserRole() == UserRole.ADMIN;
    }
}
