package com.destravaCuca.repository;

import com.destravaCuca.domain.schoolClass.SchoolClass;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface SchoolClassRepository extends JpaRepository<SchoolClass, Long> {

    SchoolClass save(SchoolClass schoolClass);

}
