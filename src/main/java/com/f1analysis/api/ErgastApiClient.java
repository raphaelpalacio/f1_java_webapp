package com.f1analysis.api;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * Client for the Ergast F1 API.
 * 
 * API Documentation: http://ergast.com/mrd/
 * 
 * Example endpoints:
 * - Drivers: http://ergast.com/api/f1/2024/drivers.json
 * - Races: http://ergast.com/api/f1/2024.json
 * - Results: http://ergast.com/api/f1/2024/1/results.json
 */
@Component
public class ErgastApiClient {

    @Value("${ergast.api.base:http://ergast.com/api/f1}")
    private String baseUrl;

    private final RestTemplate restTemplate;

    public ErgastApiClient() {
        this.restTemplate = new RestTemplate();
    }

    // ==================== Drivers ====================

    /**
     * Get all drivers for a season.
     * 
     * TODO: Implement this method
     * - Call: {baseUrl}/{season}/drivers.json
     * - Parse JSON response
     * - Return list of driver data
     * 
     * API response structure:
     * {
     *   "MRData": {
     *     "DriverTable": {
     *       "Drivers": [
     *         { "driverId": "max_verstappen", "givenName": "Max", ... }
     *       ]
     *     }
     *   }
     * }
     */
    public String getDrivers(Integer season) {
        // TODO: Implement API call
        // String url = baseUrl + "/" + season + "/drivers.json";
        // String response = restTemplate.getForObject(url, String.class);
        // return response;
        throw new UnsupportedOperationException("TODO: Implement getDrivers");
    }

    /**
     * Get current driver standings.
     * 
     * TODO: Implement this method
     * - Call: {baseUrl}/{season}/driverStandings.json
     */
    public String getDriverStandings(Integer season) {
        // TODO: Implement API call
        throw new UnsupportedOperationException("TODO: Implement getDriverStandings");
    }

    // ==================== Constructors ====================

    /**
     * Get all constructors for a season.
     * 
     * TODO: Implement this method
     * - Call: {baseUrl}/{season}/constructors.json
     */
    public String getConstructors(Integer season) {
        // TODO: Implement API call
        throw new UnsupportedOperationException("TODO: Implement getConstructors");
    }

    /**
     * Get constructor standings.
     * 
     * TODO: Implement this method
     */
    public String getConstructorStandings(Integer season) {
        // TODO: Implement API call
        throw new UnsupportedOperationException("TODO: Implement getConstructorStandings");
    }

    // ==================== Races ====================

    /**
     * Get race schedule for a season.
     * 
     * TODO: Implement this method
     * - Call: {baseUrl}/{season}.json
     */
    public String getRaceSchedule(Integer season) {
        // TODO: Implement API call
        throw new UnsupportedOperationException("TODO: Implement getRaceSchedule");
    }

    /**
     * Get results for a specific race.
     * 
     * TODO: Implement this method
     * - Call: {baseUrl}/{season}/{round}/results.json
     */
    public String getRaceResults(Integer season, Integer round) {
        // TODO: Implement API call
        throw new UnsupportedOperationException("TODO: Implement getRaceResults");
    }

    /**
     * Get qualifying results for a race.
     * 
     * TODO: Implement this method
     * - Call: {baseUrl}/{season}/{round}/qualifying.json
     */
    public String getQualifyingResults(Integer season, Integer round) {
        // TODO: Implement API call
        throw new UnsupportedOperationException("TODO: Implement getQualifyingResults");
    }

    // ==================== Circuits ====================

    /**
     * Get all circuits.
     * 
     * TODO: Implement this method
     * - Call: {baseUrl}/circuits.json
     */
    public String getCircuits() {
        // TODO: Implement API call
        throw new UnsupportedOperationException("TODO: Implement getCircuits");
    }

    // ==================== Lap Times ====================

    /**
     * Get lap times for a race.
     * 
     * TODO: Implement this method (optional - lots of data!)
     * - Call: {baseUrl}/{season}/{round}/laps.json
     */
    public String getLapTimes(Integer season, Integer round) {
        // TODO: Implement API call
        throw new UnsupportedOperationException("TODO: Implement getLapTimes");
    }

    // ==================== Helper Methods ====================

    /**
     * Generic GET request to Ergast API.
     * 
     * TODO: Implement this helper
     */
    private String makeRequest(String endpoint) {
        // TODO: Implement generic request with error handling
        // String url = baseUrl + endpoint;
        // try {
        //     return restTemplate.getForObject(url, String.class);
        // } catch (Exception e) {
        //     // Handle errors
        //     throw new RuntimeException("API request failed: " + e.getMessage());
        // }
        throw new UnsupportedOperationException("TODO: Implement makeRequest");
    }
}

