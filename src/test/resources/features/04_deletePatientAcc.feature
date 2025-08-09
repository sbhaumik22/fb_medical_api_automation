Feature: Delete Patient Account
  As an authenticated patient,
  I want to delete my patient account,
  So that my personal data is removed and marked inactive in the system.
@requireUser
  Scenario: Successful deletion of a patient account
    Given the user sets the Authorization header with a valid bearer token for deletion
    When the user sends a HTTP "DELETE" request to the delete endpoint "USER_DELETE"
    Then the delete response body should contain "status" as "success"
