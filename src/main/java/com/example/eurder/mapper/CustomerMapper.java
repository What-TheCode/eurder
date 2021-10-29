package com.example.eurder.mapper;

import com.example.eurder.domain.user.User;
import com.example.eurder.domain.user.UserDTO;
import com.example.eurder.domain.user.address.Address;
import com.example.eurder.domain.user.phoneNumber.PhoneNumber;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CustomerMapper {

    public List<UserDTO> toDTO(List<User> users) {
        return users.stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public UserDTO toDTO(User user) {
        return new UserDTO(
                user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getEmailAddress(),
                user.getAddress(),
                user.getPhoneNumber()
        );
    }

    public User toEntity(UserDTO customerDTO) {
        return new User(customerDTO.getFirstName(),
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
