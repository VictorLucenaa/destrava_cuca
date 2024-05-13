package com.destravaCuca.service;

import com.destravaCuca.domain.payment.UserPayment;
import com.destravaCuca.dto.UserPaymentDTO;
import com.destravaCuca.repository.UserPaymentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserPaymentService {

    @Autowired
   private UserPaymentsRepository userPaymentsRepository;


    // method that saves a payment in the database
    public void saveNewPayment(UserPayment data){
    this.userPaymentsRepository.save(data);
    }

    // returns a UserPayment based on his ID or throws an exception
    public UserPayment findPayment(UUID id){
        return userPaymentsRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Pagamento não encontrado!"));
    }

    public UserPayment createNewPayment(UserPaymentDTO userPaymentData){
        UserPayment newPayment = new UserPayment(userPaymentData);
        this.saveNewPayment(newPayment);
        return newPayment;
    }

    public List<UserPayment> getUserPaymentsById(UUID id) throws Exception{
      try {
       return userPaymentsRepository.findBySenderId(id);
      }catch (RuntimeException exception){
          throw new RuntimeException("Sem Histórico de pagamentos!");
      }
      }


    public void deleteUserPayment(UUID id){
      this.userPaymentsRepository.deleteById(id);
    }
}
