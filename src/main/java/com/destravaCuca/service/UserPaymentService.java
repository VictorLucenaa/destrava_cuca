package com.destravaCuca.service;

import com.destravaCuca.domain.payment.UserPayment;
import com.destravaCuca.dto.UserPaymentDTO;
import com.destravaCuca.repository.UserPaymentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserPaymentService {

    @Autowired
   private UserPaymentsRepository userPaymentsRepository;

    public void saveNewPayment(UserPayment data){
    this.userPaymentsRepository.save(data);
    }

    public UserPayment findPayment(Long id){
        return userPaymentsRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Pagamento não encontrado!"));
    }

    public UserPayment createNewPayment(UserPaymentDTO userPaymentData){
        UserPayment newPayment = new UserPayment(userPaymentData);
        this.saveNewPayment(newPayment);
        return newPayment;
    }

    public List<UserPayment> getUserPaymentsById(Long id) throws Exception{
      try {
       return userPaymentsRepository.findBySenderId(id);
      }catch (RuntimeException exception){
          throw new RuntimeException("Sem Histórico de pagamentos!");
      }
      }


    public void deleteUserPayment(Long id){
      this.userPaymentsRepository.deleteById(id);
    }
}
