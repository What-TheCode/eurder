package com.example.eurder.domain;

import com.example.eurder.domain.user.User;
import com.example.eurder.domain.user.UserRole;
import com.example.eurder.domain.user.address.Address;
import com.example.eurder.domain.user.phoneNumber.CountryCode;
import com.example.eurder.domain.user.phoneNumber.PhoneNumber;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class CustomerTest {

    @Test
    @DisplayName("Register customer with empty last name throws exception")
    void whenCustomerRegisteredWithNoLastName_thenExceptionIsThrown() {
        String exceptionMessage = assertThrows(IllegalArgumentException.class, () ->
                new User("Alexander",
                        "",
                        "alex@gmail.com",
                        new Address("Dorpstraat",
                                101,
                                9000, "Gent"),
                        new PhoneNumber(CountryCode.BELGIUM,
                                123456789),
                        UserRole.CUSTOMER))
                .getMessage();

        Assertions.assertEquals("Invalid last name.", exceptionMessage);
    }

    @Test
    @DisplayName("Register customer with last name null throws exception")
    void whenCustomerRegisteredWithLastNameNull_thenExceptionIsThrown() {
        String exceptionMessage = assertThrows(IllegalArgumentException.class, () ->
                new User("Alexander",
                        null,
                        "alex@gmail.com",
                        new Address("Dorpstraat",
                                101,
                                9000, "Gent"),
                        new PhoneNumber(CountryCode.BELGIUM,
                                123456789),
                        UserRole.CUSTOMER))
                .getMessage();

        Assertions.assertEquals("Invalid last name.", exceptionMessage);
    }

    @Test
    @DisplayName("Register customer with empty emailaddress throws exception")
    void whenCustomerRegisteredWithNoEmailAddress_thenExceptionIsThrown() {
        String exceptionMessage = assertThrows(IllegalArgumentException.class, () ->
                new User("Alexander",
                        "VW",
                        "",
                        new Address("Dorpstraat",
                                101,
                                9000, "Gent"),
                        new PhoneNumber(CountryCode.BELGIUM,
                                123456789),
                        UserRole.CUSTOMER))
                .getMessage();

        Assertions.assertEquals("Not a valid emailAdress.", exceptionMessage);
    }

    @Test
    @DisplayName("Register customer with emailaddress without @ throws exception")
    void whenCustomerRegisteredWithInvalidEmailAddressNoAt_thenExceptionIsThrown() {
        String exceptionMessage = assertThrows(IllegalArgumentException.class, () ->
                new User("Alexander",
                        "VW",
                        "alexgmail.com",
                        new Address("Dorpstraat",
                                101,
                                9000, "Gent"),
                        new PhoneNumber(CountryCode.BELGIUM,
                                123456789),
                        UserRole.CUSTOMER))
                .getMessage();

        Assertions.assertEquals("Not a valid emailAdress.", exceptionMessage);
    }

    @Test
    @DisplayName("Register customer with emailaddress null throws exception")
    void whenCustomerRegisteredWithEmailAddressNull_thenExceptionIsThrown() {
        String exceptionMessage = assertThrows(IllegalArgumentException.class, () ->
                new User("Alexander",
                        "VW",
                        null,
                        new Address("Dorpstraat",
                                101,
                                9000, "Gent"),
                        new PhoneNumber(CountryCode.BELGIUM,
                                123456789),
                        UserRole.CUSTOMER))
                .getMessage();

        Assertions.assertEquals("Not a valid emailAdress.", exceptionMessage);
    }
}
