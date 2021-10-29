package com.example.eurder.domain.customer;

import com.example.eurder.domain.customer.address.Address;
import com.example.eurder.domain.customer.phoneNumber.PhoneNumber;
import com.example.eurder.exception.InvalidUserException;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import java.util.UUID;

public class Customer {
    private final String id;
    private final String firstName;
    private final String lastName;
    private final String emailAddress;
    private final Address address;
    private final PhoneNumber phoneNumber;

    public Customer(String firstName, String lastName, String emailAddress, Address address, PhoneNumber phoneNumber) {
        this.id = UUID.randomUUID().toString();
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = isValidEmailAddress(emailAddress);
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

    public Object getFullName() {
        return String.format("%s %s", this.firstName, this.lastName);
    }


    //HELPER METHODS
    public String isValidEmailAddress(String email) {
        try {
            InternetAddress emailAddr = new InternetAddress(email);
            emailAddr.validate();
        } catch (AddressException ex) {
            throw new InvalidUserException("Not a valid emailAdress");
        }
        return email;
    }
}
