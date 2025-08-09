# FV Medical API Automation Framework

[![Java](https://img.shields.io/badge/Java-17-orange.svg)](https://www.oracle.com/java/)
[![Maven](https://img.shields.io/badge/Maven-3.8.6-blue.svg)](https://maven.apache.org/)
[![Cucumber](https://img.shields.io/badge/Cucumber-7.26.0-green.svg)](https://cucumber.io/)
[![REST Assured](https://img.shields.io/badge/REST_Assured-5.5.5-blue.svg)](https://rest-assured.io/)
[![JavaFaker](https://img.shields.io/badge/JavaFaker-1.0.2-yellow.svg)](https://github.com/DiUS/java-faker)
[![Jackson](https://img.shields.io/badge/Jackson-2.19.2-red.svg)](https://github.com/FasterXML/jackson)

## 📋 Overview

This project is a **production-ready API automation testing framework** for the FV Medical application, built following **industry-standard practices** and modern test automation principles. The framework demonstrates a comprehensive approach to API testing using cutting-edge tools and architectural patterns that align with current industry standards.

The framework follows **BDD (Behavior-Driven Development)** principles with Cucumber to create human-readable test scenarios that bridge the gap between technical and non-technical stakeholders, making it suitable for enterprise-level projects.

## 🏗️ Framework Architecture

```
src/
├── test/
    ├── java/
    │   ├── constants/           # API endpoints and environment configurations
    │   ├── hooks/               # Cucumber lifecycle hooks for setup/teardown
    │   ├── models/              # Data models and test data store
    │   ├── requestPayloads/     # Request payload models (POJOs)
    │   ├── responseModels/      # Response model classes for deserialization
    │   ├── runner/              # Cucumber test runner configuration
    │   ├── stepDefinitions/     # Step definition implementations
    │   └── utils/             # Test data factories and helper utilities
    └── resources/
        ├── features/            # Gherkin feature files (BDD scenarios)
        ├── schemas/             # JSON schema files for response validation
        └── testData/            # Static test data files (JSON)
```

## ✨ Key Features & Industry Standards Compliance

### 🎯 **BDD Implementation**
- **Gherkin Syntax**: Feature files written in business-readable language
- **Living Documentation**: Tests serve as executable specifications
- **Stakeholder Collaboration**: Bridge between business and technical teams

### 🏛️ **Enterprise Architecture Patterns**
- **Page Object Model Adaptation**: Applied to API testing with payload/response models
- **Dependency Injection**: Using Cucumber PicoContainer for clean object management
- **Separation of Concerns**: Clear separation between test logic, data, and configuration
- **Single Responsibility Principle**: Each class has a focused, single purpose

### 📊 **Test Data Management (Industry Best Practice)**
- **Hybrid Approach**: Combines static JSON files with dynamic data generation
- **Data Factory Pattern**: `TestDataFactory` using JavaFaker for realistic test data
- **Test Data Isolation**: Each test gets fresh, independent data
- **Environment-Specific Data**: Configurable data sources per environment
- **Data-Driven Testing**: JSON-based test data for maintainability

### 🔒 **Security & Token Management**
- **JWT Token Handling**: Secure token storage and management across test scenarios
- **Authentication Context**: Centralized token management with `AuthTokenContext`
- **Session Management**: Proper cleanup and token lifecycle management

### 🛡️ **Validation & Quality Assurance**
- **JSON Schema Validation**: Contract testing with schema validation
- **Response Model Mapping**: Type-safe response handling with POJOs
- **Assertion Strategies**: Multiple validation layers for comprehensive testing
- **Error Handling**: Robust error handling and meaningful failure messages

### 📈 **Reporting & Observability**
- **Multi-Format Reporting**: JSON, HTML, and console reports
- **Cucumber Reports**: Industry-standard BDD reporting
- **Traceability**: Clear mapping between requirements and test execution
- **CI/CD Integration**: Maven-based execution suitable for pipeline integration

## 🔄 API Test Coverage & Workflows

### 🏥 **Complete Patient Journey Testing**
1. **Patient Registration** (`01_signupPatient.feature`)
   - Complete signup flow with comprehensive field validation
   - JSON schema validation for response structure
   - Token extraction and storage for subsequent tests

2. **User Authentication** (`02_loginPatient.feature`)
   - Login functionality with credential validation
   - JWT token validation and management
   - Session establishment verification

3. **Profile Management** (`03_getUserProfile.feature`)
   - Authenticated user profile retrieval
   - Data integrity validation
   - Verification status checks

4. **Account Lifecycle** (`04_deletePatientAcc.feature`)
   - Secure account deletion workflow
   - Data cleanup verification
   - End-to-end lifecycle completion

### 🔗 **Test Dependencies & Flow**
- **Sequential Execution**: Tests are designed to run in sequence
- **State Management**: Token and user data shared across scenarios
- **Clean Teardown**: Proper cleanup after test completion

## 📊 Reporting & Analytics

### 📈 **Multi-Tier Reporting Strategy**
After test execution, comprehensive reports are generated:

- **JSON Reports**: `target/jsonReports/cucumber.json` (Machine-readable)
- **HTML Reports**: `target/cucumber-html-report` (Human-readable)
- **Advanced Cucumber Reports**: `target/cucumber-html-reports` (Enterprise-grade)
- **Console Output**: Real-time execution feedback

### 📋 **Report Features**
- **Test Execution Summary**: Pass/fail statistics with timing
- **Step-by-Step Details**: Granular execution information
- **Screenshot Integration**: (Configurable for UI components)
- **Trend Analysis**: Historical test execution data
- **CI/CD Integration**: Jenkins/GitHub Actions compatible

## 🛠️ Technology Stack & Dependencies

### 🔧 **Core Technologies**
- **Java 17**: Modern LTS version with enhanced features
- **Maven 3.8+**: Advanced dependency and build management
- **Cucumber 7.26.0**: Latest BDD framework with enhanced features
- **REST Assured 5.5.5**: Industry-leading API testing library
- **JUnit 4.13.2**: Reliable test execution framework

### 📚 **Supporting Libraries**
- **Jackson 2.19.2**: High-performance JSON processing
- **JavaFaker 1.0.2**: Realistic test data generation
- **JSON Schema Validator 5.4.0**: Contract testing support
- **Cucumber PicoContainer 7.14.0**: Dependency injection
- **Groovy 4.0.27**: Advanced scripting capabilities



## 📬 Contact

Soumesh Bhaumik: [bhaumiksoumesh12@gmail.com](mailto:bhaumiksoumesh12@gmail.com)
LinkedIn: [https://www.linkedin.com/in/contact-soumesh-bhaumik-a0b3b3352/](https://www.linkedin.com/in/contact-soumesh-bhaumik-a0b3b3352/)