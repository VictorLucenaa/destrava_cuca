package com.destravaCuca.dto;

import com.destravaCuca.domain.enums.UserRole;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record UserDTO(

        @NotNull
        String firstName,
        @NotNull
        String lastName,
        @NotNull
        LocalDate dateOfBirth,
        @NotNull
        String email,
        @NotNull
        String password,

        @NotNull
        UserRole userRole

        ) {
}
