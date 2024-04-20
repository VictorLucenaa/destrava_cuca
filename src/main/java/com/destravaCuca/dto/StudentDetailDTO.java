package com.destravaCuca.dto;

import com.destravaCuca.domain.student.Student;

import java.time.LocalDate;

public record StudentDetailDTO(
        long id,
        String firstName,
        String middleName,

        String gender,
        String phone,

        LocalDate dateOfBirth,

        String schoolGrade
) {

    public StudentDetailDTO(Student studentDetails) {
        this(studentDetails.getId(),
                studentDetails.getFirstName(),
                studentDetails.getMiddleName(),
                studentDetails.getGender(),
                studentDetails.getPhone(),
                studentDetails.getDateOfBirth(),
                studentDetails.getSchoolGrade()
        );
    }
}
