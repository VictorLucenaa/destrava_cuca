package com.destravaCuca.dto;

import jakarta.validation.constraints.NotNull;

public record AuthenticationDTO(
        @NotNull
        String email,
        @NotNull
        String password
) {
}
