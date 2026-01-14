# Automation Test Framework

## Overview
A production-ready **Appliation Automation Test Framework** built using **Spring Boot 3** and **Selenium WebDriver**. This framework is designed to serve as a centralized platform for managing, executing, and reporting on automated test cases. It features a modern Web UI for easy interaction and a robust backend for handling execution logic.

## Key Features
- **Web-Based Test Management**: Create, Edit, and Delete test cases via a user-friendly Dashboard.
- **Keyword-Driven Execution Engine**: Write tests using simple, human-readable keywords (e.g., `OPEN`, `CLICK`, `TYPE`, `ASSERT_TITLE`).
- **Cross-Browser Support**: Configurable support for Chrome and Firefox (Headless modes supported).
- **Execution History**: Automatically stores execution logs, status (PASS/FAIL), and timestamps in the database.
- **Asynchronous Execution**: Tests run in the background without blocking the UI.
- **REST API Support**: Trigger test executions programmatically via API endpoints.

## Technology Stack
- **Backend**: Java 17, Spring Boot 3.2, Spring Data JPA
- **Frontend**: Thymeleaf, Bootstrap 5, JavaScript
- **Automation**: Selenium WebDriver 4
- **Database**: H2 (In-Memory for Dev) / MySQL Compatible
- **Build Tool**: Maven

##  Prerequisites
- **Java 17** or higher
- **Maven** 3.6+
- **Google Chrome** (or Firefox) installed

##  How to Run

1. **Clone the repository** (or navigate to the project folder):
   ```bash
   cd automation-framework
   ```

2. **Build the project**:
   ```bash
   mvn clean install
   ```

3. **Run the application**:
   ```bash
   mvn spring-boot:run
   ```

4. **Access the Dashboard**:
   Open [http://localhost:8080](http://localhost:8080) in your browser.

## 📖 How to Use

### Creating a Test Case
1. Click **"Create Test Case"** on the Dashboard.
2. Provide a **Name** and **Description**.
3. Select the preferred **Browser** (Chrome/Firefox).
4. Define **Test Steps** using the Keyword Format (see below).
5. Click **Save**.

### Keyword Format
The engine supports a pipe-separated format: `KEYWORD|DATA`

| Keyword | Format | Example |
|---------|--------|---------|
| **OPEN** | `OPEN\|url` | `OPEN\|https://google.com` |
| **TYPE** | `TYPE\|locator:value\|text` | `TYPE\|name:q\|Spring Boot` |
| **CLICK** | `CLICK\|locator:value` | `CLICK\|name:btnK` |
| **ASSERT_TITLE** | `ASSERT_TITLE\|text` | `ASSERT_TITLE\|Google` |
| **WAIT** | `WAIT\|milliseconds` | `WAIT\|2000` |

**Example Script:**
```text
OPEN|https://www.google.com
TYPE|name:q|Selenium WebDriver
CLICK|name:btnK
WAIT|2000
ASSERT_TITLE|Selenium
```

### Triggering Execution
- **Via UI**: Click the **Run** button next to any test case on the Dashboard.
- **Via API**: execute a POST request to `/api/execution/run/{id}`.

##  Project Structure
```
src/main/java/com/automation/framework
├── config          # App Configurations
├── controller      # Web & REST Controllers
├── core            # Selenium Wrapper & Browser Factory
├── entity          # Database Models (TestCase, ExecutionResult)
├── repository      # JPA Repositories
├── service         # Business Logic (Execution Engine)
└── AutomationFrameworkApplication.java
```

##  Contributing
1. Fork the repository.
2. Create feature branch (`git checkout -b feature/NewFeature`).
3. Commit changes (`git commit -m 'Add NewFeature'`).
4. Push to branch (`git push origin feature/NewFeature`).
5. Open a Pull Request.

##  License
Distributed under the MIT License.
