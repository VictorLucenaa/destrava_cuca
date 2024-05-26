package com.destravaCuca.service;


import com.destravaCuca.domain.user.User;

import com.destravaCuca.dto.UserDTO;
import com.destravaCuca.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserService {




    @Autowired
    private UserRepository userRepository;

    public void createUser(UserDTO userDTO){

        User newUser = new User(userDTO);
        userRepository.save(newUser);

    }

    // Método responsável por autenticar um usuário e retornar um token JWT


    public List<User> getAllUsers(){
        return this.userRepository.findAll();
    }

    public User getUserById(UUID id){
        return this.userRepository.getReferenceById(id);
    }


    public void inactivateUser (UUID id){
        userRepository.getReferenceById(id).disableUser();
    }

    public void activateUser (UUID id){
        userRepository.getReferenceById(id).enableSUser();
    }


}
