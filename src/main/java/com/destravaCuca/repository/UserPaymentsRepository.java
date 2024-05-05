package com.destravaCuca.repository;

import com.destravaCuca.domain.payment.UserPayment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserPaymentsRepository extends JpaRepository<UserPayment, Long> {


    List<UserPayment> findBySenderId(Long id);
}
