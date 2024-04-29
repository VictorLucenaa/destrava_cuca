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



    public void saveSchoolClass(SchoolClass savedSchooClass){
        this.SchoolClassRepository.save(savedSchooClass);
    }

    public SchoolClass createSchoolClass(SchoolClassDTO newSchooClassData) {
        SchoolClass newClass = new SchoolClass(newSchooClassData);
        this.saveSchoolClass(newClass);
        return newClass;
    }

    public List<SchoolClass> getAllSchoolClasses (){
     return  this.SchoolClassRepository.findAll();
    }
}
