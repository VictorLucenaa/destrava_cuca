package com.destravaCuca.service;

import com.destravaCuca.domain.schoolClass.SchoolClass;
import com.destravaCuca.dto.SchoolClassDTO;
import com.destravaCuca.repository.SchoolClassRepository;
import com.destravaCuca.repository.StudentsRepository;
import com.destravaCuca.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SchoolClassService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private StudentsRepository studentRepository;
    @Autowired
    private SchoolClassRepository SchoolClassRepository;



    // Save schoolClass into the database
    public void saveSchoolClass(SchoolClass savedSchooClass){
        this.SchoolClassRepository.save(savedSchooClass);
    }

    //create a new schoolClass
    public SchoolClass createSchoolClass(SchoolClassDTO newSchooClassData) {
        SchoolClass newClass = new SchoolClass(newSchooClassData);
        this.saveSchoolClass(newClass);
        return newClass;
    }

    // Return all schoolClasses in the database as a List
    public List<SchoolClass> getAllSchoolClasses (){
     return  this.SchoolClassRepository.findAll();
    }

    //return a schoolClass by the ID
    public SchoolClass getSchoolClass(Long id){
        return this.SchoolClassRepository.findById(id).orElseThrow(() -> new RuntimeException("Aula não encontrada!"));
    }

    //update a schoolClass
    public void updateSchoolClass(Long schoolClassId,SchoolClassDTO updatedSchoolClassData){
        var updatedSchoolClass = getSchoolClass(schoolClassId);
         updatedSchoolClass.updateClass(updatedSchoolClassData);
    }
}
