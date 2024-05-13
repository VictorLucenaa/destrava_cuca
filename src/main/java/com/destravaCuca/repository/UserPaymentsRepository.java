package com.destravaCuca.repository;

import com.destravaCuca.domain.payment.UserPayment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserPaymentsRepository extends JpaRepository<UserPayment, Long> {


    List<UserPayment> findBySenderId(UUID id);

    Optional<UserPayment> findById(UUID id);

    Optional<UserPayment> deleteById(UUID id);
}
