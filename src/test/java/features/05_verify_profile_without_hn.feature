Feature: Profile Verification Workflow for users without Hospital Number (HN)
  Validates end-to-end profile verification, ensuring data integrity between patient and CMD systems, and HN assignment.

  @requireUser @cleanUp
  Scenario: Complete profile verification lifecycle without existing HN
    Given a user has signed up without an HN
    And the user provides personal information:
      | firstName | lastName | gender | dateOfBirth | countryCode | phoneNumber | email                    | profilePhoto                                                                                                                                                          | relation | hnNumber |
      | Emily     | Watson   | Female | 1990-05-20  | 84          | 979822674   | emily.watson@example.com | https://images.unsplash.com/photo-1566876657812-66eb7b3b1ad5?q=80&w=687&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90oy1wYWdlfHx8fGVufDB8fHx8fA%3D%3D | SELF     | null     |
    And the user provides current address details
      | personalCountryCode | personalPhoneNumber | officeCountryCode | officePhoneNumber | street      | ward        | district | postalCode | city     | province  | saveAs |
      | 84                  | 978907276           | 84                | 978907276         | Park Street | Ward no. 60 | Kolkata  | 711109     | New Town | West Side | Home   |
    And the user provides photo ID details with category title as "Birth Certificate"
      | back                                   | front                                   | number           |
      | https://example.com/images/id_back.jpg | https://example.com/images/id_front.jpg | PHOTOIDTEST73573 |
    And the user provides insurance details
      | company                 | image                                                                     |
      | Axis Max Life Insurance | https://fvhospitalstr.blob.core.windows.net/stage/1718176075108-front.png |
    When the user submits a "POST" request to endpoint "CREATE_PROFILE_VERIFICATION_REQUEST" and store all verification request details from the response
    Then the response status should be "success"
    And the verification request status should be "OPEN"
    And the system retrieves the verification request from CMD using the stored requestId
    And CMD request data should match the patient-side submission
    And the system assigns a unique Hospital Number
    And the profile is marked as verified
    And the profile status should have isHNVerified as "true"
    And the assigned HN should match the admin-provided HN
