Enterprise Test Automation Framework (Selenium, Cucumber, Java)

A robust, enterprise-grade Web UI automation framework built from scratch using Java, Selenium WebDriver, Cucumber (BDD), and TestNG. Designed with clean architecture principles to ensure high reusability, easy maintenance, and seamless parallel test execution.

Architectural Design & Design Patterns:
To maintain enterprise standards, this framework avoids anti-patterns (like hardcoded waits or tightly coupled tests) and incorporates:

* Page Object Model (POM): Strict separation of test scripts, page locators, and business actions.
* Driver Factory Pattern: Thread-safe, centralized WebDriver initialization enabling seamless cross-browser testing and parallel runs.
* Explicit Wait Framework: Custom wrapper utilities to eliminate flaky tests and race conditions.

Execution Commands:
mvn clean test
