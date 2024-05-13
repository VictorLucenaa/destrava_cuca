package com.destravaCuca.repository;

import com.destravaCuca.domain.schoolClass.SchoolClass;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


public interface SchoolClassRepository extends JpaRepository<SchoolClass, Long> {

    Optional<SchoolClass> getReferenceById(UUID id);

}
