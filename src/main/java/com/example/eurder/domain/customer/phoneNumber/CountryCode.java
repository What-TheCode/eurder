package com.example.eurder.domain.customer.phoneNumber;

public enum CountryCode {
    NETHERLANDS("+31"),
    BELGIUM("+32"),
    FRANCE("+33");

    private final String code;

    CountryCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
