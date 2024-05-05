package com.destravaCuca.dto;

import com.destravaCuca.domain.student.Student;
import com.destravaCuca.domain.user.User;

import java.math.BigDecimal;
import java.time.LocalDate;

public record StudentPaymentDTO(
         Student sender,
         User receiver,
         BigDecimal amount,
         LocalDate paymentDate
        ) {
}
