package com.destravaCuca.controller;


import com.destravaCuca.domain.payment.UserPayment;
import com.destravaCuca.dto.UserPaymentDTO;
import com.destravaCuca.service.UserPaymentService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user-payments")
public class UserPaymentsController {

    @Autowired
    private UserPaymentService userPaymentService;

    @PostMapping("/new-payment")
    @Transactional
    public ResponseEntity<UserPayment> createUserPayment(@RequestBody UserPaymentDTO newUserPayment){
       var newPayment = this.userPaymentService.createNewPayment(newUserPayment);
    return new ResponseEntity<>(newPayment, HttpStatus.CREATED);
    }

    @GetMapping("/user-payments/{id}")
    public ResponseEntity<List<UserPayment>> getUserPayments(@PathVariable Long id) throws Exception{
        List<UserPayment> userPayments = this.userPaymentService.getUserPaymentsById(id);
        return new ResponseEntity<>(userPayments, HttpStatus.OK);
    }

    @DeleteMapping("/delete-payment/{id}")
    @Transactional
    public ResponseEntity<String> deletePayment(@PathVariable Long paymentId){
        deletePayment(paymentId);
        return new ResponseEntity<>("Pagamento excluído com sucesso!", HttpStatus.OK);
    }
}
