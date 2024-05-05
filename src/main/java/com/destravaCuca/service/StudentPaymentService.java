package com.destravaCuca.service;

import com.destravaCuca.domain.payment.StudentPayment;
import com.destravaCuca.dto.StudentPaymentDTO;
import com.destravaCuca.repository.StudentPaymentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentPaymentService {

    @Autowired
    private StudentPaymentsRepository studentPaymentsRepository;

    public void saveNewPayment(StudentPayment data){
        this.studentPaymentsRepository.save(data);
    }

    public StudentPayment findPayment(Long id){
        return  studentPaymentsRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Pagamento não encontrado!"));
    }

    public StudentPayment createNewPayment(StudentPaymentDTO studentPaymentDTO){
        StudentPayment newPayment = new StudentPayment(studentPaymentDTO);
        this.saveNewPayment(newPayment);
        return newPayment;
    }

    public List<StudentPayment> getAllStudentPayments(){
        return this.studentPaymentsRepository.findAll();
    }

    public void deleteStudentPayment(Long id){
        this.studentPaymentsRepository.deleteById(id);
    }
}
