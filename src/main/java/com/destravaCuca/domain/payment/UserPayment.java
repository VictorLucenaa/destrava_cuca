package com.destravaCuca.domain.payment;


import com.destravaCuca.domain.user.User;
import com.destravaCuca.dto.UserPaymentDTO;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity(name = "UserPayments")
@Table(name = "Payments")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserPayment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinTable(name = "users_payments",
    joinColumns = @JoinColumn(name = "payment_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id" )
    )
    @JsonIgnoreProperties({"id", "password", "email", "userType", "active", "dateOfBirth"})
    private User sender;

    @ManyToOne
    @JoinColumn(name = "receiver_id")
    @JsonIgnoreProperties({"id", "password", "email", "userType", "active", "dateOfBirth"})
    private User receiver;

    private BigDecimal amount;

    private LocalDate paymentDate;

    public UserPayment(UserPaymentDTO newUserPayment){
        this.sender = newUserPayment.sender();
        this.receiver = newUserPayment.receiver();
        this.amount = newUserPayment.amount();
        this.paymentDate = newUserPayment.paymentDate();
    }

}
