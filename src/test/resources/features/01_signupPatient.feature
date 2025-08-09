Feature: Validate Registration of patients on FB@Home app
  @@cleanUp
  Scenario: Validate a successfully signup on FB@Home app with valid credentials
    Given the user added a signup payload with patient details
    When the user sends a HTTP "POST" request to the signup endpoint "USER_SIGN_UP"
    Then the sign-up response must match the expected schema
    And the the sign-up response body should contain "status" as "success"
    And get the token and patient profile id