package com.destravaCuca.dto;

import com.destravaCuca.domain.enums.UserType;

public record UserDTO(

        String firstName,
        String lastName,
        String email,
        String password,
        UserType userType

        ) {
}
