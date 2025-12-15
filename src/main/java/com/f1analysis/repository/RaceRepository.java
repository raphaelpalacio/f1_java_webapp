package com.f1analysis.repository;

import com.f1analysis.models.Race;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface RaceRepository extends JpaRepository<Race, Long> {

    // Find all races in a season
    List<Race> findBySeasonOrderByRound(Integer season);

    // Find specific race
    Optional<Race> findBySeasonAndRound(Integer season, Integer round);

    // Find upcoming races
    List<Race> findByRaceDateAfterOrderByRaceDate(LocalDate date);

    // TODO: Add more query methods as needed
}

