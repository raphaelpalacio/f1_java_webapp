package com.f1analysis.views;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

/**
 * Drivers view - will show driver data once we add the Driver entity.
 */
@Route(value = "drivers", layout = MainLayout.class)
@PageTitle("Drivers | F1 Predictions")
public class DriversView extends VerticalLayout {

    public DriversView() {
        addClassName("drivers-view");
        setSpacing(true);
        setPadding(true);

        add(
            new H2("🏁 F1 Drivers"),
            new Paragraph("Driver data will appear here once we add the Driver entity and connect to Supabase."),
            createTestButton()
        );
        
        // TODO: Add driver grid once Driver entity exists
        // Grid<Driver> grid = new Grid<>(Driver.class);
        // grid.setColumns("name", "team", "wins", "podiums");
        // add(grid);
    }

    private Button createTestButton() {
        Button testBtn = new Button("Test Notification", e -> {
            Notification.show("Vaadin is working! 🎉", 3000, Notification.Position.BOTTOM_CENTER);
        });
        return testBtn;
    }
}

