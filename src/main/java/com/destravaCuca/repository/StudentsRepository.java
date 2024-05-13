package com.destravaCuca.repository;

import com.destravaCuca.domain.student.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface StudentsRepository extends JpaRepository<Student, Long> {

    List<Student> findAllByActiveTrue();

    Student getReferenceById(UUID id);

     void deleteById(UUID id);
}
