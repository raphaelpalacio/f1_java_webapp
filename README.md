# 🏎️ F1 Data Analysis & Prediction Engine

A full-stack Java web application for analyzing Formula 1 data, making AI-powered predictions, and tracking your favorite drivers and teams. Users can create accounts, make their own race predictions, and compete with others.

## 🎯 Project Goals

- **Refresh Java skills** through a real-world full-stack CRUD application
- **Learn Supabase** as a modern backend-as-a-service platform
- **Analyze historical F1 data** to uncover patterns and insights
- **Build AI-powered features** using Spring AI for natural language interaction
- **Create a social prediction platform** where users can make and track predictions
- **Learn authentication & authorization** with Spring Security

## 🏗️ Architecture Overview

```
                                    ┌─────────────────┐
                                    │   OpenAI API    │
                                    │   (GPT-4/Claude)│
                                    └────────▲────────┘
                                             │
┌─────────────────┐     ┌────────────────────┴───────────────────┐     ┌─────────────────┐
│   F1 Data API   │────▶│              Spring Boot               │────▶│    Supabase     │
│   (Ergast API)  │     │  ┌──────────┐ ┌──────────┐ ┌────────┐  │     │   (PostgreSQL)  │
└─────────────────┘     │  │ Spring   │ │ Spring   │ │ Spring │  │     │                 │
                        │  │ Security │ │ AI       │ │ Data   │  │     │  • F1 Data      │
                        │  └──────────┘ └──────────┘ └────────┘  │     │  • Users        │
                        └────────────────────┬───────────────────┘     │  • Predictions  │
                                             │                         │  • Storage      │
                                    ┌────────▼────────┐                └─────────────────┘
                                    │    Vaadin 24    │
                                    │   (Java UI)     │
                                    └─────────────────┘
                                             │
                        ┌────────────────────┼────────────────────┐
                        ▼                    ▼                    ▼
                ┌──────────────┐    ┌──────────────┐    ┌──────────────┐
                │  Dashboard   │    │  AI Chat     │    │  User        │
                │  & Stats     │    │  Interface   │    │  Predictions │
                └──────────────┘    └──────────────┘    └──────────────┘
```

## 🛠️ Tech Stack

