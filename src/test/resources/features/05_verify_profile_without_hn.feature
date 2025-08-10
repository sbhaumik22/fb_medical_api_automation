Feature: Profile Verification Workflow for users without HN

  @requireUser @cleanUp
  Scenario: Add profile details (Address, Photo ID, Insurance) and complete profile verification lifecycle
    Given the user provides personal information including address, photo ID, and insurance details
    When the user submits a HTTP "<method>" request to the profile details endpoint "<endpoint>"
    Then the API response status should be "success"
    And the response body should include valid verification request details with request status set to "OPEN"
    And retrieve the profile verification request from the CMD system using the requestId
    And validate that the CMD-side request data matches the patient-side submission
    And verify the Hospital Number (HN) assignment process and generate a unique HN
    And confirm that post-verification, the profile status reflects isHNVerified as "true"
    And ensure the assigned HN matches the admin-provided HN value