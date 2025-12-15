package com.f1analysis.views;

import com.f1analysis.models.Driver;
import com.f1analysis.service.DriverService;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.IntegerField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

/**
 * View for browsing and managing F1 drivers.
 */
@Route(value = "drivers", layout = MainLayout.class)
@PageTitle("Drivers | F1 Predictions")
public class DriversView extends VerticalLayout {

    private final DriverService driverService;
    private final Grid<Driver> grid = new Grid<>(Driver.class, false);

    public DriversView(DriverService driverService) {
        this.driverService = driverService;

        addClassName("drivers-view");
        setSpacing(true);
        setPadding(true);

        add(
            new H2("🏁 F1 Drivers"),
            new Paragraph("Browse and manage F1 driver data")
        );

        setupToolbar();
        setupGrid();
        refreshGrid();
    }

    private void setupToolbar() {
        TextField searchField = new TextField();
        searchField.setPlaceholder("Search drivers...");
        searchField.setValueChangeMode(ValueChangeMode.LAZY);
        searchField.addValueChangeListener(e -> filterGrid(e.getValue()));

        Button addButton = new Button("Add Driver", e -> openDriverDialog(null));

        HorizontalLayout toolbar = new HorizontalLayout(searchField, addButton);
        toolbar.setWidthFull();
        toolbar.setFlexGrow(1, searchField);
        
        add(toolbar);
    }

    private void setupGrid() {
        grid.addColumn(Driver::getName).setHeader("Name").setSortable(true);
        grid.addColumn(Driver::getTeam).setHeader("Team").setSortable(true);
        grid.addColumn(Driver::getNationality).setHeader("Nationality").setSortable(true);
        grid.addColumn(Driver::getCarNumber).setHeader("#");
        grid.addColumn(Driver::getWins).setHeader("Wins").setSortable(true);
        grid.addColumn(Driver::getPodiums).setHeader("Podiums").setSortable(true);
        
        // Edit/Delete buttons column
        grid.addComponentColumn(driver -> {
            Button editBtn = new Button("Edit", e -> openDriverDialog(driver));
            Button deleteBtn = new Button("Delete", e -> deleteDriver(driver));
            deleteBtn.getStyle().set("color", "red");
            return new HorizontalLayout(editBtn, deleteBtn);
        }).setHeader("Actions");

        grid.setWidthFull();
        grid.setHeight("500px");
        
        add(grid);
    }

    private void refreshGrid() {
        grid.setItems(driverService.getAllDrivers());
    }

    private void filterGrid(String searchTerm) {
        if (searchTerm == null || searchTerm.isEmpty()) {
            refreshGrid();
        } else {
            grid.setItems(driverService.searchDrivers(searchTerm));
        }
    }

    /**
     * Open dialog to add/edit a driver.
     * 
     * TODO: This is a basic CRUD form - you can enhance it!
     */
    private void openDriverDialog(Driver existing) {
        Dialog dialog = new Dialog();
        dialog.setHeaderTitle(existing == null ? "Add Driver" : "Edit Driver");

        // Form fields
        TextField driverIdField = new TextField("Driver ID");
        TextField nameField = new TextField("Name");
        TextField teamField = new TextField("Team");
        TextField nationalityField = new TextField("Nationality");
        IntegerField carNumberField = new IntegerField("Car Number");
        IntegerField winsField = new IntegerField("Wins");
        IntegerField podiumsField = new IntegerField("Podiums");

        // Pre-fill if editing
        if (existing != null) {
            driverIdField.setValue(existing.getDriverId() != null ? existing.getDriverId() : "");
            nameField.setValue(existing.getName() != null ? existing.getName() : "");
            teamField.setValue(existing.getTeam() != null ? existing.getTeam() : "");
            nationalityField.setValue(existing.getNationality() != null ? existing.getNationality() : "");
            carNumberField.setValue(existing.getCarNumber() != null ? existing.getCarNumber() : 0);
            winsField.setValue(existing.getWins() != null ? existing.getWins() : 0);
            podiumsField.setValue(existing.getPodiums() != null ? existing.getPodiums() : 0);
        }

        VerticalLayout formLayout = new VerticalLayout(
            driverIdField, nameField, teamField, nationalityField,
            carNumberField, winsField, podiumsField
        );
        dialog.add(formLayout);

        // Buttons
        Button saveBtn = new Button("Save", e -> {
            Driver driver = existing != null ? existing : new Driver();
            driver.setDriverId(driverIdField.getValue());
            driver.setName(nameField.getValue());
            driver.setTeam(teamField.getValue());
            driver.setNationality(nationalityField.getValue());
            driver.setCarNumber(carNumberField.getValue());
            driver.setWins(winsField.getValue());
            driver.setPodiums(podiumsField.getValue());

            driverService.saveDriver(driver);
            Notification.show("Driver saved!", 2000, Notification.Position.BOTTOM_CENTER);
            dialog.close();
            refreshGrid();
        });

        Button cancelBtn = new Button("Cancel", e -> dialog.close());

        dialog.getFooter().add(cancelBtn, saveBtn);
        dialog.open();
    }

    private void deleteDriver(Driver driver) {
        driverService.deleteDriver(driver.getId());
        Notification.show("Driver deleted", 2000, Notification.Position.BOTTOM_CENTER);
        refreshGrid();
    }
}
