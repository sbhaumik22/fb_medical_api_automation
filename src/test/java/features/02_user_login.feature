Feature: User Login
  As a registered user
  I want to authenticate using valid credentials
  So that I can access protected modules of the system

  @requireUser @cleanUp
  Scenario Outline: Successful login with valid credentials
    Given the login payload with valid countryCode, phone Number and password
      | countryCode   | phoneNumber   | password   |
      | <countryCode> | <phoneNumber> | <password> |
    When the user sends a HTTP "POST" request to the login endpoint "USER_LOGIN"
    Then the login response status code "<statusCode>" and body should contain status message as "<statusMessage>" and set the token and userId

    Examples:
      | countryCode | phoneNumber | password  | statusCode | statusMessage |
      | 84          | 979822674   | Test@1234 | 200        | success       |

  @requireUser @cleanUp
  Scenario Outline: Unsuccessful login with invalid credentials
    Given the login payload with valid countryCode, phone Number and password
      | countryCode   | phoneNumber   | password   |
      | <countryCode> | <phoneNumber> | <password> |
    When the user sends a HTTP "POST" request to the login endpoint "USER_LOGIN"
    Then the login response status code "<statusCode>" and body should contain status message as "<statusMessage>" with error message as "<errorMessage>"

    Examples:
      | countryCode | phoneNumber | password  | statusCode | statusMessage | errorMessage         |
      | 84          | 979820674   | Test@1234 | 401        | fail          | Invalid Credentials. |
