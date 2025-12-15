package com.f1analysis.repository;

import com.f1analysis.models.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Repository for Driver entity.
 * 
 * Spring Data JPA will auto-implement these methods based on naming conventions.
 * See: https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods
 */
@Repository
public interface DriverRepository extends JpaRepository<Driver, Long> {

    // Find by Ergast driver ID
    Optional<Driver> findByDriverId(String driverId);

    // Find all drivers on a team
    List<Driver> findByTeam(String team);

    // Find by nationality
    List<Driver> findByNationality(String nationality);

    // Search by name (case-insensitive, partial match)
    List<Driver> findByNameContainingIgnoreCase(String name);

    // TODO: Add custom queries as needed
    // Example with @Query annotation:
    // @Query("SELECT d FROM Driver d WHERE d.wins > :minWins ORDER BY d.wins DESC")
    // List<Driver> findTopWinners(@Param("minWins") int minWins);
}

