package com.destravaCuca.dto;

import com.destravaCuca.domain.enums.UserType;

import java.time.LocalDate;

public record UserDTO(

        String firstName,
        String lastName,
        LocalDate dateOfBirth,
        String email,
        String password,
        UserType userType

        ) {
}
