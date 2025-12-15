package com.f1analysis.service;

import com.f1analysis.models.Driver;
import com.f1analysis.repository.DriverRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Service for driver-related operations.
 */
@Service
public class DriverService {

    private final DriverRepository driverRepository;

    public DriverService(DriverRepository driverRepository) {
        this.driverRepository = driverRepository;
    }

    // ==================== CRUD Operations ====================

    public List<Driver> getAllDrivers() {
        return driverRepository.findAll();
    }

    public Optional<Driver> getDriverById(Long id) {
        return driverRepository.findById(id);
    }

    public Optional<Driver> getDriverByDriverId(String driverId) {
        return driverRepository.findByDriverId(driverId);
    }

    public Driver saveDriver(Driver driver) {
        return driverRepository.save(driver);
    }

    public void deleteDriver(Long id) {
        driverRepository.deleteById(id);
    }

    // ==================== Search & Filter ====================

    public List<Driver> searchDrivers(String query) {
        // TODO: Implement search logic
        // Search by name, team, or nationality
        return driverRepository.findByNameContainingIgnoreCase(query);
    }

    public List<Driver> getDriversByTeam(String team) {
        return driverRepository.findByTeam(team);
    }

    // ==================== Statistics ====================

    /**
     * Calculate and return driver career statistics.
     * 
     * TODO: Implement this method
     * - Query RaceResultRepository for all driver's results
     * - Calculate wins, podiums, points, etc.
     * - Return a DriverStats DTO (you'll need to create this)
     */
    public Object getDriverStats(String driverId) {
        // TODO: Implement driver statistics calculation
        // 1. Get driver by driverId
        // 2. Query all their race results
        // 3. Calculate: wins, podiums, poles, DNFs, average finish, etc.
        // 4. Return a stats object
        throw new UnsupportedOperationException("TODO: Implement getDriverStats");
    }

    /**
     * Compare two drivers head-to-head.
     * 
     * TODO: Implement this method
     * - Find races where both drivers competed
     * - Calculate who finished ahead more often
     * - Compare stats
     */
    public Object compareDrivers(String driverId1, String driverId2) {
        // TODO: Implement head-to-head comparison
        throw new UnsupportedOperationException("TODO: Implement compareDrivers");
    }

    /**
     * Get driver's recent form (last N races).
     * 
     * TODO: Implement this method
     */
    public Object getDriverForm(String driverId, int lastNRaces) {
        // TODO: Get last N race results and calculate form metrics
        throw new UnsupportedOperationException("TODO: Implement getDriverForm");
    }
}

