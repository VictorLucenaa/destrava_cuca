package com.destravaCuca.dto.user;

import com.destravaCuca.domain.user.UserType;

public record UserDTO(

        String firstName,
        String lastName,
        String email,
        String password,
        UserType userType) {
}
