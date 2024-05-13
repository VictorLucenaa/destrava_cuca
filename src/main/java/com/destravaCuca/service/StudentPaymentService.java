package com.destravaCuca.service;

import com.destravaCuca.domain.payment.StudentPayment;
import com.destravaCuca.dto.StudentPaymentDTO;
import com.destravaCuca.repository.StudentPaymentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class StudentPaymentService {

    @Autowired
    private StudentPaymentsRepository studentPaymentsRepository;

    // Save a new payment in the database
    public void saveNewPayment(StudentPayment data){
        this.studentPaymentsRepository.save(data);
    }


    // Find a payment in the databse with the ID
    public StudentPayment findPayment(UUID id){
        return  studentPaymentsRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Pagamento não encontrado!"));
    }

    // Create a new payment and stores in the databse
    public StudentPayment createNewPayment(StudentPaymentDTO studentPaymentDTO){
        StudentPayment newPayment = new StudentPayment(studentPaymentDTO);
        this.saveNewPayment(newPayment);
        return newPayment;
    }

    //  return a list of all the students payments
    public List<StudentPayment> getAllStudentPayments(){
        return this.studentPaymentsRepository.findAll();
    }

    // remove a student payment from database
    public void deleteStudentPayment(UUID id){
        this.studentPaymentsRepository.deleteById(id);
    }
}
