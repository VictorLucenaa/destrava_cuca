package com.destravaCuca.domain.student;

import com.destravaCuca.dto.student.StudentDTO;
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
    @Column(unique=true)
    private String phone;
    private LocalDate dateOfBirth;
    private String schoolGrade;
    private boolean active;

    public Student(StudentDTO newStudent){
        this.firstName = newStudent.firstName();
        this.middleName = newStudent.middleName();
        this.gender = newStudent.gender();
        this.phone = newStudent.phone();
        this.dateOfBirth = newStudent.dateOfBirth();
        this.schoolGrade = newStudent.schoolGrade();
        this.active = true;
    }




    public void updateStudent(StudentDTO updatedStudent) {
        this.firstName = updatedStudent.firstName() != null ? updatedStudent.firstName() : this.firstName;
        this.middleName = updatedStudent.middleName() != null ? updatedStudent.middleName() : this.middleName;
        this.gender = updatedStudent.gender() != null ? updatedStudent.gender() : this.gender;
        this.phone = updatedStudent.phone() != null ? updatedStudent.phone() : this.phone;
        this.dateOfBirth = updatedStudent.dateOfBirth() != null ? updatedStudent.dateOfBirth() : this.dateOfBirth;
        this.schoolGrade = updatedStudent.schoolGrade() != null ? updatedStudent.schoolGrade() : this.schoolGrade;
        this.active = true;
    }




    public void disableStudent(){
        this.active = false;
    }

    public void enableStudent(){
        this.active = true;
    }




}
