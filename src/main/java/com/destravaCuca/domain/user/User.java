package com.destravaCuca.domain.user;

import com.destravaCuca.domain.enums.UserRole;
import com.destravaCuca.dto.UserDTO;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.Past;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

@Entity(name = "users")
@Table(name = "users")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@JsonIgnoreProperties({"id", "password"})
public class User implements UserDetails {

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
    private UserRole userRole;
    private boolean active;

    public User (UserDTO newUser){
        this.firstName = newUser.firstName();
        this.lastName = newUser.lastName();
        this.dateOfBirth = newUser.dateOfBirth();
        this.email = newUser.email();
        this.password = newUser.password();
        this.userRole = newUser.userRole();
        this.active = true;


    }

    public User(String firstName, String lastName, LocalDate dateOfBirth, String email, String encryptedPassword, UserRole userRole) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
        this.password = encryptedPassword;
        this.userRole = userRole;
        this.active = true;
    }

    public void updateUser(UserDTO updatedUser){
        this.firstName = updatedUser.firstName() != null ? updatedUser.firstName() : this.firstName;
        this.lastName = updatedUser.lastName() != null ? updatedUser.lastName() : this.lastName;
        this.dateOfBirth = updatedUser.dateOfBirth() != null ? updatedUser.dateOfBirth() : this.dateOfBirth;
        this.email = updatedUser.email() != null ? updatedUser.email() : this.email;
        this.password = updatedUser.password() != null ? updatedUser.password() : this.password;
    }

    public void disableUser(){
        this.active = false;
    }

    public void enableSUser(){
        this.active = true;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (this.userRole == userRole.ADMIN) return List.of(new SimpleGrantedAuthority("ROLE_ADMIN"), new SimpleGrantedAuthority("ROLE_TEACHER"));
        else return List.of(new SimpleGrantedAuthority("ROLE_TEACHER"));
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public String getPassword(){
        return password;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
