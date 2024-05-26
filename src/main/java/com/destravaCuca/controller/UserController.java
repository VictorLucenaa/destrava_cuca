package com.destravaCuca.controller;

import com.destravaCuca.domain.user.User;
import com.destravaCuca.dto.UserDTO;
import com.destravaCuca.service.UserService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;



    @PostMapping("/create")
    @Transactional
    public ResponseEntity<Void> createUser(@RequestBody @Valid UserDTO userDTO){
      userService.createUser(userDTO);
       return  new ResponseEntity<>(HttpStatus.CREATED);
    }


    @GetMapping("/all-users")
    public ResponseEntity<List<User>> getUsers(){
        List<User> allUsers = userService.getAllUsers();
        return new ResponseEntity<>(allUsers, HttpStatus.OK);
    }



    @PatchMapping("disable/{id}")
    @Transactional
    public ResponseEntity<Void> inactivateUser (@PathVariable UUID id){
        userService.inactivateUser(id);
        return ResponseEntity.ok().build();
    }
    @PatchMapping("activate/{id}")
    @Transactional
    public ResponseEntity<Void> activateUser (@PathVariable UUID id){
        userService.activateUser(id);
        return ResponseEntity.ok().build();
    }
}
