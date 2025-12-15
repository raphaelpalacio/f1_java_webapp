package com.f1analysis.views;

import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

/**
 * Main dashboard view - the home page of the app.
 */
@Route(value = "", layout = MainLayout.class)
@PageTitle("Dashboard | F1 Predictions")
public class DashboardView extends VerticalLayout {

    public DashboardView() {
        addClassName("dashboard-view");
        setSpacing(true);
        setPadding(true);

        add(
            new H1("🏎️ F1 Prediction Engine"),
            new Paragraph("Welcome to the F1 Data Analysis and Prediction Platform!"),
            new H2("Quick Stats"),
            createStatsSection(),
            new H2("Getting Started"),
            new Paragraph("✅ Spring Boot is running!"),
            new Paragraph("✅ Vaadin UI is working!"),
            new Paragraph("⏳ Next: Connect to Supabase and add some drivers.")
        );
    }

    private VerticalLayout createStatsSection() {
        VerticalLayout stats = new VerticalLayout();
        stats.setSpacing(false);
        stats.setPadding(false);
        
        // These will be dynamic once we connect the database
        stats.add(new Span("Drivers in database: Coming soon..."));
        stats.add(new Span("Races tracked: Coming soon..."));
        stats.add(new Span("Predictions made: Coming soon..."));
        
        return stats;
    }
}

