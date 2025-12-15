package com.f1analysis.views;

import com.f1analysis.models.Circuit;
import com.f1analysis.repository.CircuitRepository;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

/**
 * View for browsing F1 circuits.
 */
@Route(value = "circuits", layout = MainLayout.class)
@PageTitle("Circuits | F1 Predictions")
public class CircuitsView extends VerticalLayout {

    private final CircuitRepository circuitRepository;
    private final Grid<Circuit> grid = new Grid<>(Circuit.class, false);

    public CircuitsView(CircuitRepository circuitRepository) {
        this.circuitRepository = circuitRepository;

        addClassName("circuits-view");
        setSpacing(true);
        setPadding(true);

        add(
            new H2("🏁 F1 Circuits"),
            new Paragraph("Browse all Formula 1 circuits")
        );

        setupFilter();
        setupGrid();
        refreshGrid();
    }

    private void setupFilter() {
        TextField searchField = new TextField();
        searchField.setPlaceholder("Search circuits...");
        searchField.setWidthFull();
        searchField.setMaxWidth("400px");
        searchField.setValueChangeMode(ValueChangeMode.LAZY);
        searchField.addValueChangeListener(e -> filterGrid(e.getValue()));
        
        add(searchField);
    }

    private void setupGrid() {
        grid.addColumn(Circuit::getName).setHeader("Circuit").setSortable(true);
        grid.addColumn(Circuit::getLocation).setHeader("Location").setSortable(true);
        grid.addColumn(Circuit::getCountry).setHeader("Country").setSortable(true);
        grid.addColumn(circuit -> circuit.getLapLength() != null ? 
            circuit.getLapLength() + "m" : "-").setHeader("Length");
        
        grid.setWidthFull();
        grid.setHeight("500px");
        
        // TODO: Add click listener to show circuit details
        // grid.addItemClickListener(e -> showCircuitDetails(e.getItem()));
        
        add(grid);
    }

    private void refreshGrid() {
        grid.setItems(circuitRepository.findAll());
    }

    private void filterGrid(String searchTerm) {
        // TODO: Implement filtering
        // For now, just refresh all
        if (searchTerm == null || searchTerm.isEmpty()) {
            refreshGrid();
        } else {
            // TODO: Add search method to repository
            // grid.setItems(circuitRepository.findByNameContainingIgnoreCase(searchTerm));
            refreshGrid();
        }
    }
}

