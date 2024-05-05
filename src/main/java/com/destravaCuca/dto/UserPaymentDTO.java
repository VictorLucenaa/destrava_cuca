package com.destravaCuca.dto;

import com.destravaCuca.domain.user.User;

import java.math.BigDecimal;
import java.time.LocalDate;

public record UserPaymentDTO(
        User sender,
        User receiver,
        BigDecimal amount,
        LocalDate paymentDate
) {
}
