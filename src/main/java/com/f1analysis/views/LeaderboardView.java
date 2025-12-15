package com.f1analysis.views;

import com.f1analysis.service.PredictionService;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

/**
 * Leaderboard view showing top predictors.
 */
@Route(value = "leaderboard", layout = MainLayout.class)
@PageTitle("Leaderboard | F1 Predictions")
public class LeaderboardView extends VerticalLayout {

    private final PredictionService predictionService;

    public LeaderboardView(PredictionService predictionService) {
        this.predictionService = predictionService;

        addClassName("leaderboard-view");
        setSpacing(true);
        setPadding(true);

        add(
            new H2("🏆 Prediction Leaderboard"),
            new Paragraph("See who's the best at predicting F1 races!")
        );

        setupLeaderboard();
    }

    private void setupLeaderboard() {
        // TODO: Implement leaderboard grid
        // 1. Call predictionService.getLeaderboard(50)
        // 2. Display in a Grid with columns: Rank, User, Points, Accuracy
        
        // Grid<LeaderboardEntry> grid = new Grid<>();
        // grid.addColumn(LeaderboardEntry::getRank).setHeader("Rank");
        // grid.addColumn(LeaderboardEntry::getDisplayName).setHeader("User");
        // grid.addColumn(LeaderboardEntry::getTotalPoints).setHeader("Points");
        // grid.addColumn(LeaderboardEntry::getAccuracy).setHeader("Accuracy");
        // grid.setItems(predictionService.getLeaderboard(50));
        // add(grid);

        add(new Paragraph("Leaderboard will appear here once PredictionService.getLeaderboard() is implemented."));
        
        // Placeholder leaderboard
        VerticalLayout placeholder = new VerticalLayout();
        placeholder.add(new Paragraph("🥇 1. Coming soon..."));
        placeholder.add(new Paragraph("🥈 2. Coming soon..."));
        placeholder.add(new Paragraph("🥉 3. Coming soon..."));
        add(placeholder);
    }
}

