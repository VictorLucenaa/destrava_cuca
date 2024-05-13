package com.destravaCuca.repository;

import com.destravaCuca.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;


public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findAllByActiveTrue();

    User getReferenceById(UUID id);
}
