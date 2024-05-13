package com.destravaCuca.domain.user;

import com.destravaCuca.domain.enums.UserType;
import com.destravaCuca.dto.UserDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.Past;
import lombok.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity(name = "users")
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String firstName;
    private String lastName;

    @Past
    private LocalDate dateOfBirth;
    @Column(unique = true)
    private String email;
    private String password;
    @Enumerated(EnumType.STRING)
    private UserType userType;
    private boolean active;

    public User (UserDTO newUser){
        this.firstName = newUser.firstName();
        this.lastName = newUser.lastName();
        this.dateOfBirth = newUser.dateOfBirth();
        this.email = newUser.email();
        this.password = newUser.password();
        this.userType = newUser.userType();
        this.active = true;
    }

    public void updateUser(UserDTO updatedUser){
        this.firstName = updatedUser.firstName() != null ? updatedUser.firstName() : this.firstName;
        this.lastName = updatedUser.lastName() != null ? updatedUser.lastName() : this.lastName;
        this.dateOfBirth = updatedUser.dateOfBirth() != null ? updatedUser.dateOfBirth() : this.dateOfBirth;
        this.email = updatedUser.email() != null ? updatedUser.email() : this.email;
        this.password = updatedUser.password() != null ? updatedUser.password() : this.password;
        this.userType = updatedUser.userType() != null ? updatedUser.userType() : this.userType;
    }

    public void disableUser(){
        this.active = false;
    }

    public void enableSUser(){
        this.active = true;
    }


}
