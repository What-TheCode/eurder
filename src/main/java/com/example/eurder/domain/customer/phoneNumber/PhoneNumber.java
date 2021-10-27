package com.example.eurder.domain.customer.phoneNumber;

public class PhoneNumber {
    private final CountryCode countryCode;
    private final int number;

    public PhoneNumber(CountryCode countryCode, int number) {
        this.countryCode = countryCode;
        this.number = number;
    }

    public CountryCode getCountryCode() {
        return countryCode;
    }

    public int getNumber() {
        return number;
    }

    public String getFullPhoneNummber() {
        return String.format("%s%s", this.countryCode, this.number);
    }
}
