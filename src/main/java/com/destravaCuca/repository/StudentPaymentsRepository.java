package com.destravaCuca.repository;

import com.destravaCuca.domain.payment.StudentPayment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentPaymentsRepository extends JpaRepository<StudentPayment, Long> {
}
