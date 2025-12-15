package com.f1analysis.models;

import jakarta.persistence.*;
import java.time.LocalDate;

/**
 * Represents an F1 driver.
 * 
 * TODO: Add any additional fields you want to track
 * TODO: Consider adding @Index annotations for frequently queried fields
 */
@Entity
@Table(name = "drivers")
public class Driver {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String driverId;  // Ergast API driver ID (e.g., "max_verstappen")

    @Column(nullable = false)
    private String name;

    private String nationality;

    private LocalDate dateOfBirth;

    private String team;  // Current team

    private Integer carNumber;

    private String imageUrl;

    // Stats - these could be calculated or stored
    private Integer wins = 0;
    private Integer podiums = 0;
    private Integer poles = 0;
    private Integer championships = 0;

    // TODO: Implement getters and setters
    // Tip: Use Lombok @Data annotation to auto-generate, or write them manually

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDriverId() {
        return driverId;
    }

    public void setDriverId(String driverId) {
        this.driverId = driverId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public Integer getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(Integer carNumber) {
        this.carNumber = carNumber;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Integer getWins() {
        return wins;
    }

    public void setWins(Integer wins) {
        this.wins = wins;
    }

    public Integer getPodiums() {
        return podiums;
    }

    public void setPodiums(Integer podiums) {
        this.podiums = podiums;
    }

    public Integer getPoles() {
        return poles;
    }

    public void setPoles(Integer poles) {
        this.poles = poles;
    }

    public Integer getChampionships() {
        return championships;
    }

    public void setChampionships(Integer championships) {
        this.championships = championships;
    }
}

