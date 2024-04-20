package com.destravaCuca.controller;

import com.destravaCuca.domain.student.Student;
import com.destravaCuca.dto.CreateStudentDTO;
import com.destravaCuca.dto.StudentDetailDTO;
import com.destravaCuca.dto.UpdateStudentDTO;
import com.destravaCuca.repository.StudentsRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentsRepository studentsRepository;

    @PostMapping
    @Transactional
public ResponseEntity<String> createStudent(@RequestBody @Valid CreateStudentDTO newStudentData){
    Student student = new Student(newStudentData);
    studentsRepository.save(student);
    return ResponseEntity.status(201).body("Aluno criado com sucesso!");
}

@GetMapping
    public ResponseEntity<List<Student>> listStudents(){
        return ResponseEntity.ok(studentsRepository.findAllByActiveTrue().stream()
                .sorted(Comparator.comparing(Student::getId)).collect(Collectors.toList()));
}

@PutMapping
    @Transactional
    public ResponseEntity<UpdateStudentDTO> updateStudent (@RequestBody @Valid UpdateStudentDTO updatedStudent){
        var studentToUpdate = studentsRepository.getReferenceById(updatedStudent.id());
        studentToUpdate.updateStudent(updatedStudent);
        return ResponseEntity.status(201).body(new UpdateStudentDTO(studentToUpdate));
}

@DeleteMapping("disable/{id}")
    @Transactional
    public ResponseEntity<String> inactivateStudent(@PathVariable Long id) {
       var inactivatedStudent = studentsRepository.getReferenceById(id);
       inactivatedStudent.disableStudent();
       return ResponseEntity.ok("Estudante Desativado");
}

@DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<String> deleteStudent (@PathVariable Long id) {

        var deletedStudent = studentsRepository.getReferenceById(id);
        studentsRepository.deleteById(id);
        return ResponseEntity.ok("Usuário deletado com sucesso!");

}

@PatchMapping("/{id}")
    @Transactional
    public ResponseEntity<String> activateStudent(@PathVariable Long id){
       var activatedStudent = studentsRepository.getReferenceById(id);
       activatedStudent.enableStudent();
        return ResponseEntity.ok("Aluno reativado com sucesso!");
}

@GetMapping("/{id}")
    public ResponseEntity<StudentDetailDTO> studentDetail (@PathVariable Long id){
        var studentDetails = studentsRepository.getReferenceById(id);
        return ResponseEntity.ok(new StudentDetailDTO(studentDetails));

}
}
