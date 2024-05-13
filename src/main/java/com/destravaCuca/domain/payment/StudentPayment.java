package com.destravaCuca.domain.payment;

import com.destravaCuca.domain.student.Student;
import com.destravaCuca.domain.user.User;
import com.destravaCuca.dto.StudentPaymentDTO;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Entity(name = "studentPayments")
@Table(name = "Payments")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StudentPayment {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    @JoinTable(name = "students_payments",
    joinColumns = @JoinColumn(name = "payment_id"),
    inverseJoinColumns = @JoinColumn(name = "student_id"))
    @JsonIgnoreProperties({"id", "phone", "active" })
    private Student sender;

    @ManyToOne
    @JoinColumn(name = "receiver_id")
    @JsonIgnoreProperties({"id", "password", "email", "userType", "active", "dateOfBirth"})
    private User receiver;

    private BigDecimal amount;

    private LocalDate paymentDate;

    public StudentPayment(StudentPaymentDTO newStudentPayment){
        this.sender = newStudentPayment.sender();
        this.receiver = newStudentPayment.receiver();
        this.amount = newStudentPayment.amount();
        this.paymentDate = newStudentPayment.paymentDate();
    }
}
