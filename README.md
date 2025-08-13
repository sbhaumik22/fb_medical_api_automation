# FV Hospital API Automation Framework

[![Java](https://img.shields.io/badge/Java-17-orange.svg)](https://www.oracle.com/java/)
[![Maven](https://img.shields.io/badge/Maven-3.8+-blue.svg)](https://maven.apache.org/)
[![Cucumber](https://img.shields.io/badge/Cucumber-7.27.0-green.svg)](https://cucumber.io/)
[![REST Assured](https://img.shields.io/badge/REST_Assured-5.5.5-blue.svg)](https://rest-assured.io/)
[![Jackson](https://img.shields.io/badge/Jackson-2.19.2-red.svg)](https://github.com/FasterXML/jackson)

## 📋 Overview

A comprehensive API automation testing framework for the **FV Hospital (FB@Home)** healthcare application. This framework implements industry-standard testing practices using BDD (Behavior-Driven Development) methodology to validate the complete patient lifecycle from registration to profile verification.

## 🎯 Key Features

✅ **Complete Patient Journey Testing** - End-to-end automation covering registration, authentication, profile verification, and account management  
✅ **BDD Implementation** - Cucumber-based scenarios with Gherkin syntax for readable, business-friendly test documentation  
✅ **Robust API Testing** - REST Assured integration with comprehensive request/response validation  
✅ **JSON Schema Validation** - Contract testing ensuring API response structure compliance  
✅ **Dynamic Test Data Management** - Flexible test data generation with both positive and negative test scenarios  
✅ **JWT Authentication** - Secure token-based authentication handling across test scenarios  
✅ **Multi-Format Reporting** - HTML, JSON, and console reports with detailed execution analytics  
✅ **CI/CD Ready** - Maven-based execution suitable for continuous integration pipelines

## 🏥 Application Under Test

The **FV Hospital (FB@Home)** platform provides comprehensive healthcare services including:
- Patient registration and authentication
- Profile management and verification
- Hospital Number (HN) assignment and validation
- Insurance and identity document management
- Complete patient lifecycle operations

## 🏗️ Project Structure

```
src/test/
├── java/
│   ├── clients/           # API client implementations
│   │   └── MediaApiClient.java
│   ├── config/            # Configuration and environment management
│   │   ├── ApiConfig.java
│   │   ├── EndPoints.java
│   │   └── Environments.java
│   ├── core/              # Core framework components
│   │   ├── Hooks.java
│   │   ├── PatientProfile.java
│   │   └── SharedTestContext.java
│   ├── features/          # Gherkin feature files
│   │   ├── 01_user_signup.feature
│   │   ├── 02_user_login.feature
│   │   ├── 04_delete_user_account.feature
│   │   └── 05_verify_profile_without_hn.feature
│   ├── models/            # Request/Response POJOs
│   │   ├── requests/      # Request payload models
│   │   └── responses/     # Response model classes
│   ├── runner/            # Cucumber test runners
│   │   └── CucumberTest.java
│   ├── stepDefinitions/   # BDD step implementations
│   │   ├── delete_account_steps.java
│   │   ├── login_steps.java
│   │   ├── signup_steps.java
│   │   └── verify_profile_steps.java
│   └── utils/             # Utility classes and helpers
│       ├── FetchNIDCategories.java
│       ├── FetchUserDetails.java
│       └── JsonUtil.java
└── resources/
    ├── schemas/           # JSON schema files for validation
    │   └── signup_response_schema.json
    └── testData/          # Static test data and assets
        ├── Frame 1321316900.png
        └── signup_withoutHN_patient_profile.json
```

## 🔄 Test Coverage

### Core Test Scenarios

#### 1. **Patient Registration** (`01_user_signup.feature`)
- ✅ **Positive Testing**: Valid user signup with comprehensive field validation
- ✅ **Negative Testing**: Invalid credentials handling (phone, email, required fields)
- ✅ **Dynamic Test Data**: Parameterized test scenarios with data tables
- ✅ **Response Validation**: Schema validation and status code verification
- ✅ **Profile Status Tracking**: Initial profile status validation (OPEN/INCOMPLETE)
- ✅ **JWT Token Management**: Token extraction and secure storage

#### 2. **User Authentication** (`02_user_login.feature`)
- ✅ **Credential Validation**: Country code, phone number, and password authentication
- ✅ **Session Management**: Authentication state establishment
- ✅ **Token Lifecycle**: JWT token generation and validation
- ✅ **Security Testing**: Authentication failure scenarios

#### 3. **Profile Verification** (`05_verify_profile_without_hn.feature`)
- ✅ **Multi-Step Verification**: Address, Photo ID, and Insurance details
- ✅ **Document Upload**: Media API integration for file uploads
- ✅ **Hospital Number Assignment**: HN generation and verification workflow
- ✅ **Profile Status Lifecycle**: Complete verification workflow tracking
- ✅ **Data Consistency**: Cross-system validation

#### 4. **Account Management** (`04_delete_user_account.feature`)
- ✅ **Secure Deletion**: Authenticated account deletion workflow
- ✅ **Data Cleanup**: Complete account removal validation
- ✅ **End-to-End Lifecycle**: Full patient journey testing

## 🛠️ Technology Stack

### Core Technologies
- **Java 17** - Modern LTS version with enhanced performance and features
- **Maven 3.8+** - Dependency management and build automation
- **Cucumber 7.27.0** - BDD framework with advanced Gherkin support
- **REST Assured 5.5.5** - Comprehensive API testing library
- **JUnit 4.13.2** - Reliable test execution framework

### Supporting Libraries
- **Jackson 2.19.2** - High-performance JSON processing and object mapping
- **JSON Schema Validator 5.4.0** - Contract testing and response structure validation
- **Cucumber PicoContainer 7.27.0** - Lightweight dependency injection
- **Maven Surefire Plugin 3.2.5** - Advanced test execution and reporting
- **Maven Cucumber Reporting 5.9.0** - Enterprise-grade HTML report generation

## 🏛️ Architecture & Design Patterns

- **Page Object Model (API Adaptation)** - Structured request/response models for maintainability
- **Factory Pattern** - Dynamic test data generation with `SharedTestContext`
- **Singleton Pattern** - Centralized configuration management
- **Builder Pattern** - Fluent API request construction
- **Strategy Pattern** - Multiple validation approaches (schema, field-level, business logic)
- **Dependency Injection** - Clean object management using Cucumber PicoContainer

## 📬 Contact

**Soumesh Bhaumik**  
📧 Email: [bhaumiksoumesh12@gmail.com](mailto:bhaumiksoumesh12@gmail.com)  
💼 LinkedIn: [https://www.linkedin.com/in/contact-soumesh-bhaumik-a0b3b3352/](https://www.linkedin.com/in/contact-soumesh-bhaumik-a0b3b3352/)

---

*A professional API automation framework demonstrating modern testing practices and comprehensive healthcare application validation.*