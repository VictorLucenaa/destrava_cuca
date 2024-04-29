package com.destravaCuca.controller;

import com.destravaCuca.domain.schoolClass.SchoolClass;
import com.destravaCuca.dto.SchoolClassDTO;
import com.destravaCuca.service.SchoolClassService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/school_classes")
public class SchoolClassController {

    @Autowired
    private SchoolClassService schoolClassService;

    @PostMapping("create")
    @Transactional
    public ResponseEntity<SchoolClass> createSchoolClass(@RequestBody @Valid SchoolClassDTO schoolClass){
    SchoolClass newSchool = schoolClassService.createSchoolClass(schoolClass);
    return new ResponseEntity<>(newSchool, HttpStatus.CREATED);
    }

    @GetMapping("/allClasses")
    public ResponseEntity<List<SchoolClass>> getSchoolClasses(){
        List<SchoolClass> schoolClasses = this.schoolClassService.getAllSchoolClasses();
        return new ResponseEntity<>(schoolClasses, HttpStatus.OK);
    }
}
