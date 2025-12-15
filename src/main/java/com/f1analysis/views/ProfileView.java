package com.f1analysis.views;

import com.f1analysis.service.PredictionService;
import com.f1analysis.service.UserService;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

/**
 * User profile view.
 * 
 * TODO: Protect this route - require authentication
 */
@Route(value = "profile", layout = MainLayout.class)
@PageTitle("Profile | F1 Predictions")
public class ProfileView extends VerticalLayout {

    private final UserService userService;
    private final PredictionService predictionService;

    private final TextField displayNameField = new TextField("Display Name");
    private final TextField avatarUrlField = new TextField("Avatar URL");

    public ProfileView(UserService userService, PredictionService predictionService) {
        this.userService = userService;
        this.predictionService = predictionService;

        addClassName("profile-view");
        setSpacing(true);
        setPadding(true);

        add(
            new H2("👤 Your Profile"),
            new Paragraph("Manage your account and view your stats")
        );

        setupProfileForm();
        setupStats();
    }

    private void setupProfileForm() {
        // TODO: Load current user data
        displayNameField.setWidthFull();
        displayNameField.setMaxWidth("400px");
        displayNameField.setPlaceholder("Your display name");

        avatarUrlField.setWidthFull();
        avatarUrlField.setMaxWidth("400px");
        avatarUrlField.setPlaceholder("https://example.com/avatar.jpg");

        Button saveButton = new Button("Save Changes", e -> handleSave());

        VerticalLayout formLayout = new VerticalLayout(
            displayNameField,
            avatarUrlField,
            saveButton
        );
        formLayout.setPadding(false);
        formLayout.setSpacing(true);

        add(formLayout);
    }

    private void setupStats() {
        add(new H2("📊 Your Stats"));
        
        // TODO: Get actual stats from predictionService
        // PredictionStats stats = predictionService.getUserPredictionStats(currentUser);
        
        VerticalLayout stats = new VerticalLayout();
        stats.add(new Paragraph("Total Predictions: --"));
        stats.add(new Paragraph("Correct Winners: --"));
        stats.add(new Paragraph("Accuracy: --%"));
        stats.add(new Paragraph("Total Points: --"));
        stats.add(new Paragraph("Leaderboard Rank: #--"));
        stats.setPadding(false);
        
        add(stats);
        add(new Paragraph("Stats will populate once you start making predictions!"));
    }

    /**
     * Handle profile save.
     * 
     * TODO: Implement actual profile update
     */
    private void handleSave() {
        // TODO: Get current user ID from session
        // TODO: Call userService.updateProfile()
        
        Notification.show("Profile update not yet implemented. See UserService.updateProfile()", 
            3000, Notification.Position.BOTTOM_CENTER);
    }
}

