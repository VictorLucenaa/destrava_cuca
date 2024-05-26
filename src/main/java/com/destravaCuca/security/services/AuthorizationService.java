package com.destravaCuca.security.services;

import com.destravaCuca.domain.user.User;
import com.destravaCuca.dto.AuthenticationDTO;
import com.destravaCuca.dto.LoginResponseDTO;
import com.destravaCuca.dto.UserDTO;
import com.destravaCuca.repository.UserRepository;
import com.destravaCuca.security.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class AuthorizationService implements UserDetailsService {

    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TokenService tokenService;

    private AuthenticationManager authenticationManager;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userRepository.findByEmail(email);
    }

    public ResponseEntity<Object> login (@RequestBody @Valid AuthenticationDTO data) {

        authenticationManager = applicationContext.getBean(AuthenticationManager.class);

        var usernamePassword = new UsernamePasswordAuthenticationToken(data.email(), data.password());
        var auth = this.authenticationManager.authenticate(usernamePassword);
        var token = tokenService.generateToken((User) auth.getPrincipal());
        return ResponseEntity.ok(new LoginResponseDTO(token));
    }

    public ResponseEntity<Object> register (@RequestBody UserDTO userDTO){
        if (this.userRepository.findByEmail(userDTO.email()) != null ) return ResponseEntity.badRequest().build();
        String encryptedPassword = new BCryptPasswordEncoder().encode(userDTO.password());

        User newUser = new User(
                userDTO.firstName(),
                userDTO.lastName(),
                userDTO.dateOfBirth(),
                userDTO.email(),
                encryptedPassword,
                userDTO.userRole());

        this.userRepository.save(newUser);
        return ResponseEntity.ok().build();
    }

}
