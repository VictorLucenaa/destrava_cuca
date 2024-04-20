package com.destravaCuca.repository;

import com.destravaCuca.domain.student.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentsRepository extends JpaRepository<Student, Long> {

    List<Student> findAllByActiveTrue();
}
