Feature: Validate Registration of patients on FB@Home app
  Scenario Outline: Validate a successfully signup on FB@Home app with valid credentials
    Given the user added a signup payload with "<firstAndMiddleName>", "<lastName>", "<email>","<alpha2code>", "<dateOfBirth>", "<countryCode>", "<phoneNumber>", "<password>", "<passwordConfirm>", "<gender>", "<acceptedVersion>", "<hnNumber>"
    When the user sends a HTTP "POST" request to the signup endpoint "USER_SIGN_UP"
    And the the sign-up response body should contain "status" as "success"
#    And the response body should contain "email" as "<email>"
#    And the response body should contain "countryCode" as "success"
    And get the token and patient profile id

    Examples:
      | firstAndMiddleName | lastName | email                    | alpha2code | dateOfBirth  | countryCode | phoneNumber  | password     | passwordConfirm | gender | acceptedVersion | hnNumber   |
      | Emily              | Watson   | emily.watson@example.com | VN         | 1990-05-20   | 84          | 978907276    | Emily@2024   | Emily@2024      | Female | 9.3             | 874185296  |