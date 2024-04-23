package com.destravaCuca.service;

import com.destravaCuca.domain.user.User;
import com.destravaCuca.domain.user.UserType;
import com.destravaCuca.dto.user.UserDTO;
import com.destravaCuca.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User createUser(UserDTO data){
        User newUser = new User(data);
        this.saveUser(newUser);
        return  newUser;
    }

    public void saveUser (User user){
        this.userRepository.save(user);
    }

    public List<User> getAllUsers(){
        return this.userRepository.findAll();
    }

    public User getUserById(Long id){
        return this.userRepository.getReferenceById(id);
    }


    public void inactivateUser (Long id){
        userRepository.getReferenceById(id).disableUser();
    }

    public void activateUser (Long id){
        userRepository.getReferenceById(id).enableSUser();
    }

    public void deleteUser (User currentUser, Long deletedUserId) throws Exception{
        if(currentUser.getUserType() == UserType.TEACHER){
            throw new Exception("Usuário do tipo Professor não está autorizado a excluir outros usuários!");
        }
        else {
            userRepository.deleteById(deletedUserId);
        }

    }

}
