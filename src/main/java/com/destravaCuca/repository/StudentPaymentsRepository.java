package com.destravaCuca.repository;

import com.destravaCuca.domain.payment.StudentPayment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface StudentPaymentsRepository extends JpaRepository<StudentPayment, Long> {

    Optional<StudentPayment> findById(UUID id);
    Optional<StudentPayment> deleteById(UUID id);

}
