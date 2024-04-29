package com.destravaCuca.dto;

import com.destravaCuca.domain.enums.ClassType;
import com.destravaCuca.domain.student.Student;
import com.destravaCuca.domain.user.User;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;


import java.util.Date;
import java.util.List;

public record SchoolClassDTO(
         String classSubject,

         String classContent,

         @Enumerated(EnumType.STRING)
         ClassType classType,

         Date classDate,

        User teacher,

         List<Student> students
) {
}
