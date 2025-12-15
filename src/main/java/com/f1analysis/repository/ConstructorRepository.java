package com.f1analysis.repository;

import com.f1analysis.models.Constructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ConstructorRepository extends JpaRepository<Constructor, Long> {

    Optional<Constructor> findByConstructorId(String constructorId);

    Optional<Constructor> findByName(String name);
}

