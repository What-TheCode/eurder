package com.example.eurder.domain.user;

import com.example.eurder.domain.user.address.Address;
import com.example.eurder.domain.user.phoneNumber.PhoneNumber;
import com.fasterxml.jackson.annotation.JsonCreator;

public class UserDTO {

    private final String id;
    private final String firstName;
    private final String lastName;
    private final String emailAddress;
    private final Address address;
    private final PhoneNumber phoneNumber;

    @JsonCreator
    public UserDTO(String id, String firstName, String lastName, String emailAddress, Address address, PhoneNumber phoneNumber) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
        this.address = address;
        this.phoneNumber = phoneNumber;
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
}
