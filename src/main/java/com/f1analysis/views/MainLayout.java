package com.f1analysis.views;

import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.RouterLink;

/**
 * Main layout with navigation drawer for the app.
 */
public class MainLayout extends AppLayout {

    public MainLayout() {
        createHeader();
        createDrawer();
    }

    private void createHeader() {
        H1 logo = new H1("🏎️ F1 Predictions");
        logo.getStyle()
            .set("font-size", "var(--lumo-font-size-l)")
            .set("margin", "0");

        HorizontalLayout header = new HorizontalLayout(new DrawerToggle(), logo);
        header.setDefaultVerticalComponentAlignment(FlexComponent.Alignment.CENTER);
        header.setWidthFull();
        header.addClassNames("py-0", "px-m");

        addToNavbar(header);
    }

    private void createDrawer() {
        VerticalLayout drawerContent = new VerticalLayout();
        
        // Main navigation
        drawerContent.add(
            new RouterLink("Dashboard", DashboardView.class),
            new RouterLink("Drivers", DriversView.class),
            new RouterLink("Circuits", CircuitsView.class),
            new RouterLink("Predictions", PredictionsView.class),
            new RouterLink("Leaderboard", LeaderboardView.class),
            new RouterLink("Ask the Paddock", ChatView.class)
        );
        
        // User section
        drawerContent.add(new com.vaadin.flow.component.html.Hr());
        drawerContent.add(
            new RouterLink("Profile", ProfileView.class),
            new RouterLink("Login", LoginView.class),
            new RouterLink("Register", RegisterView.class)
        );
        
        addToDrawer(drawerContent);
    }
}

