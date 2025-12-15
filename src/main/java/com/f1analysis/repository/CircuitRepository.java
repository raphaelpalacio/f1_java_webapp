package com.f1analysis.repository;

import com.f1analysis.models.Circuit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CircuitRepository extends JpaRepository<Circuit, Long> {

    Optional<Circuit> findByCircuitId(String circuitId);

    List<Circuit> findByCountry(String country);
}

