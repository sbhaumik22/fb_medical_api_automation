Feature: Validate Registration of patients on FB@Home app
  Scenario Outline: Validate a successfully signup on FB@Home app with valid credentials
    Given the user added a signup payload with "<firstAndMiddleName>", "<lastName>", "<email>","<alpha2code>", "<dateOfBirth>", "<countryCode>", "<phoneNumber>", "<password>", "<passwordConfirm>", "<gender>", "<acceptedVersion>", "<hnNumber>"
    When the user sends a HTTP "POST" request to the signup endpoint "USER_SIGN_UP"
    Then the sign-up response must match the expected schema
    And the the sign-up response body should contain "status" as "success"
    And get the token and patient profile id

    Examples:
      | firstAndMiddleName | lastName | email                    | alpha2code | dateOfBirth  | countryCode | phoneNumber  | password     | passwordConfirm | gender | acceptedVersion | hnNumber   |
      | Emily              | Watson   | emily.watson@example.com | VN         | 1990-05-20   | 84          | 978907276    | Test@1234    | Test@1234       | Female | 9.3             | 874185296  |