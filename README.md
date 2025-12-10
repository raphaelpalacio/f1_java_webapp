# 🏎️ F1 Data Analysis & Prediction Engine

A Java-based application for analyzing Formula 1 data and predicting race outcomes, driver performance, and championship results.

## 🎯 Project Goals

- **Refresh Java skills** through a real-world data engineering project
- **Analyze historical F1 data** to uncover patterns and insights
- **Build predictive models** for race outcomes and driver/constructor standings
- **Create a data pipeline** from raw F1 data to actionable predictions

## 🏗️ Architecture Overview

```
┌─────────────────┐     ┌──────────────────┐     ┌─────────────────┐
│   F1 Data API   │────▶│  Spring Boot +   │────▶│   PostgreSQL    │
│   (Ergast API)  │     │     Vaadin       │     │   Database      │
└─────────────────┘     └──────────────────┘     └─────────────────┘
                                │
                ┌───────────────┼───────────────┐
                ▼               ▼               ▼
        ┌──────────────┐ ┌────────────┐ ┌─────────────┐
        │   Vaadin UI  │ │  Python    │ │   Tableau   │
        │  (Web App)   │ │ (ML/Colab) │ │ (Reports)   │
        └──────────────┘ └────────────┘ └─────────────┘
```

## 🛠️ Tech Stack