| Component | Technology |
|-----------|------------|
| **Core Language** | Java 17+ |
| **Framework** | Spring Boot 3.x |
| **Frontend** | Vaadin 24 (100% Java UI) |
| **Authentication** | Spring Security |
| **AI/LLM** | Spring AI (OpenAI/Anthropic) |
| **Build Tool** | Maven |
| **Database** | [Supabase](https://supabase.com) (Hosted PostgreSQL) |
| **ORM** | Spring Data JPA / Hibernate |
| **Visualization** | Vaadin Charts |
| **Data Source** | [Ergast F1 API](http://ergast.com/mrd/) |

### Why This Stack?

- **Vaadin** - Build modern web UIs entirely in Java, no JS needed
- **Supabase** - Hosted PostgreSQL with a nice dashboard, auth options, and real-time features. No local DB setup needed!
- **Spring Security** - Industry standard for auth, handles login/sessions
- **Spring AI** - Clean integration with LLMs, stays in Spring ecosystem
- **Spring Data JPA** - Makes CRUD operations simple and type-safe

### Why Supabase?

Supabase is PostgreSQL under the hood, so Spring Data JPA works exactly the same. You get:
- **Free hosted database** - No local PostgreSQL setup
- **Dashboard UI** - View and edit data in the browser
- **Built-in Auth** - Optional: use Supabase Auth instead of/alongside Spring Security
- **Storage** - Store user avatars and files
- **Real-time** - Live updates if you want to add live leaderboards later
- **Easy backups** - Automatic backups on paid plans

## 📊 Features

### 👤 User Management (CRUD)
- [ ] User registration with email verification
- [ ] Login/logout with session management
- [ ] User profile with avatar and preferences
- [ ] Password reset functionality
- [ ] Role-based access (User, Premium, Admin)

### 📋 User Predictions & Tracking
- [ ] Make predictions for upcoming races (winner, podium, fastest lap)
- [ ] Track prediction accuracy over time
- [ ] Watchlist for favorite drivers and teams
- [ ] Personal dashboard with prediction history
- [ ] Leaderboard comparing user prediction accuracy
- [ ] Save and organize custom data views

### 🤖 AI Features

#### Race Weekend Predictor
AI-powered predictions for each race weekend:
- [ ] Qualifying order prediction (P1-P20)
- [ ] Race winner and podium prediction with confidence scores
- [ ] Safety car probability based on circuit history
- [ ] Points predictions for championship impact
- [ ] Factor in recent form, circuit history, weather

#### Natural Language Chat ("Ask the Paddock")
Chat interface for asking questions about F1 data:
- [ ] *"How does Verstappen perform in wet conditions?"*
- [ ] *"Compare Leclerc and Sainz head-to-head this season"*
- [ ] *"What's Hamilton's average finishing position at Silverstone?"*
- [ ] Context-aware answers using your Supabase data (RAG)

#### Race Recap Generator
Automated summaries after each race:
- [ ] Generate narrative recap from race results
- [ ] Highlight key moments and overtakes
- [ ] Championship implications analysis
- [ ] *"Norris capitalized on Verstappen's penalty to close the gap to 45 points..."*

#### Strategy Explainer
AI analysis of team strategies:
- [ ] Explain pit stop decisions and tire strategies
- [ ] Analyze what went wrong/right for each team
- [ ] *"Ferrari's early stop was covering the undercut, but left Leclerc on old rubber for the final 15 laps"*

### 📈 Data Analysis (Java)
- [ ] Driver performance metrics (wins, podiums, DNFs)
- [ ] Constructor standings trends
- [ ] Circuit-specific statistics
- [ ] Head-to-head driver comparisons
- [ ] Qualifying vs race pace analysis
- [ ] Form momentum tracking (trending up/down)

### 🖥️ Web UI (Vaadin)
- [ ] Public dashboard with season standings
- [ ] Driver and constructor profile pages
- [ ] Circuit database with historical winners
- [ ] Interactive prediction interface
- [ ] User dashboard with personal stats
- [ ] Leaderboard and social features
- [ ] Admin panel for data management

## 📁 Project Structure

```
f1_java_webapp/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/f1analysis/
│   │   │       ├── config/           # Security & app configuration
│   │   │       │   ├── SecurityConfig.java
│   │   │       │   └── AiConfig.java
│   │   │       ├── models/           # JPA Entities
│   │   │       │   ├── User.java
│   │   │       │   ├── UserPrediction.java
│   │   │       │   ├── Driver.java
│   │   │       │   ├── Race.java
│   │   │       │   └── ...
│   │   │       ├── repository/       # Spring Data JPA repositories
│   │   │       │   ├── UserRepository.java
│   │   │       │   ├── PredictionRepository.java
│   │   │       │   └── ...
│   │   │       ├── service/          # Business logic
│   │   │       │   ├── UserService.java
│   │   │       │   ├── PredictionService.java
│   │   │       │   ├── F1DataService.java
│   │   │       │   └── ...
│   │   │       ├── ai/               # AI/LLM integration
│   │   │       │   ├── F1ChatService.java
│   │   │       │   ├── RacePredictor.java
│   │   │       │   ├── RecapGenerator.java
│   │   │       │   └── StrategyExplainer.java
│   │   │       ├── api/              # External API clients
│   │   │       │   └── ErgastApiClient.java
│   │   │       ├── views/            # Vaadin UI views
│   │   │       │   ├── MainLayout.java
│   │   │       │   ├── LoginView.java
│   │   │       │   ├── RegisterView.java
│   │   │       │   ├── DashboardView.java
│   │   │       │   ├── DriversView.java
│   │   │       │   ├── PredictionsView.java
│   │   │       │   ├── ChatView.java
│   │   │       │   ├── ProfileView.java
│   │   │       │   └── LeaderboardView.java
│   │   │       └── Application.java
│   │   └── resources/
│   │       ├── db/migration/         # Flyway migrations
│   │       └── application.properties
│   └── test/
├── pom.xml
└── README.md
```

## 🗄️ Database Schema (Supabase)

All tables are created in your Supabase PostgreSQL database. You can view and edit them directly in the Supabase Table Editor.

### F1 Data Tables
- `drivers` - Driver info (name, nationality, DOB)
- `constructors` - Team information
- `circuits` - Track details and locations
- `races` - Race events by season
- `results` - Race results with positions, times, points
- `qualifying` - Qualifying session results

### User & Prediction Tables
- `users` - User accounts (email, password hash, role)
- `user_profiles` - Extended profile info (avatar URL from Supabase Storage)
- `user_predictions` - User race predictions
- `user_watchlist` - Drivers/teams user is tracking
- `prediction_scores` - Calculated accuracy scores

```sql
-- Example: User predictions table (run in Supabase SQL Editor)
CREATE TABLE user_predictions (
    id BIGSERIAL PRIMARY KEY,
    user_id BIGINT REFERENCES users(id),
    race_id BIGINT REFERENCES races(id),
    predicted_winner VARCHAR(100),
    predicted_podium JSONB,
    predicted_fastest_lap VARCHAR(100),
    confidence INTEGER,
    points_earned INTEGER,
    created_at TIMESTAMP WITH TIME ZONE DEFAULT NOW()
);

-- Enable Row Level Security (optional but recommended)
ALTER TABLE user_predictions ENABLE ROW LEVEL SECURITY;
```

### Supabase Storage (Optional)
Use Supabase Storage for user avatars:
- Create a bucket called `avatars`
- Store avatar URLs in `user_profiles.avatar_url`

## 🚀 Getting Started

### Prerequisites
- Java 17 or higher
- Maven 3.8+
- [Supabase account](https://supabase.com) (free tier works great)
- OpenAI API key (for AI features)

### Supabase Setup

1. Create a new project at [supabase.com](https://supabase.com)
2. Go to **Project Settings → Database**
3. Copy the connection string (use "JDBC" format for Java)
4. Find your password (set during project creation)

Your connection string will look like:
```
jdbc:postgresql://db.[PROJECT-REF].supabase.co:5432/postgres
```

### Setup

```bash
# Clone the repo
git clone https://github.com/yourusername/f1_java_webapp.git
cd f1_java_webapp

# Set environment variables
export SUPABASE_DB_URL=jdbc:postgresql://db.xxxxx.supabase.co:5432/postgres
export SUPABASE_DB_USER=postgres
export SUPABASE_DB_PASSWORD=your_supabase_password
export OPENAI_API_KEY=your_openai_key

# Build the project
mvn clean install

# Run the application
mvn spring-boot:run
```

The app will be available at `http://localhost:8080`

### Configuration

Edit `src/main/resources/application.properties`:

```properties
# Supabase Database
spring.datasource.url=${SUPABASE_DB_URL}
spring.datasource.username=${SUPABASE_DB_USER:postgres}
spring.datasource.password=${SUPABASE_DB_PASSWORD}
spring.jpa.hibernate.ddl-auto=update
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect

# Ergast API
ergast.api.base=http://ergast.com/api/f1

# Spring AI (OpenAI)
spring.ai.openai.api-key=${OPENAI_API_KEY}
spring.ai.openai.chat.model=gpt-4o

# Vaadin
vaadin.launch-browser=true

# Security
app.jwt.secret=${JWT_SECRET:your-secret-key}
app.jwt.expiration=86400000
```

### Supabase Dashboard

Once running, you can view your data directly in the Supabase dashboard:
- Go to your project → **Table Editor**
- See all your F1 data, users, and predictions
- Run SQL queries in the **SQL Editor**
- Monitor connections in **Database → Connections**

## 🖥️ Code Examples

### User Registration
```java
@Service
public class UserService {
    
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    
    public User registerUser(String email, String password, String displayName) {
        if (userRepository.existsByEmail(email)) {
            throw new UserAlreadyExistsException("Email already registered");
        }
        
        User user = new User();
        user.setEmail(email);
        user.setPassword(passwordEncoder.encode(password));
        user.setDisplayName(displayName);
        user.setRole(Role.USER);
        user.setCreatedAt(LocalDateTime.now());
        
        return userRepository.save(user);
    }
}
```

### User Prediction CRUD
```java
@Service
public class PredictionService {
    
    private final PredictionRepository predictionRepository;
    
    // Create
    public UserPrediction createPrediction(User user, Race race, 
                                           String winner, List<String> podium) {
        UserPrediction prediction = new UserPrediction();
        prediction.setUser(user);
        prediction.setRace(race);
        prediction.setPredictedWinner(winner);
        prediction.setPredictedPodium(podium);
        prediction.setCreatedAt(LocalDateTime.now());
        return predictionRepository.save(prediction);
    }
    
    // Read
    public List<UserPrediction> getUserPredictions(User user) {
        return predictionRepository.findByUserOrderByCreatedAtDesc(user);
    }
    
    // Update
    public UserPrediction updatePrediction(Long id, String winner, List<String> podium) {
        UserPrediction prediction = predictionRepository.findById(id)
            .orElseThrow(() -> new NotFoundException("Prediction not found"));
        prediction.setPredictedWinner(winner);
        prediction.setPredictedPodium(podium);
        return predictionRepository.save(prediction);
    }
    
    // Delete
    public void deletePrediction(Long id) {
        predictionRepository.deleteById(id);
    }
}
```

### AI Chat Service
```java
@Service
public class F1ChatService {
    
    private final ChatClient chatClient;
    private final F1DataService f1DataService;
    
    public String askAboutF1(String userQuestion) {
        // Get relevant data to provide context
        String context = f1DataService.getRelevantContext(userQuestion);
        
        return chatClient.prompt()
            .system("""
                You are an F1 analyst with access to historical race data.
                Answer questions based on the provided data. Be concise but insightful.
                If you don't have data to answer, say so.
                """)
            .user("Data context: " + context + "\n\nQuestion: " + userQuestion)
            .call()
            .content();
    }
}
```

### Race Weekend Predictor
```java
@Service
public class RacePredictor {
    
    private final ChatClient chatClient;
    private final F1DataService f1DataService;
    
    public RaceWeekendPrediction predictWeekend(Race upcomingRace) {
        // Gather historical data
        List<RaceResult> circuitHistory = f1DataService
            .getCircuitHistory(upcomingRace.getCircuit(), 10);
        List<DriverForm> currentForm = f1DataService.getCurrentDriverForm();
        
        String prompt = String.format("""
            Predict the results for the upcoming %s Grand Prix.
            
            Circuit history (last 10 races): %s
            Current driver form: %s
            
            Provide:
            1. Predicted qualifying top 10
            2. Predicted race winner and podium
            3. Safety car probability (0-100%%)
            4. Key factors influencing your prediction
            
            Return as JSON.
            """, upcomingRace.getName(), circuitHistory, currentForm);
        
        String response = chatClient.prompt()
            .user(prompt)
            .call()
            .content();
        
        return parseResponse(response);
    }
}
```

### Vaadin Login View
```java
@Route("login")
@AnonymousAllowed
public class LoginView extends VerticalLayout implements BeforeEnterObserver {
    
    private final LoginForm login = new LoginForm();
    
    public LoginView() {
        addClassName("login-view");
        setSizeFull();
        setAlignItems(Alignment.CENTER);
        setJustifyContentMode(JustifyContentMode.CENTER);
        
        login.setAction("login");
        
        add(
            new H1("🏎️ F1 Predictions"),
            new Span("Login to make your race predictions"),
            login,
            new RouterLink("Don't have an account? Register", RegisterView.class)
        );
    }
    
    @Override
    public void beforeEnter(BeforeEnterEvent event) {
        if (event.getLocation().getQueryParameters()
                .getParameters().containsKey("error")) {
            login.setError(true);
        }
    }
}
```

### User Dashboard
```java
@Route(value = "dashboard", layout = MainLayout.class)
@RolesAllowed("USER")
public class UserDashboardView extends VerticalLayout {
    
    public UserDashboardView(UserService userService, 
                             PredictionService predictionService,
                             AuthenticatedUser authenticatedUser) {
        
        User user = authenticatedUser.get().orElseThrow();
        
        // Welcome header
        add(new H2("Welcome back, " + user.getDisplayName() + "! 👋"));
        
        // Stats cards
        PredictionStats stats = predictionService.getUserStats(user);
        HorizontalLayout statsRow = new HorizontalLayout(
            createStatCard("Predictions Made", stats.getTotalPredictions()),
            createStatCard("Correct Winners", stats.getCorrectWinners()),
            createStatCard("Accuracy", stats.getAccuracy() + "%"),
            createStatCard("Leaderboard Rank", "#" + stats.getRank())
        );
        add(statsRow);
        
        // Recent predictions
        add(new H3("Your Recent Predictions"));
        Grid<UserPrediction> grid = new Grid<>(UserPrediction.class, false);
        grid.addColumn(p -> p.getRace().getName()).setHeader("Race");
        grid.addColumn(UserPrediction::getPredictedWinner).setHeader("Your Pick");
        grid.addColumn(p -> p.getPointsEarned() != null ? 
            p.getPointsEarned() + " pts" : "Pending").setHeader("Result");
        grid.setItems(predictionService.getUserPredictions(user));
        add(grid);
    }
}
```

## 🔮 AI Model Details

### Race Predictor Factors
The AI considers these inputs when predicting races:
- Driver's historical performance at the circuit
- Current season form (last 5 races)
- Qualifying pace vs race pace patterns
- Team car development trajectory
- Weather forecast and wet weather records
- Safety car probability by circuit
- Head-to-head records for close battles

### Prompt Engineering
We use structured prompts with JSON output for consistent, parseable responses:

```java
String systemPrompt = """
    You are an F1 data analyst. Analyze racing data and make predictions.
    Always respond in valid JSON format.
    Base predictions on historical patterns while acknowledging uncertainty.
    Include confidence percentages for each prediction.
    """;
```

## 🗺️ Roadmap

- **Phase 1**: Project setup (Spring Boot + Vaadin + Supabase + Spring Security)
- **Phase 2**: Supabase database schema and connection
- **Phase 3**: User auth (registration, login, profiles, roles)
- **Phase 4**: Data pipeline (Ergast API → Java → Supabase)
- **Phase 5**: Core UI (Dashboard, Drivers, Circuits views)
- **Phase 6**: User predictions CRUD and leaderboard
- **Phase 7**: Spring AI integration (Chat, Race Predictor)
- **Phase 8**: Advanced AI features (Recaps, Strategy Explainer)
- **Phase 9**: Polish, testing, and deployment

## 📝 Notes

This is a learning project to get back into Java development. The focus is on:
- Building a full-stack CRUD app with real user features
- Learning Supabase as a backend-as-a-service
- Implementing authentication and authorization properly
- Integrating AI/LLMs into a traditional web app
- Working with Spring Boot ecosystem (Security, Data, AI)
- Having fun with F1 data 🏁

---

*Built with ☕ and a love for Formula 1*
