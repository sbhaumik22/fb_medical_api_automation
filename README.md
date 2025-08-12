# FV Hospital API Automation Framework

[![Java](https://img.shields.io/badge/Java-17-orange.svg)](https://www.oracle.com/java/)
[![Maven](https://img.shields.io/badge/Maven-3.8+-blue.svg)](https://maven.apache.org/)
[![Cucumber](https://img.shields.io/badge/Cucumber-7.27.0-green.svg)](https://cucumber.io/)
[![REST Assured](https://img.shields.io/badge/REST_Assured-5.5.5-blue.svg)](https://rest-assured.io/)
[![Jackson](https://img.shields.io/badge/Jackson-2.19.2-red.svg)](https://github.com/FasterXML/jackson)

## 📋 Overview

A comprehensive API automation testing framework for the **FV Hospital (FB@Home)** healthcare application. This framework implements industry-standard testing practices using BDD (Behavior-Driven Development) methodology to validate the complete patient lifecycle from registration to profile verification.

## 🎯 Key Features

✅ **Complete Patient Journey Testing** - End-to-end automation of patient registration, authentication, and profile management  
✅ **BDD Implementation** - Cucumber-based scenarios with Gherkin syntax for readable test documentation  
✅ **Robust API Testing** - REST Assured integration with comprehensive request/response validation  
✅ **JSON Schema Validation** - Contract testing ensuring API response structure compliance  
✅ **Dynamic Test Data Management** - Flexible test data generation and management  
✅ **JWT Authentication** - Secure token-based authentication handling  
✅ **Multi-Format Reporting** - HTML, JSON, and console reports with detailed execution analytics  
✅ **CI/CD Ready** - Maven-based execution suitable for continuous integration pipelines

## 🏥 Application Under Test

The **FV Hospital (FB@Home)** platform provides:
- Patient registration and authentication
- Profile management and verification
- Hospital Number (HN) assignment
- Insurance and identity document management
- Complete patient lifecycle operations

## 🏗️ Project Structure

```
src/test/
├── java/
│   ├── clients/           # API client implementations
│   ├── config/            # Configuration management
│   ├── core/              # Core framework components
│   ├── features/          # Feature-specific test logic
│   ├── models/            # Request/Response POJOs
│   ├── runner/            # Cucumber test runners
│   ├── stepDefinitions/   # BDD step implementations
│   └── utils/             # Utility classes and helpers
└── resources/
    ├── schemas/           # JSON schema files for validation
    └── testData/          # Static test data and assets
```

## 🔄 Test Coverage

### Core Test Scenarios

1. **Patient Registration**
   - User signup with comprehensive field validation
   - Dynamic test data generation
   - Response schema validation
   - JWT token extraction and management

2. **User Authentication**
   - Login credential validation
   - Session management
   - Token lifecycle handling

3. **Profile Verification**
   - Multi-step verification process
   - Document upload integration
   - Hospital Number (HN) assignment
   - Profile status lifecycle tracking

4. **Account Management**
   - Secure account deletion
   - Data cleanup verification
   - End-to-end lifecycle testing

## 🛠️ Technology Stack

### Core Technologies
- **Java 17** - Modern LTS version with enhanced performance
- **Maven 3.8+** - Dependency and build management
- **Cucumber 7.27.0** - BDD framework with Gherkin support
- **REST Assured 5.5.5** - API testing library
- **JUnit 4.13.2** - Test execution framework

### Supporting Libraries
- **Jackson 2.19.2** - JSON processing and object mapping
- **JSON Schema Validator 5.4.0** - Response structure validation
- **Cucumber PicoContainer 7.27.0** - Dependency injection
- **Maven Surefire Plugin 3.2.5** - Test execution and reporting
- **Maven Cucumber Reporting 5.9.0** - HTML report generation

### 📊 Reports

After test execution, reports are generated in:
- **HTML Report**: `target/cucumber-html-reports/overview-features.html`
- **JSON Report**: `target/jsonReports/cucumber.json`
- **Console Output**: Real-time execution feedback

## 🏛️ Architecture Patterns

- **Page Object Model (API Adaptation)** - Structured request/response models
- **Factory Pattern** - Dynamic test data generation
- **Singleton Pattern** - Configuration management
- **Builder Pattern** - Fluent API request construction
- **Strategy Pattern** - Multiple validation approaches

## 📈 Best Practices Implemented

- **BDD Methodology** - Human-readable test scenarios
- **Test Data Management** - Dynamic and static data strategies
- **Contract Testing** - JSON schema validation
- **Security Testing** - JWT token management
- **Reporting** - Comprehensive test execution analytics
- **CI/CD Integration** - Pipeline-ready execution

## 📬 Contact

**Soumesh Bhaumik**  
📧 Email: [bhaumiksoumesh12@gmail.com](mailto:bhaumiksoumesh12@gmail.com)  
💼 LinkedIn: [https://www.linkedin.com/in/contact-soumesh-bhaumik-a0b3b3352/](https://www.linkedin.com/in/contact-soumesh-bhaumik-a0b3b3352/)

---

*A professional API automation framework demonstrating modern testing practices for healthcare applications.*