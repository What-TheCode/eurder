package com.example.eurder.domain.user;

import com.example.eurder.domain.user.address.Address;
import com.example.eurder.domain.user.phoneNumber.PhoneNumber;
import com.example.eurder.exception.InvalidUserException;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import java.util.UUID;

public class User {
    private final String id;
    private final String firstName;
    private final String lastName;
    private final String emailAddress;
    private final Address address;
    private final PhoneNumber phoneNumber;
    private final UserRole userRole;

    public User(String firstName, String lastName, String emailAddress, Address address, PhoneNumber phoneNumber, UserRole userRole) {
        this.id = UUID.randomUUID().toString();
        this.firstName = firstName;
        this.lastName = assertValidLastName(lastName);
        this.emailAddress = assertValidEmailAddress(emailAddress);
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.userRole = userRole;
    }

    public User(String firstName, String lastName, String emailAddress, Address address, PhoneNumber phoneNumber) {
        this.id = UUID.randomUUID().toString();
        this.firstName = firstName;
        this.lastName = assertValidLastName(lastName);
        this.emailAddress = assertValidEmailAddress(emailAddress);
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.userRole = UserRole.CUSTOMER;
    }

    public String getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public Address getAddress() {
        return address;
    }

    public PhoneNumber getPhoneNumber() {
        return phoneNumber;
    }

    public UserRole getUserRole() {
        return userRole;
    }

    public Object getFullName() {
        return String.format("%s %s", this.firstName, this.lastName);
    }


    //HELPER METHODS
    public String assertValidEmailAddress(String email) {
        if(email == null || email.isBlank()) {
            throw new IllegalArgumentException("Not a valid emailAdress.");
        }
        try {
            InternetAddress emailAddr = new InternetAddress(email);
            emailAddr.validate();
        } catch (AddressException ex) {
            throw new IllegalArgumentException("Not a valid emailAdress.");
        }
        return email;
    }

    private String assertValidLastName(String lastName) {
        if(lastName == null || lastName.isBlank()) {
            throw new IllegalArgumentException("Invalid last name.");
        }
        return lastName;
    }
}
