package com.destravaCuca.domain.user;

import com.destravaCuca.domain.enums.UserType;
import com.destravaCuca.dto.UserDTO;
import jakarta.persistence.*;
import lombok.*;

@Entity(name = "users")
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    @Column(unique = true)
    private String email;
    private String password;
    @Enumerated(EnumType.STRING)
    private UserType userType;
    private boolean active;

    public User (UserDTO newUser){
        this.firstName = newUser.firstName();
        this.lastName = newUser.lastName();
        this.email = newUser.email();
        this.password = newUser.password();
        this.userType = newUser.userType();
        this.active = true;
    }

    public void updateUser(UserDTO updatedUser){
        this.firstName = updatedUser.firstName() != null ? updatedUser.firstName() : this.firstName;
        this.lastName = updatedUser.lastName() != null ? updatedUser.lastName() : this.lastName;
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
