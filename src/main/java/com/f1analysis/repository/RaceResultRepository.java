package com.f1analysis.repository;

import com.f1analysis.models.Driver;
import com.f1analysis.models.Race;
import com.f1analysis.models.RaceResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RaceResultRepository extends JpaRepository<RaceResult, Long> {

    // Get all results for a race
    List<RaceResult> findByRaceOrderByFinishPosition(Race race);

    // Get all results for a driver
    List<RaceResult> findByDriverOrderByRaceDesc(Driver driver);

    // Get driver's results in a season
    List<RaceResult> findByDriverAndRaceSeasonOrderByRaceRound(Driver driver, Integer season);

    // TODO: Add custom queries for statistics
    // Example: Count wins, podiums, etc.
}

