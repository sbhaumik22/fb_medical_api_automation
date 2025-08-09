Feature: Validate Patient Details and Verification Status
  @requireUser @cleanUp
  Scenario: Validate the patient profile details and verification flags
    Given the user sets the "Authorization" header with a valid bearer token
    When the user sends a HTTP "GET" request to the get details endpoint "USER_DELETE"
    Then the get details response body should contain "status" as "success"
    And the response body should contain valid patient profile details
    And all required verification flags should be present and boolean
    And get the relative id of the user