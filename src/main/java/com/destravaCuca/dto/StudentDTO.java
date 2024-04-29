package com.destravaCuca.dto;

import com.destravaCuca.domain.enums.GenderType;
import com.destravaCuca.domain.student.Student;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;

import java.time.LocalDate;

public record StudentDTO(

         String firstName,
         String lastName,

         @Enumerated(EnumType.STRING)
         GenderType gender,
         String phone,

         @Past
         LocalDate dateOfBirth,

         String schoolGrade) {

}









