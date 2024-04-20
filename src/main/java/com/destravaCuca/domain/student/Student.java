package com.destravaCuca.domain.student;

import com.destravaCuca.dto.CreateStudentDTO;
import com.destravaCuca.dto.UpdateStudentDTO;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Optional;

@Table(name = "students")
@Entity(name = "student")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String firstName;
    private String middleName;

    private String gender;
    private String phone;
    private LocalDate dateOfBirth;
    private String schoolGrade;
    private boolean active;

    public Student(CreateStudentDTO newStudent){
        this.firstName = newStudent.firstName();
        this.middleName = newStudent.middleName();
        this.gender = newStudent.gender();
        this.phone = newStudent.phone();
        this.dateOfBirth = newStudent.dateOfBirth();
        this.schoolGrade = newStudent.schoolGrade();
        this.active = true;
    }




    public void updateStudent(UpdateStudentDTO updatedStudent){
        Optional.ofNullable(updatedStudent.firstName()).ifPresent(this::setFirstName);
        Optional.ofNullable(updatedStudent.middleName()).ifPresent(this::setMiddleName);
        Optional.ofNullable(updatedStudent.gender()).ifPresent(this::setGender);
        Optional.ofNullable(updatedStudent.phone()).ifPresent(this::setPhone);
        Optional.ofNullable(updatedStudent.dateOfBirth()).ifPresent(this::setDateOfBirth);
        Optional.ofNullable(updatedStudent.schoolGrade()).ifPresent(this::setSchoolGrade);
    }

    public void disableStudent(){
        this.active = false;
    }

    public void enableStudent(){
        this.active = true;
    }




}
