# Budget Trail

A budget-based travel planning web application built with Spring Boot. Users set a budget, trip dates, a region and a travel type, and the app suggests destinations whose daily cost fits the budget, along with accommodation and transport options.


## Features

- User registration and login (Spring Security, session-based) with a role-based admin area
- Seeded catalog of cities and activities (loaded from `data.sql` on startup)
- Budget-based destination recommendations (rule-based, see [How recommendations work](#how-recommendations-work))
- Personalized travel preferences: region, travel type, dates and budget
- Saved travel plans and a user dashboard
- Server-rendered UI (Thymeleaf) plus REST endpoints documented with Swagger/OpenAPI

## Tech Stack

- Java 17, Spring Boot 3.2.3
- Spring Web, Spring Security, Spring Data JPA, Bean Validation
- Thymeleaf (with Spring Security integration) for the UI
- H2 in-memory database (no external DB required)
- springdoc-openapi (Swagger UI)
- Lombok
- Maven

## Getting Started

### Prerequisites

- Java 17+
- Maven 3.6+

No database setup is needed. The app runs on an in-memory H2 database that is seeded automatically at startup.

### Run

```bash
git clone https://github.com/baharerol/Budget-Trail.git
cd Budget-Trail
mvn spring-boot:run
```

Then open http://localhost:8080.

### Default access

| URL | Description |
|-----|-------------|
| `http://localhost:8080` | Application |
| `http://localhost:8080/swagger-ui.html` | Interactive API documentation |
| `http://localhost:8080/h2-console` | H2 database console |

A demo admin account is preconfigured for convenience: **`admin` / `admin`** (demo only - not intended for production).

## How recommendations work

Recommendations are rule-based, not machine learning. Given the user's preferences, the app:

1. Computes a daily budget as `budget ÷ number of days`.
2. Fetches all cities in the selected region.
3. Keeps cities whose daily cost is within the daily budget and whose activities match the selected travel type (falling back to a budget-only filter if none match).
4. For each matching city, suggests accommodation tiers based on the remaining daily budget and transport options based on the region.

The result is a list of affordable destinations with per-city cost, activities, and accommodation/transport suggestions.

## Project structure

```
src/main/java/com/budgettrail/
├── config/      # Security, OpenAPI and MVC configuration
├── controller/  # Web and REST controllers
├── model/       # JPA entities (City, Activity, TravelPlan, TravelPreferences, User, ...)
├── repository/  # Spring Data JPA repositories
└── service/     # Business logic, incl. TravelRecommendationService
src/main/resources/
├── templates/   # Thymeleaf views
├── data.sql     # Seed data
└── application.properties
```

## Limitations & possible improvements

- The UI text is in Turkish only.
- Recommendations are rule-based heuristics, not a learned model.
- Data is stored in an in-memory H2 database, so it resets on every restart. A persistent database (e.g. PostgreSQL) would be needed for real use.
- Demo credentials and the open H2 console are enabled for development convenience and would be removed/secured for production.
