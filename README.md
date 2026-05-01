#  Developer Productivity MVP

A full-stack application that transforms raw developer productivity metrics into meaningful insights and actionable recommendations.
Engineering teams often track metrics like Lead Time, Cycle Time, Bug Rate, Deployment Frequency, and PR Throughput.

However, **raw metrics alone do not explain what is happening or what actions to take next**.

This project bridges that gap by:

* Interpreting metrics
* Generating insights
* Suggesting actionable improvements

---

##  Key Features

*  Displays core developer productivity metrics
*  Generates insights based on metric thresholds
*  Provides actionable suggestions
*  Lightweight full-stack MVP (Spring Boot + React)
*  Uses real dataset (converted from Excel to JSON)

---

##  Metrics Implemented

* **Lead Time for Changes**
  Average time from PR opened → deployed

* **Cycle Time**
  Time from issue in-progress → done

* **Bug Rate**
  Escaped production bugs / completed issues

* **Deployment Frequency**
  Number of successful deployments

* **PR Throughput**
  Number of merged pull requests

---

##  Tech Stack

### Backend

* Java
* Spring Boot
* Jackson (JSON parsing)

### Frontend

* React.js (Vite)
* Axios
---

##  How It Works

1. Data is loaded from a structured JSON file (converted from Excel)
2. Backend calculates metrics using defined formulas
3. A rule-based system generates insights and suggestions
4. Frontend fetches and displays the results

---

### Backend (Spring Boot)

```bash
cd backend
mvn spring-boot:run
```

Runs on: `http://localhost:8080`

---

### Frontend (React)

```bash
cd frontend
npm install
npm run dev
```

Runs on: `http://localhost:5173`

---

##  Design Decisions

* Used **minimal data model** to focus on core logic
* Avoided database to keep MVP lightweight
* Implemented **rule-based interpretation layer** for explainability
* Separated concerns: data → metrics → insights → UI

---

##  Limitations

* Uses static dataset (no real-time updates)
* No authentication or multi-user support
* Insights are rule-based (not ML-driven)

---

##  Future Improvements

* Add filters (developer, team, time range)
* Trend analysis with charts
* Advanced insights using AI/ML
* Integration with real tools (GitHub, Jira, CI/CD)

---

##  Demo

(Add your video link here)

---

##  Final Note

This project focuses on **clarity of problem-solving and product thinking**, not infrastructure complexity.
It demonstrates how raw engineering metrics can be transformed into meaningful decisions.

