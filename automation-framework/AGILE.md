# Agile Project Documentation
**Project Name:** Automation Test Framework
**Intern Name:** Harini Mohankumar
**Domain:** Software Testing & Automation
**Technology Stack:** Spring Boot, Selenium, Thymeleaf, MySQL/H2

---

## � Project Vision
As part of my Infosys Spring Boot Internship, my goal was to build a comprehensive **Automation Test Framework**. The idea was to bridge the gap between manual testing and code-heavy automation by creating a tool that allows users to write test cases using simple keywords, managed through a user-friendly web interface.

This project demonstrates my understanding of **Spring Boot Architecture**, **JPA**, and **Selenium WebDriver** integration.

---

## 👤 Stakeholders & Personas
Since this is an internship project, I analyzed the requirements from multiple perspectives:

*   **The Manual Tester (Scenario):** Needs a way to run automation without learning Java.
    *   *Need:* A GUI to input test steps like "OPEN google.com" instead of writing code.
*   **The Automation Lead (Scenario):** Needs centralized reporting.
    *   *Need:* A dashboard that shows PASS/FAIL history.
*   **The Developer (Me):** Needs a clean, modular architecture.
    *   *Need:* MVC pattern, Service layer isolation, and reusable components.

---

## � Sprint Planning (Project Roadmap)

I organized my development work into **4 Sprints** (1 week each) to ensure steady progress.

### Sprint 1: Project Setup & Architecture
*   **Goal:** Initialize the Spring Boot Core.
*   **User Stories Completed:**
    *   [x] As a developer, I want to set up the Spring Boot project with Maven dependencies (Selenium, JPA, Lombok).
    *   [x] As a developer, I want to design the Database Schema (`TestCase` and `ExecutionResult` entities).
    *   [x] As a developer, I want to configure the `application.properties` for H2 database and browser settings.

### Sprint 2: The Core Engine (Backend)
*   **Goal:** Make the browser launch and execute commands.
*   **User Stories Completed:**
    *   [x] As an architect, I want to build a `BrowserFactory` to handle Chrome/Firefox switching.
    *   [x] As a developer, I want to implement a **Keyword-Driven Execution Service** that parses string commands (`CLICK`, `TYPE`) into Selenium actions.

### Sprint 3: Test Management Features (Frontend)
*   **Goal:** Allow users to interact with the system.
*   **User Stories Completed:**
    *   [x] As a user, I want a **Dashboard** using Thymeleaf to view all test cases.
    *   [x] As a user, I want a **Create Test Form** to save new test scenarios to the database.
    *   [x] As a user, I want to Edit/Delete test cases.

### Sprint 4: Reporting & Final Polish
*   **Goal:** Visualize the results.
*   **User Stories Completed:**
    *   [x] As a user, I want to see **Live Execution Results** (Pass/Fail status) on the dashboard.
    *   [x] As a user, I want asynchronous execution so the UI doesn't freeze while the browser is running.
    *   [x] **Final Review:** Code cleanup, commenting, and README creation.

---

## 📝 Retrospective & Key Learnings
Working on this project helped me master several key concepts:

1.  **Spring Boot Integration:** I learned how to integrate non-web libraries (Selenium) into the Spring container (Beans/Services).
2.  **JPA & Databases:** Designing the One-to-Many relationship between Test Cases and Results gave me practical experience with Hibernate.
3.  **Thymeleaf:** I improved my skills in server-side rendering and creating dynamic HTML templates.
4.  **Agile Mindset:** Breaking the massive "Automation Framework" requirement into small, manageable stories helped me finish on time.

---

**Signed:**
*Harini Mohankumar*
*Infosys Spring Boot Intern*
