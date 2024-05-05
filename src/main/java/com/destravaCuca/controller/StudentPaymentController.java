package com.destravaCuca.controller;

import com.destravaCuca.domain.payment.StudentPayment;
import com.destravaCuca.dto.StudentPaymentDTO;
import com.destravaCuca.service.StudentPaymentService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student-payments")
public class StudentPaymentController {

    @Autowired
    private StudentPaymentService studentPaymentService;

    @PostMapping("/new-payment")
    @Transactional
    public ResponseEntity<StudentPayment> createStudentPayment(@RequestBody StudentPaymentDTO newStudentPayment){
        var newPayment = this.studentPaymentService.createNewPayment(newStudentPayment);
        return  new ResponseEntity<>(newPayment, HttpStatus.CREATED);
    }

    @GetMapping("/student-payments")
    public ResponseEntity<List<StudentPayment>> getStudentPayments(){
        List<StudentPayment> studentPayments = this.studentPaymentService.getAllStudentPayments();
        return new ResponseEntity<>(studentPayments, HttpStatus.OK);
    }

    @DeleteMapping("/delete-payment/{id}")
    @Transactional
    public ResponseEntity<String> deletePayment(@PathVariable Long id){
        deletePayment(id);
        return new ResponseEntity<>("Pagamento excluído com sucesso!", HttpStatus.OK);
    }
}
