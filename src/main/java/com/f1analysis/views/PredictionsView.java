package com.f1analysis.views;

import com.f1analysis.service.PredictionService;
import com.f1analysis.service.RaceService;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.IntegerField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

/**
 * View for making race predictions.
 * 
 * TODO: Add authentication check - only logged-in users can predict
 */
@Route(value = "predictions", layout = MainLayout.class)
@PageTitle("Predictions | F1 Predictions")
public class PredictionsView extends VerticalLayout {

    private final RaceService raceService;
    private final PredictionService predictionService;

    // Form fields
    private final ComboBox<String> raceSelect = new ComboBox<>("Select Race");
    private final TextField winnerField = new TextField("Predicted Winner");
    private final TextField podiumField = new TextField("Predicted Podium (comma-separated)");
    private final TextField fastestLapField = new TextField("Fastest Lap");
    private final IntegerField confidenceField = new IntegerField("Confidence (0-100)");

    public PredictionsView(RaceService raceService, PredictionService predictionService) {
        this.raceService = raceService;
        this.predictionService = predictionService;

        addClassName("predictions-view");
        setSpacing(true);
        setPadding(true);

        add(
            new H2("🎯 Make Your Prediction"),
            new Paragraph("Predict the race results before the weekend begins!")
        );

        setupForm();
        setupPredictionHistory();
    }

    private void setupForm() {
        // TODO: Populate with actual upcoming races from database
        raceSelect.setItems("Monaco GP", "Canadian GP", "British GP"); // Placeholder
        raceSelect.setWidthFull();
        raceSelect.setMaxWidth("400px");

        winnerField.setPlaceholder("e.g., Max Verstappen");
        winnerField.setWidthFull();
        winnerField.setMaxWidth("400px");

        podiumField.setPlaceholder("e.g., Verstappen, Norris, Hamilton");
        podiumField.setWidthFull();
        podiumField.setMaxWidth("400px");

        fastestLapField.setPlaceholder("e.g., Lando Norris");
        fastestLapField.setWidthFull();
        fastestLapField.setMaxWidth("400px");

        confidenceField.setMin(0);
        confidenceField.setMax(100);
        confidenceField.setValue(50);
        confidenceField.setStepButtonsVisible(true);
        confidenceField.setWidthFull();
        confidenceField.setMaxWidth("400px");

        Button submitButton = new Button("Submit Prediction", e -> handleSubmit());

        VerticalLayout formLayout = new VerticalLayout(
            raceSelect,
            winnerField,
            podiumField,
            fastestLapField,
            confidenceField,
            submitButton
        );
        formLayout.setSpacing(true);
        formLayout.setPadding(false);

        add(formLayout);
    }

    private void setupPredictionHistory() {
        add(new H2("📊 Your Past Predictions"));
        
        // TODO: Add Grid showing user's past predictions
        // Grid<UserPrediction> grid = new Grid<>(UserPrediction.class, false);
        // grid.addColumn(p -> p.getRace().getName()).setHeader("Race");
        // grid.addColumn(UserPrediction::getPredictedWinner).setHeader("Your Pick");
        // grid.addColumn(p -> p.getPointsEarned() != null ? p.getPointsEarned() + " pts" : "Pending")
        //     .setHeader("Result");
        // grid.setItems(predictionService.getUserPredictions(currentUser));
        // add(grid);
        
        add(new Paragraph("Prediction history will appear here once authentication is implemented."));
    }

    /**
     * Handle prediction submission.
     * 
     * TODO: Implement actual prediction creation
     */
    private void handleSubmit() {
        // Validate
        if (raceSelect.getValue() == null || winnerField.getValue().isEmpty()) {
            Notification.show("Please select a race and predict a winner", 
                3000, Notification.Position.BOTTOM_CENTER);
            return;
        }

        // TODO: Get current user from session
        // TODO: Get actual Race entity from raceService
        // TODO: Call predictionService.createPrediction()

        Notification.show("Prediction submitted! (Demo - needs full implementation)", 
            3000, Notification.Position.BOTTOM_CENTER);
        
        // Clear form
        winnerField.clear();
        podiumField.clear();
        fastestLapField.clear();
        confidenceField.setValue(50);
    }
}

