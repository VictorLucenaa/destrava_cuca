package com.destravaCuca.dto.student;

import com.destravaCuca.domain.student.Student;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;

import java.time.LocalDate;

public record StudentDTO(

         String firstName,
         String middleName,

         String gender,
         String phone,

         @Past
         LocalDate dateOfBirth,

         String schoolGrade) {

}









