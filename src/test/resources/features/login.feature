Feature: User Login
  As a registered user
  I want to authenticate using valid credentials
  So that I can access protected modules of the system

  Scenario Outline: Successful login with valid credentials
    Given the login endpoint is "LOGIN"
    When the user provides login payload with country code "<countryCode>" phone Number "<phoneNumber>" and password "<password>"
    And the user sends a HTTP "POST" request to the login endpoint "USER_LOGIN"
    Then the response status code should be "200"
    And the response body should contain "status" as "success"
    And the response should include a valid token

    Examples:
      | phoneNumber | password   | countryCode |
      | 978907276   | Emily@2024 | 84          |
