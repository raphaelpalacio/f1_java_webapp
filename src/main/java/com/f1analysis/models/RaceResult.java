package com.f1analysis.models;

import jakarta.persistence.*;

/**
 * Represents the result of a driver in a specific race.
 */
@Entity
@Table(name = "race_results")
public class RaceResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "race_id", nullable = false)
    private Race race;

    @ManyToOne
    @JoinColumn(name = "driver_id", nullable = false)
    private Driver driver;

    @ManyToOne
    @JoinColumn(name = "constructor_id")
    private Constructor constructor;

    private Integer gridPosition;  // Starting position

    private Integer finishPosition;  // Final position (null if DNF)

    private Integer points;

    private Integer lapsCompleted;

    private String status;  // "Finished", "Retired", "Collision", etc.

    private String fastestLapTime;

    private Integer fastestLapRank;

    // TODO: Add getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Race getRace() {
        return race;
    }

    public void setRace(Race race) {
        this.race = race;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public Constructor getConstructor() {
        return constructor;
    }

    public void setConstructor(Constructor constructor) {
        this.constructor = constructor;
    }

    public Integer getGridPosition() {
        return gridPosition;
    }

    public void setGridPosition(Integer gridPosition) {
        this.gridPosition = gridPosition;
    }

    public Integer getFinishPosition() {
        return finishPosition;
    }

    public void setFinishPosition(Integer finishPosition) {
        this.finishPosition = finishPosition;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    public Integer getLapsCompleted() {
        return lapsCompleted;
    }

    public void setLapsCompleted(Integer lapsCompleted) {
        this.lapsCompleted = lapsCompleted;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getFastestLapTime() {
        return fastestLapTime;
    }

    public void setFastestLapTime(String fastestLapTime) {
        this.fastestLapTime = fastestLapTime;
    }

    public Integer getFastestLapRank() {
        return fastestLapRank;
    }

    public void setFastestLapRank(Integer fastestLapRank) {
        this.fastestLapRank = fastestLapRank;
    }
}

