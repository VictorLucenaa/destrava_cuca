package com.destravaCuca.controller;

import com.destravaCuca.domain.student.Student;
import com.destravaCuca.dto.student.StudentDTO;
import com.destravaCuca.service.StudentService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping
    @Transactional
public ResponseEntity<Student> createStudent(@RequestBody @Valid StudentDTO newStudentData){
    Student newStudent = studentService.createStudent(newStudentData);
    return new ResponseEntity<>(newStudent, HttpStatus.CREATED);
}

@GetMapping
    public ResponseEntity<List<Student>> listStudents(){
        List<Student> students = studentService.getAllStudents();
        return new ResponseEntity<>(students, HttpStatus.OK);
}

@PutMapping("update/{id}")
    @Transactional
    public ResponseEntity<StudentDTO> updateStudent (@PathVariable Long id, @RequestBody @Valid StudentDTO updatedStudent){
        var studentToUpdate = studentService.updateStudent(id, updatedStudent);
        return new ResponseEntity<>(studentToUpdate, HttpStatus.OK);
}

@DeleteMapping("disable/{id}")
    @Transactional
    public ResponseEntity<Void> inactivateStudent(@PathVariable Long id) {
       studentService.inactivateStudent(id);
       return ResponseEntity.ok().build();
}

@DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> deleteStudent (@PathVariable Long id) {
       studentService.deleteStudent(id);
        return ResponseEntity.ok().build();

}

@PatchMapping("activate/{id}")
    @Transactional
    public ResponseEntity<Void> activateStudent(@PathVariable Long id){
       studentService.activateStudent(id);
        return ResponseEntity.ok().build();
}

//@GetMapping("/{id}")
//    public ResponseEntity<StudentDetailDTO> studentDetail (@PathVariable Long id){
//        var studentDetails = studentsRepository.getReferenceById(id);
//        return ResponseEntity.ok(new StudentDetailDTO(studentDetails));
//
//}
}
