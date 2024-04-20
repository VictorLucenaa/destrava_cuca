package com.destravaCuca.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;

import java.time.LocalDate;

public record CreateStudentDTO(

         long id,
         @NotBlank
         String firstName,
         @NotBlank
         String middleName,

         String gender,
         @NotNull
         String phone,

         @Past
         LocalDate dateOfBirth,

         @NotBlank
         String schoolGrade) {
}
