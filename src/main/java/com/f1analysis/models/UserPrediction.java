package com.f1analysis.models;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Represents a user's prediction for a race.
 */
@Entity
@Table(name = "user_predictions")
public class UserPrediction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "race_id", nullable = false)
    private Race race;

    private String predictedWinner;

    // Store podium as comma-separated string or use @ElementCollection
    private String predictedPodium;  // e.g., "verstappen,hamilton,norris"

    private String predictedFastestLap;

    private Integer confidence;  // 0-100

    private Integer pointsEarned;  // Calculated after race

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    // TODO: Add getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Race getRace() {
        return race;
    }

    public void setRace(Race race) {
        this.race = race;
    }

    public String getPredictedWinner() {
        return predictedWinner;
    }

    public void setPredictedWinner(String predictedWinner) {
        this.predictedWinner = predictedWinner;
    }

    public String getPredictedPodium() {
        return predictedPodium;
    }

    public void setPredictedPodium(String predictedPodium) {
        this.predictedPodium = predictedPodium;
    }

    // TODO: Add helper method to convert podium string to List<String>
    public List<String> getPodiumAsList() {
        // TODO: Implement - split predictedPodium by comma
        return null;
    }

    public String getPredictedFastestLap() {
        return predictedFastestLap;
    }

    public void setPredictedFastestLap(String predictedFastestLap) {
        this.predictedFastestLap = predictedFastestLap;
    }

    public Integer getConfidence() {
        return confidence;
    }

    public void setConfidence(Integer confidence) {
        this.confidence = confidence;
    }

    public Integer getPointsEarned() {
        return pointsEarned;
    }

    public void setPointsEarned(Integer pointsEarned) {
        this.pointsEarned = pointsEarned;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}

