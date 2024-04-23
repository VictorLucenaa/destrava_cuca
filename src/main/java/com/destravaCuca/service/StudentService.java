package com.destravaCuca.service;

import com.destravaCuca.domain.student.Student;
import com.destravaCuca.dto.student.StudentDTO;
import com.destravaCuca.repository.StudentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentsRepository studentsRepository;

    public Student createStudent(StudentDTO data){
        Student newStudent = new Student(data);
        this.saveStudent(newStudent);
        return newStudent;
    }

    public void saveStudent(Student student){
        this.studentsRepository.save(student);
    }

    public List<Student> getAllStudents(){
        return this.studentsRepository.findAll();
    }

    public Student getStudent(Long id){
        return this.studentsRepository.getReferenceById(id);
    }

    public StudentDTO updateStudent (Long id, StudentDTO student){
        var studentToUpdate = this.getStudent(id);
        studentToUpdate.updateStudent(student);

        return new StudentDTO(
                studentToUpdate.getFirstName(),
                studentToUpdate.getMiddleName(),
                studentToUpdate.getGender(),
                studentToUpdate.getPhone(),
                studentToUpdate.getDateOfBirth(),
                studentToUpdate.getSchoolGrade()
        );


    }

    public void inactivateStudent (Long id){
        var inactivatedStudent = this.getStudent(id);
        inactivatedStudent.disableStudent();
    }

    public void activateStudent(Long id){
        var activatedStudent = this.getStudent(id);
                activatedStudent.enableStudent();
    }

    public void deleteStudent (Long id){
        studentsRepository.deleteById(id);
    }
}
