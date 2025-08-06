# FV Medical API Automation Framework

[![Java](https://img.shields.io/badge/Java-17-orange.svg)](https://www.oracle.com/java/)
[![Maven](https://img.shields.io/badge/Maven-3.8.6-blue.svg)](https://maven.apache.org/)
[![Cucumber](https://img.shields.io/badge/Cucumber-7.26.0-green.svg)](https://cucumber.io/)
[![REST Assured](https://img.shields.io/badge/REST_Assured-5.5.5-blue.svg)](https://rest-assured.io/)

## 📋 Overview

This project is a robust API automation testing framework for the FV Medical application. It demonstrates a comprehensive approach to API testing using industry-standard tools and best practices. The framework follows BDD (Behavior-Driven Development) principles with Cucumber to create human-readable test specifications that serve as living documentation.

## 🛠️ Technologies & Tools

- **Java**: Core programming language
- **Maven**: Dependency management and build tool
- **Cucumber**: BDD test framework
- **REST Assured**: API testing library
- **JUnit**: Test runner
- **Jackson**: JSON processing
- **JavaFaker**: Test data generation

## 🏗️ Architecture

The framework follows a modular architecture with clear separation of concerns:

```
src/
├── test/
    ├── java/
    │   ├── requestPayloads/         # Request/Response models
    │   ├── Utility/             # Helper utilities
    │   ├── constants/           # API endpoints and environments
    │   ├── hooks/               # Cucumber hooks
    │   ├── runner/              # Test runners
    │   └── stepDefinitions/     # Step implementations
    └── resources/
        └── features/            # Cucumber feature files
```

## ✨ Key Features

- **BDD Approach**: Feature files written in Gherkin syntax for better readability and collaboration
- **Modular Framework**: Well-organized code structure for maintainability
- **Environment Management**: Support for multiple environments (DEV for now)
- **Authentication Handling**: Centralized token management via AuthTokenContext
- **Data-Driven Testing**: Examples tables in feature files for multiple test scenarios
- **Reporting**: Cucumber HTML and JSON reports
- **Test Data Generation**: Dynamic test data creation using JavaFaker

## 🔐 Authentication Management

The framework implements a robust authentication mechanism using a Singleton pattern:

- **AuthTokenContext**: A centralized class that stores and manages JWT tokens across test scenarios
- **Token Sharing**: Authentication tokens obtained during signup/login are stored and reused in subsequent API calls
- **Clean State**: Tokens are properly managed to ensure test isolation

## 🔄 API Workflows Covered

1. **Patient Registration**: Complete signup flow with validation
2. **User Authentication**: Login functionality with token validation
3. **Account Management**: Account deletion and verification

## 🚀 Getting Started

### Prerequisites

- Java JDK 11 or higher
- Maven 3.6 or higher
- Git

## 📊 Reporting

After test execution, reports are generated in:
- HTML Report: `target/cucumber-html-reports/overview-features.html`
- JSON Report: `target/cucumber-reports/cucumber.json`

## 🔮 Future Enhancements

- **API Contract Testing**: Integration with tools like Pact for contract testing
- **Performance Testing**: Adding performance metrics collection
- **Advanced Reporting**: Integration with dashboarding tools

## 🧪 Test Data Management

The framework uses a combination of:
- Static test data in feature files
- Dynamic data generation using JavaFaker
- Environment-specific configurations

## 🔒 Security Considerations

- Sensitive data is not hardcoded
- Authentication tokens are managed securely
- Environment-specific configurations are separated

## 💻 Code Quality & Best Practices

- **Clean Code**: Follows SOLID principles and clean code practices
- **Reusability**: Common functionality extracted into utility classes
- **Maintainability**: Consistent naming conventions and code organization
- **Error Handling**: Robust error handling and reporting
- **Comments & Documentation**: Well-documented code with meaningful comments

## 📬 Contact

Soumesh Bhaumik: [bhaumiksoumesh12@gmail.com](mailto:your.email@example.com)
LinkedIn: [https://www.linkedin.com/in/contact-soumesh-bhaumik-a0b3b3352/](https://www.linkedin.com/in/yourprofile/)

---

## 🌟 Skills Demonstrated

- **API Testing**: Expertise in designing and implementing comprehensive API test suites
- **Test Automation**: Strong knowledge of test automation principles and frameworks
- **BDD Implementation**: Practical application of Behavior-Driven Development methodology
- **Java Programming**: Proficient Java coding with object-oriented design principles
- **Design Patterns**: Implementation of Singleton pattern for state management
- **CI/CD Integration**: Framework designed to integrate with CI/CD pipelines
- **Test Data Management**: Effective strategies for test data handling
- **Documentation**: Clear and comprehensive technical documentation