package com.f1analysis.views;

import com.f1analysis.repository.CircuitRepository;
import com.f1analysis.repository.DriverRepository;
import com.f1analysis.repository.RaceRepository;
import com.f1analysis.repository.UserRepository;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

/**
 * Main dashboard view - the home page of the app.
 */
@Route(value = "", layout = MainLayout.class)
@PageTitle("Dashboard | F1 Predictions")
public class DashboardView extends VerticalLayout {

    private final DriverRepository driverRepository;
    private final RaceRepository raceRepository;
    private final CircuitRepository circuitRepository;
    private final UserRepository userRepository;

    public DashboardView(DriverRepository driverRepository,
                         RaceRepository raceRepository,
                         CircuitRepository circuitRepository,
                         UserRepository userRepository) {
        this.driverRepository = driverRepository;
        this.raceRepository = raceRepository;
        this.circuitRepository = circuitRepository;
        this.userRepository = userRepository;

        addClassName("dashboard-view");
        setSpacing(true);
        setPadding(true);

        add(
            new H1("🏎️ F1 Prediction Engine"),
            new Paragraph("Welcome to the F1 Data Analysis and Prediction Platform!")
        );

        add(createStatsCards());
        add(createStatusSection());
    }

    private HorizontalLayout createStatsCards() {
        HorizontalLayout cards = new HorizontalLayout();
        cards.setWidthFull();
        cards.setSpacing(true);

        cards.add(
            createStatCard("Drivers", String.valueOf(driverRepository.count()), "🏁"),
            createStatCard("Races", String.valueOf(raceRepository.count()), "🏆"),
            createStatCard("Circuits", String.valueOf(circuitRepository.count()), "🗺️"),
            createStatCard("Users", String.valueOf(userRepository.count()), "👥")
        );

        return cards;
    }

    private Div createStatCard(String title, String value, String emoji) {
        Div card = new Div();
        card.getStyle()
            .set("background", "#f5f5f5")
            .set("border-radius", "8px")
            .set("padding", "20px")
            .set("text-align", "center")
            .set("flex", "1");

        Span emojiSpan = new Span(emoji);
        emojiSpan.getStyle().set("font-size", "2em");

        H3 valueH3 = new H3(value);
        valueH3.getStyle().set("margin", "10px 0 5px 0");

        Span titleSpan = new Span(title);
        titleSpan.getStyle().set("color", "#666");

        card.add(emojiSpan, valueH3, titleSpan);
        return card;
    }

    private VerticalLayout createStatusSection() {
        VerticalLayout status = new VerticalLayout();
        status.setSpacing(false);
        status.setPadding(true);
        status.getStyle()
            .set("background", "#e8f5e9")
            .set("border-radius", "8px")
            .set("margin-top", "20px");

        status.add(new H2("✅ System Status"));
        status.add(new Paragraph("Spring Boot is running"));
        status.add(new Paragraph("Vaadin UI is working"));
        status.add(new Paragraph("Database connection: " + getDatabaseStatus()));

        status.add(new H2("📋 Next Steps"));
        status.add(createTodoItem("1. Connect to Supabase (set env variables)", driverRepository.count() > 0));
        status.add(createTodoItem("2. Import F1 data (implement ErgastApiClient)", raceRepository.count() > 0));
        status.add(createTodoItem("3. Add some drivers manually to test CRUD", driverRepository.count() > 0));
        status.add(createTodoItem("4. Enable Spring Security for login", false));
        status.add(createTodoItem("5. Enable Spring AI for chat features", false));

        return status;
    }

    private String getDatabaseStatus() {
        try {
            driverRepository.count();
            return "✅ Connected";
        } catch (Exception e) {
            return "❌ Not connected - check Supabase credentials";
        }
    }

    private Paragraph createTodoItem(String text, boolean completed) {
        Paragraph p = new Paragraph((completed ? "✅ " : "⬜ ") + text);
        if (completed) {
            p.getStyle().set("text-decoration", "line-through").set("color", "#666");
        }
        return p;
    }
}
