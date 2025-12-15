package com.f1analysis.service;

import com.f1analysis.models.Race;
import com.f1analysis.models.User;
import com.f1analysis.models.UserPrediction;
import com.f1analysis.repository.UserPredictionRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

/**
 * Service for user predictions (CRUD + scoring).
 */
@Service
public class PredictionService {

    private final UserPredictionRepository predictionRepository;

    public PredictionService(UserPredictionRepository predictionRepository) {
        this.predictionRepository = predictionRepository;
    }

    // ==================== CRUD Operations ====================

    /**
     * Create a new prediction.
     * 
     * TODO: Validate that:
     * - Race hasn't started yet
     * - User hasn't already predicted for this race
     */
    public UserPrediction createPrediction(User user, Race race, String winner, 
                                           String podium, String fastestLap, Integer confidence) {
        // TODO: Add validation
        // 1. Check race hasn't started
        // 2. Check user hasn't already predicted

        UserPrediction prediction = new UserPrediction();
        prediction.setUser(user);
        prediction.setRace(race);
        prediction.setPredictedWinner(winner);
        prediction.setPredictedPodium(podium);
        prediction.setPredictedFastestLap(fastestLap);
        prediction.setConfidence(confidence);
        prediction.setCreatedAt(LocalDateTime.now());

        return predictionRepository.save(prediction);
    }

    public List<UserPrediction> getUserPredictions(User user) {
        return predictionRepository.findByUserOrderByCreatedAtDesc(user);
    }

    public Optional<UserPrediction> getPredictionById(Long id) {
        return predictionRepository.findById(id);
    }

    public Optional<UserPrediction> getUserPredictionForRace(User user, Race race) {
        return predictionRepository.findByUserAndRace(user, race);
    }

    /**
     * Update an existing prediction.
     * 
     * TODO: Validate that race hasn't started yet
     */
    public UserPrediction updatePrediction(Long predictionId, String winner, 
                                           String podium, String fastestLap, Integer confidence) {
        UserPrediction prediction = predictionRepository.findById(predictionId)
            .orElseThrow(() -> new RuntimeException("Prediction not found"));

        // TODO: Validate race hasn't started

        prediction.setPredictedWinner(winner);
        prediction.setPredictedPodium(podium);
        prediction.setPredictedFastestLap(fastestLap);
        prediction.setConfidence(confidence);
        prediction.setUpdatedAt(LocalDateTime.now());

        return predictionRepository.save(prediction);
    }

    public void deletePrediction(Long id) {
        predictionRepository.deleteById(id);
    }

    // ==================== Scoring ====================

    /**
     * Score predictions after a race completes.
     * 
     * TODO: Implement scoring logic
     * - Compare predictions to actual results
     * - Award points based on accuracy
     * - Update pointsEarned for each prediction
     * 
     * Suggested scoring:
     * - Correct winner: 25 points
     * - Correct podium position: 10 points each
     * - Correct fastest lap: 5 points
     */
    public void scoreRacePredictions(Race race) {
        // TODO: Implement prediction scoring
        // 1. Get actual race results
        // 2. Get all predictions for this race
        // 3. For each prediction, calculate points
        // 4. Update prediction with pointsEarned
        throw new UnsupportedOperationException("TODO: Implement scoreRacePredictions");
    }

    // ==================== Statistics ====================

    /**
     * Get user's prediction statistics.
     * 
     * TODO: Implement this method
     * - Total predictions made
     * - Correct winners
     * - Total points earned
     * - Accuracy percentage
     */
    public Object getUserPredictionStats(User user) {
        // TODO: Implement user prediction stats
        throw new UnsupportedOperationException("TODO: Implement getUserPredictionStats");
    }

    /**
     * Get leaderboard.
     * 
     * TODO: Implement this method
     * - Rank users by total prediction points
     * - Return top N users
     */
    public Object getLeaderboard(int limit) {
        // TODO: Implement leaderboard query
        // Could use native query or aggregate in Java
        throw new UnsupportedOperationException("TODO: Implement getLeaderboard");
    }
}

