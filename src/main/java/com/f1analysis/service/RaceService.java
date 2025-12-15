package com.f1analysis.service;

import com.f1analysis.models.Race;
import com.f1analysis.models.RaceResult;
import com.f1analysis.repository.RaceRepository;
import com.f1analysis.repository.RaceResultRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

/**
 * Service for race-related operations.
 */
@Service
public class RaceService {

    private final RaceRepository raceRepository;
    private final RaceResultRepository raceResultRepository;

    public RaceService(RaceRepository raceRepository, RaceResultRepository raceResultRepository) {
        this.raceRepository = raceRepository;
        this.raceResultRepository = raceResultRepository;
    }

    // ==================== CRUD Operations ====================

    public List<Race> getAllRaces() {
        return raceRepository.findAll();
    }

    public List<Race> getRacesBySeason(Integer season) {
        return raceRepository.findBySeasonOrderByRound(season);
    }

    public Optional<Race> getRaceById(Long id) {
        return raceRepository.findById(id);
    }

    public Race saveRace(Race race) {
        return raceRepository.save(race);
    }

    // ==================== Query Methods ====================

    public List<Race> getUpcomingRaces() {
        return raceRepository.findByRaceDateAfterOrderByRaceDate(LocalDate.now());
    }

    public Optional<Race> getNextRace() {
        List<Race> upcoming = getUpcomingRaces();
        return upcoming.isEmpty() ? Optional.empty() : Optional.of(upcoming.get(0));
    }

    /**
     * Get race results ordered by position.
     */
    public List<RaceResult> getRaceResults(Race race) {
        return raceResultRepository.findByRaceOrderByFinishPosition(race);
    }

    // ==================== Statistics ====================

    /**
     * Get historical results for a circuit.
     * 
     * TODO: Implement this method
     * - Find all races at this circuit
     * - Return results (useful for predictions)
     */
    public Object getCircuitHistory(String circuitId, int lastNRaces) {
        // TODO: Implement circuit history query
        // 1. Find circuit by circuitId
        // 2. Find all races at that circuit
        // 3. Get results for last N races
        // 4. Return structured data
        throw new UnsupportedOperationException("TODO: Implement getCircuitHistory");
    }

    /**
     * Calculate championship standings for a season.
     * 
     * TODO: Implement this method
     * - Sum up points for each driver across all races in season
     * - Return sorted standings
     */
    public Object getDriverStandings(Integer season) {
        // TODO: Implement driver championship standings
        // 1. Get all races in season
        // 2. Sum points for each driver
        // 3. Sort by total points descending
        throw new UnsupportedOperationException("TODO: Implement getDriverStandings");
    }

    /**
     * Calculate constructor championship standings.
     * 
     * TODO: Implement this method
     */
    public Object getConstructorStandings(Integer season) {
        // TODO: Implement constructor championship standings
        throw new UnsupportedOperationException("TODO: Implement getConstructorStandings");
    }
}

