Feature: Validate Registration of patients on FB@Home app

  @cleanUp
  Scenario Outline: Validate a successfully signup on FB@Home app with valid credentials
    Given the user added a signup payload with patient info
      | firstAndMiddleName | lastName   | email   | alpha2code   | dateOfBirth | countryCode   | phoneNumber | password   | passwordConfirm   | gender   | acceptedVersion   | selectedLanguage | profilePic   | hnNumber   |
      | <firstName>        | <lastName> | <email> | <alpha2code> | <dob>       | <countryCode> | <phone>     | <password> | <passwordConfirm> | <gender> | <acceptedVersion> | <language>       | <profilePic> | <hnNumber> |
    When the user sends a HTTP "<method>" request to the signup endpoint "<endpoint>"
    Then the sign-up response status code "<statusCode>" and body should contain status message as "<statusMessage>" and set the token and userId
    When I send a "GET" request for the user details endpoint "USER_DETAILS" to check after successful signup
    Then the check the profile status as "<profileStatus>" right after sign up

    Examples:
      | firstName | lastName | email                    | alpha2code | dob        | countryCode | phone     | password  | passwordConfirm | gender | acceptedVersion | language | profilePic                      | method | endpoint     | statusCode | statusMessage | hnNumber  | profileStatus |
      | Emily     | Watson   | emily.watson@example.com | VN         | 1995-01-01 | 84          | 979822674 | Test@1234 | Test@1234       | Female | 9.3             | EN       | https://images.unsplash.com/... | POST   | USER_SIGN_UP | 200        | success       | 841236574 | OPEN          |
      | Emily     | Watson   | emily.watson@example.com | VN         | 1995-01-01 | 84          | 979822674 | Test@1234 | Test@1234       | Female | 9.3             | EN       | https://images.unsplash.com/... | POST   | USER_SIGN_UP | 200        | success       |           | INCOMPLETE    |

  Scenario Outline: Validate a unsuccessful signup on FB@Home app with invalid credentials
    Given the user added a signup payload with patient info
      | firstAndMiddleName | lastName   | email   | alpha2code   | dateOfBirth | countryCode   | phoneNumber | password   | passwordConfirm   | gender   | acceptedVersion   | selectedLanguage | profilePic   |
      | <firstName>        | <lastName> | <email> | <alpha2code> | <dob>       | <countryCode> | <phone>     | <password> | <passwordConfirm> | <gender> | <acceptedVersion> | <language>       | <profilePic> |
    When the user sends a HTTP "<method>" request to the signup endpoint "<endpoint>"
    Then the sign-up response status code "<statusCode>" and body should contain status message as "<statusMessage>"
    And the error message should be "<errorMessage>"

    Examples:
      | firstName | lastName | email                    | alpha2code | dob        | countryCode | phone     | password  | passwordConfirm | gender | acceptedVersion | language | profilePic                      | method | endpoint     | statusCode | statusMessage | errorMessage                                                                                                                                         |
      | Emily     | Watson   | emily.watson@example.com | VN         | 1995-01-01 | 84          | 97982267  | Test@1234 | Test@1234       | Female | 9.3             | EN       | https://images.unsplash.com/... | POST   | USER_SIGN_UP | 400        | fail          | The phone number is not valid.                                                                                                                       |
      | Emily     | Watson   | emily.watsonexample.com  | VN         | 1995-01-01 | 84          | 979822674 | Test@1234 | Test@1234       | Female | 9.3             | EN       | https://images.unsplash.com/... | POST   | USER_SIGN_UP | 400        | fail          | Please provide a valid email.                                                                                                                        |
      |           | Watson   | emily.watson@example.com | VN         | 1995-01-01 | 84          | 979822674 | Test@1234 | Test@1234       | Female | 9.3             | EN       | https://images.unsplash.com/... | POST   | USER_SIGN_UP | 400        | fail          | Please provide a valid first and middle name.                                                                                                        |
      | Emily     |          | emily.watson@example.com | VN         | 1995-01-01 | 84          | 979822674 | Test@1234 | Test@1234       | Female | 9.3             | EN       | https://images.unsplash.com/... | POST   | USER_SIGN_UP | 400        | fail          | Please provide a valid last name.                                                                                                                    |
      | Emily     | Watson   | emily.watson@example.com | VN         | 2025-01-01 | 84          | 979822674 | Test@1234 | Test@1234       | Female | 9.3             | EN       | https://images.unsplash.com/... | POST   | USER_SIGN_UP | 400        | fail          | Age must be more than 15 years.                                                                                                                      |
      | Emily     | Watson   | emily.watson@example.com | VN         | 1995-01-01 | 84          | 979822674 | short     | short           | Female | 9.3             | EN       | https://images.unsplash.com/... | POST   | USER_SIGN_UP | 400        | fail          | 'Password must be at least 8 characters long and contain at least one uppercase letter, one lowercase letter, one number, and one special character' |
      | Emily     | Watson   | emily.watson@example.com | VN         | 1995-01-01 | 84          | 979822674 | Test@1234 | Test@5678       | Female | 9.3             | EN       | https://images.unsplash.com/... | POST   | USER_SIGN_UP | 400        | fail          | Passwords are not the same!                                                                                                                          |
      | Emily     | Watson   | emily.watson@example.com | VN         | 1995-01-01 | 84          | abcphone  | Test@1234 | Test@1234       | Female | 9.3             | EN       | https://images.unsplash.com/... | POST   | USER_SIGN_UP | 400        | fail          | The string supplied did not seem to be a phone number                                                                                                               |
