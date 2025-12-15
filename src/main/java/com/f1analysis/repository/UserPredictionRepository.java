package com.f1analysis.repository;

import com.f1analysis.models.Race;
import com.f1analysis.models.User;
import com.f1analysis.models.UserPrediction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserPredictionRepository extends JpaRepository<UserPrediction, Long> {

    // Get all predictions by a user
    List<UserPrediction> findByUserOrderByCreatedAtDesc(User user);

    // Get user's prediction for a specific race
    Optional<UserPrediction> findByUserAndRace(User user, Race race);

    // Get all predictions for a race (for leaderboard)
    List<UserPrediction> findByRace(Race race);

    // Check if user already predicted for a race
    boolean existsByUserAndRace(User user, Race race);

    // TODO: Add query for leaderboard ranking
    // TODO: Add query to calculate user's total points
}

