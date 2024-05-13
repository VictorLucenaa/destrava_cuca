package com.destravaCuca.service;

import com.destravaCuca.domain.student.Student;
import com.destravaCuca.dto.StudentDTO;
import com.destravaCuca.repository.StudentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class StudentService {

    @Autowired
    private StudentsRepository studentsRepository;

    // create a new student and saves it in the database
    public Student createStudent(StudentDTO data){
        Student newStudent = new Student(data);
        this.saveStudent(newStudent);
        return newStudent;
    }

    // Method to save the student in the database
    public void saveStudent(Student student){
        this.studentsRepository.save(student);
    }



    // Return a list of all the students in the databse
    public List<Student> getAllStudents(){
        return this.studentsRepository.findAll();
    }

    // search a student based on his ID
    public Student getStudent(UUID id){
        return this.studentsRepository.getReferenceById(id);
    }

    // Update student info
    public StudentDTO updateStudent (UUID id, StudentDTO student){
        var studentToUpdate = this.getStudent(id);
        studentToUpdate.updateStudent(student);

        return new StudentDTO(
                studentToUpdate.getFirstName(),
                studentToUpdate.getLastName(),
                studentToUpdate.getGender(),
                studentToUpdate.getPhone(),
                studentToUpdate.getDateOfBirth(),
                studentToUpdate.getSchoolGrade()
        );


    }


    public void inactivateStudent (UUID id){
        var inactivatedStudent = this.getStudent(id);
        inactivatedStudent.disableStudent();
    }

    public void activateStudent(UUID id){
        var activatedStudent = this.getStudent(id);
                activatedStudent.enableStudent();
    }

    public void deleteStudent (UUID id){
        studentsRepository.deleteById(id);
    }
}
