Feature: User Login
  As a registered user
  I want to authenticate using valid credentials
  So that I can access protected modules of the system

  Scenario: Successful login with valid credentials
    Given the login payload with countryCode, phone Number and password
    When the user sends a HTTP "POST" request to the login endpoint "USER_LOGIN"
    Then the login response body should contain "status" as "success"
    And the response should include a valid token