| Component | Technology |
|-----------|------------|
| **Core Language** | Java 17+ |
| **Framework** | Spring Boot 3.x |
| **Frontend** | Vaadin 24 (100% Java UI) |
| **Build Tool** | Maven |
| **Database** | PostgreSQL |
| **ORM** | Spring Data JPA / Hibernate |
| **ML Integration** | Python (via REST API or Colab) |
| **Visualization** | Vaadin Charts + Tableau |
| **Data Source** | [Ergast F1 API](http://ergast.com/mrd/) |

### Why Vaadin?

Vaadin lets you build modern web UIs **entirely in Java** - no HTML, CSS, or JavaScript required. Perfect for staying in Java-land while still getting a slick browser-based app.

## 📊 Features

### Data Collection & Storage
- [ ] Fetch historical F1 data from Ergast API
- [ ] Parse JSON/XML responses into Java objects
- [ ] Design and implement PostgreSQL schema
- [ ] Batch import historical data (1950-present)

### Data Analysis (Java)
- [ ] Driver performance metrics (wins, podiums, DNFs)
- [ ] Constructor standings trends
- [ ] Circuit-specific statistics
- [ ] Head-to-head driver comparisons
- [ ] Qualifying vs race pace analysis

### Predictive Models
- [ ] Race winner prediction based on qualifying
- [ ] Championship points projection
- [ ] Weather impact analysis on race outcomes
- [ ] Pit stop strategy optimization
- [ ] Driver form momentum tracking

### Web UI (Vaadin)
- [ ] Dashboard with season standings and upcoming races
- [ ] Driver profiles with career stats and charts
- [ ] Race prediction interface with confidence scores
- [ ] Head-to-head comparison tool
- [ ] Circuit analysis with historical data
- [ ] Interactive data grids with filtering/sorting

### Visualization
- [ ] Vaadin Charts for in-app graphs (points progression, win rates)
- [ ] Tableau dashboards for deep-dive season analysis
- [ ] Export data for external analysis tools

## 📁 Project Structure

```
f1_java_webapp/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/f1analysis/
│   │   │       ├── api/          # API clients for data fetching
│   │   │       ├── models/       # Domain objects (Driver, Race, etc.)
│   │   │       ├── repository/   # Database access layer (Spring Data JPA)
│   │   │       ├── service/      # Business logic & analysis
│   │   │       ├── ml/           # ML model integration
│   │   │       ├── views/        # Vaadin UI views
│   │   │       │   ├── MainLayout.java
│   │   │       │   ├── DashboardView.java
│   │   │       │   ├── DriversView.java
│   │   │       │   ├── PredictionsView.java
│   │   │       │   └── CircuitsView.java
│   │   │       └── Application.java  # Spring Boot entry point
│   │   └── resources/
│   │       ├── db/               # SQL scripts
│   │       └── application.properties
│   └── test/
├── python/                       # Python ML scripts (Colab compatible)
├── tableau/                      # Tableau workbooks
├── pom.xml
└── README.md
```

## 🗄️ Database Schema

Key tables for F1 data:

- `drivers` - Driver info (name, nationality, DOB)
- `constructors` - Team information
- `circuits` - Track details and locations
- `races` - Race events by season
- `results` - Race results with positions, times, points
- `qualifying` - Qualifying session results
- `lap_times` - Individual lap data
- `pit_stops` - Pit stop timing data

## 🚀 Getting Started

### Prerequisites
- Java 17 or higher
- PostgreSQL 14+
- Maven 3.8+
- (Optional) Python 3.9+ for ML components

### Setup

```bash
# Clone the repo
git clone https://github.com/yourusername/f1_java_webapp.git
cd f1_java_webapp

# Create PostgreSQL database
createdb f1_data

# Build the project
mvn clean install

# Run the application
mvn spring-boot:run
```

The app will be available at `http://localhost:8080`

### Configuration

Edit `src/main/resources/application.properties`:

```properties
# Database
spring.datasource.url=jdbc:postgresql://localhost:5432/f1_data
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update

# Ergast API
ergast.api.base=http://ergast.com/api/f1

# Vaadin
vaadin.launch-browser=true
```

## 📈 Sample Analyses

### Predict Race Winner
```java
PredictionService predictor = new PredictionService();
RacePrediction prediction = predictor.predictWinner("2024", "monaco");
System.out.println("Predicted winner: " + prediction.getDriver());
System.out.println("Confidence: " + prediction.getConfidence() + "%");
```

### Driver Performance Stats
```java
DriverService driverService = new DriverService();
DriverStats stats = driverService.getCareerStats("max_verstappen");
System.out.println("Wins: " + stats.getWins());
System.out.println("Podiums: " + stats.getPodiums());
System.out.println("Win Rate: " + stats.getWinPercentage() + "%");
```

## 🖥️ Vaadin UI Examples

### Driver Grid View
```java
@Route(value = "drivers", layout = MainLayout.class)
public class DriversView extends VerticalLayout {

    public DriversView(DriverService driverService) {
        // Data grid - all in Java, no HTML needed
        Grid<Driver> grid = new Grid<>(Driver.class, false);
        grid.addColumn(Driver::getName).setHeader("Driver");
        grid.addColumn(Driver::getTeam).setHeader("Team");
        grid.addColumn(Driver::getWins).setHeader("Wins");
        grid.addColumn(Driver::getPodiums).setHeader("Podiums");
        grid.setItems(driverService.getAllDrivers());
        
        // Search filter
        TextField search = new TextField("Search drivers");
        search.addValueChangeListener(e -> 
            grid.setItems(driverService.searchDrivers(e.getValue()))
        );
        
        add(new H2("Driver Statistics"), search, grid);
    }
}
```

### Prediction Dashboard
```java
@Route(value = "predictions", layout = MainLayout.class)
public class PredictionsView extends VerticalLayout {

    public PredictionsView(PredictionService predictionService) {
        ComboBox<Race> raceSelect = new ComboBox<>("Select Race");
        raceSelect.setItems(predictionService.getUpcomingRaces());
        
        Div resultsPanel = new Div();
        
        Button predictBtn = new Button("Run Prediction", e -> {
            RacePrediction prediction = predictionService
                .predictWinner(raceSelect.getValue());
            
            resultsPanel.removeAll();
            resultsPanel.add(
                new H3("Predicted Winner: " + prediction.getDriver()),
                new ProgressBar(prediction.getConfidence() / 100.0),
                new Span("Confidence: " + prediction.getConfidence() + "%")
            );
        });
        
        add(new H2("Race Predictions"), raceSelect, predictBtn, resultsPanel);
    }
}
```

## 🔮 ML Model Ideas

1. **Race Position Predictor** - Using qualifying position, historical circuit data, weather
2. **Championship Simulator** - Monte Carlo simulation of remaining races
3. **DNF Probability** - Predict mechanical failures based on team reliability
4. **Overtake Difficulty** - Circuit classification based on historical overtakes

## 📚 Data Sources

- [Ergast Developer API](http://ergast.com/mrd/) - Historical F1 data since 1950
- [FastF1 Python Library](https://github.com/theOehrly/Fast-F1) - Telemetry data
- [Kaggle F1 Datasets](https://www.kaggle.com/datasets/rohanrao/formula-1-world-championship-1950-2020)

## 🗺️ Roadmap

- **Phase 1**: Project setup (Spring Boot + Vaadin + PostgreSQL)
- **Phase 2**: Data pipeline (Ergast API → Java → Database)
- **Phase 3**: Core Vaadin UI (Dashboard, Drivers, Circuits views)
- **Phase 4**: Analysis features and Vaadin Charts integration
- **Phase 5**: ML model development and prediction UI
- **Phase 6**: Polish and Tableau export for external reporting

## 📝 Notes

This is a learning project to get back into Java development. The focus is on:
- Writing clean, well-structured Java code
- Building a full-stack web app without leaving Java (thanks Vaadin!)
- Working with Spring Boot and Spring Data JPA
- Understanding data pipelines and database design
- Having fun with F1 data 🏁

---

*Built with ☕ and a love for Formula 1*
