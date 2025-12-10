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
│   F1 Data API   │────▶│   Java Backend   │────▶│   PostgreSQL    │
│   (Ergast API)  │     │   (Data Prep)    │     │   Database      │
└─────────────────┘     └──────────────────┘     └─────────────────┘
                                │                        │
                                ▼                        ▼
                        ┌──────────────────┐     ┌─────────────────┐
                        │  Python/Colab    │     │    Tableau      │
                        │  (ML Models)     │     │  (Dashboards)   │
                        └──────────────────┘     └─────────────────┘
```

## 🛠️ Tech Stack

| Component | Technology |
|-----------|------------|
| **Core Language** | Java 17+ |
| **Build Tool** | Maven / Gradle |
| **Database** | PostgreSQL |
| **ORM** | JDBC / Hibernate |
| **ML Integration** | Python (via Jython or REST API) |
| **Visualization** | Tableau / JavaFX charts |
| **Data Source** | [Ergast F1 API](http://ergast.com/mrd/) |

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

### Visualization
- [ ] Tableau dashboards for season analysis
- [ ] JavaFX charts for in-app visualization
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
│   │   │       ├── repository/   # Database access layer
│   │   │       ├── service/      # Business logic & analysis
│   │   │       ├── ml/           # ML model integration
│   │   │       └── App.java      # Main entry point
│   │   └── resources/
│   │       ├── db/               # SQL scripts
│   │       └── config/           # Configuration files
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
mvn exec:java -Dexec.mainClass="com.f1analysis.App"
```

### Configuration

Create `src/main/resources/config/application.properties`:

```properties
db.url=jdbc:postgresql://localhost:5432/f1_data
db.username=your_username
db.password=your_password
ergast.api.base=http://ergast.com/api/f1
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

- **Phase 1**: Data pipeline setup (API → Java → PostgreSQL)
- **Phase 2**: Basic analysis queries and statistics
- **Phase 3**: Tableau dashboard integration
- **Phase 4**: ML model development and integration
- **Phase 5**: Web interface (Spring Boot) or desktop app (JavaFX)

## 📝 Notes

This is a learning project to get back into Java development. The focus is on:
- Writing clean, well-structured Java code
- Working with databases and SQL
- Understanding data pipelines
- Having fun with F1 data 🏁

---

*Built with ☕ and a love for Formula 1*
