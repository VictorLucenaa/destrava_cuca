package com.destravaCuca.domain.schoolClass;

import com.destravaCuca.domain.enums.ClassType;
import com.destravaCuca.domain.student.Student;
import com.destravaCuca.domain.user.User;
import com.destravaCuca.dto.SchoolClassDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity(name = "classes")
@Table(name = "classes")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SchoolClass {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String classSubject;

    private String classContent;

    @Enumerated(EnumType.STRING)
    private ClassType classType;
    private Date classDate;

    @ManyToOne
    @JoinColumn(name = "teacher_id")
    @JsonIgnoreProperties({"id", "password", "email"})
    private User teacher;

    @ManyToMany
    @JoinTable(name = "class_students",
    joinColumns = @JoinColumn(name = "class_id"),
    inverseJoinColumns = @JoinColumn(name = "student_id"))
    private List<Student> students;


    public SchoolClass (SchoolClassDTO newSchooClass){
    this.classSubject = newSchooClass.classSubject();
    this.classContent = newSchooClass.classContent();
    this.classType = newSchooClass.classType();
    this.classDate = newSchooClass.classDate();
    this.teacher = newSchooClass.teacher();
    this.students = newSchooClass.students();
    }
}


