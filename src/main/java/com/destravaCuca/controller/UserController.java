package com.destravaCuca.controller;

import com.destravaCuca.domain.user.User;
import com.destravaCuca.dto.user.UserDTO;
import com.destravaCuca.service.UserService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    @Transactional
    public ResponseEntity<User> createUser(@RequestBody @Valid UserDTO user){
       User newUser = userService.createUser(user);
       return  new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<User>> getUsers(){
        List<User> allUsers = userService.getAllUsers();
        return new ResponseEntity<>(allUsers, HttpStatus.OK);
    }



    @PatchMapping("disable/{id}")
    @Transactional
    public ResponseEntity<Void> inactivateUser (@PathVariable Long id){
        userService.inactivateUser(id);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("activate/{id}")
    @Transactional
    public ResponseEntity<Void> activateUser (@PathVariable Long id){
        userService.activateUser(id);
        return ResponseEntity.ok().build();
    }
}
