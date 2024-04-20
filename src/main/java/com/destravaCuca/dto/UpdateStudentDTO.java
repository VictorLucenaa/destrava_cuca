package com.destravaCuca.dto;

import com.destravaCuca.domain.student.Student;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;

import java.time.LocalDate;

public record UpdateStudentDTO(

         long id,

         String firstName,
         String middleName,

         String gender,
         String phone,

         @Past
         LocalDate dateOfBirth,

         String schoolGrade,

         Boolean active
) {

    public UpdateStudentDTO(Student student){
        this(student.getId(),
                student.getFirstName(),
                student.getMiddleName(),
                student.getGender(),
                student.getPhone(),
                student.getDateOfBirth(),
                student.getSchoolGrade(),
                student.isActive());
    }
}
