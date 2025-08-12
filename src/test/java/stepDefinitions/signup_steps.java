package stepDefinitions;

import config.ApiConfig;
import config.EndPoints;
import core.SharedTestContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import models.requests.SignUpPayload;
import models.responses.GetUserDetailsResponse;
import models.responses.SignUpResponse;

import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class signup_steps extends ApiConfig {
    static Response signUpRes;
    RequestSpecification signupReq;
    SignUpResponse signUpResponse;
    RequestSpecification reqUserDetails;
    Response userDetailsRes;
    GetUserDetailsResponse getUserDetailsResponse;

    @Given("the user added a signup payload with patient info")
    public void the_user_added_a_signup_payload_with_patient_info(io.cucumber.datatable.DataTable dataTable) {
        Map<String, String> signupDetails = dataTable.asMaps(String.class, String.class).get(0);
        SignUpPayload signUpPayload = new SignUpPayload();
        signUpPayload.setFirstAndMiddleName(signupDetails.get("firstAndMiddleName"));
        signUpPayload.setLastName(signupDetails.get("lastName"));
        signUpPayload.setEmail(signupDetails.get("email"));
        signUpPayload.setAlpha2code(signupDetails.get("alpha2code"));
        signUpPayload.setDateOfBirth(signupDetails.get("dateOfBirth"));
        signUpPayload.setCountryCode(signupDetails.get("countryCode"));
        signUpPayload.setPhoneNumber(signupDetails.get("phoneNumber"));
        signUpPayload.setPassword(signupDetails.get("password"));
        signUpPayload.setPasswordConfirm(signupDetails.get("passwordConfirm"));
        signUpPayload.setGender(signupDetails.get("gender"));
        signUpPayload.setAcceptedVersion(signupDetails.get("acceptedVersion"));
        signUpPayload.setSelectedLanguage(signupDetails.get("selectedLanguage"));
        signUpPayload.setProfilePic(signupDetails.get("profilePic"));

        if (!(signupDetails.get("hnNumber") == null)) {
            signUpPayload.setHnNumber(signupDetails.get("hnNumber"));
        }
        signupReq = given().spec(getRequestSpecification()).body(signUpPayload);
    }

    @When("the user sends a HTTP {string} request to the signup endpoint {string}")
    public void the_user_sends_a_http_request_to_the_signup_endpoint(String HTTPMethod, String endpoint) {
        String apiResource = EndPoints.valueOf(endpoint).getPath();
        signUpRes = signupReq.when().post(apiResource).then().spec(getResponseSpecification()).extract().response();
    }

    @Then("the sign-up response status code {string} and body should contain status message as {string} and set the token and userId")
    public void the_sign_up_response_status_code_and_body_should_contain_status_message_as_and_set_the_token_and_user_id(String expectedStatusCode, String expectedStatus) {
        signUpRes.then().assertThat().statusCode(Integer.parseInt(expectedStatusCode));
        signUpResponse = signUpRes.as(SignUpResponse.class);
        assertEquals(expectedStatus, signUpResponse.getStatus());
        SharedTestContext.setUserToken(signUpResponse.getData().getToken());
        SharedTestContext.setUserId(signUpResponse.getData().getUser().get_id());
    }

    @Then("the sign-up response status code {string} and body should contain status message as {string}")
    public void the_sign_up_response_status_code_and_body_should_contain_status_message_as(String expectedStatusCode, String expectedStatus) {
        assertEquals(Integer.parseInt(expectedStatusCode), signUpRes.jsonPath().getInt("error.statusCode"));
        assertEquals(expectedStatus, signUpRes.jsonPath().getString("error.status"));
    }

    @When("I send a {string} request for the user details endpoint {string} to check after successful signup")
    public void i_send_a_request_for_the_user_details_endpoint_to_check_after_successful_signup(String HTTPMethod, String endpoint) {
        reqUserDetails = given().header("Authorization", "Bearer " + SharedTestContext.getUserToken()).spec(getRequestSpecification());
        String endpointPath = EndPoints.valueOf(endpoint).getPath();
        userDetailsRes = reqUserDetails.when().get(endpointPath).then().extract().response();
    }

    @Then("the check the profile status as {string} right after sign up")
    public void the_check_the_profile_status_as_right_after_sign_up(String expectedProfileStatus) {
        getUserDetailsResponse = userDetailsRes.as(GetUserDetailsResponse.class);
        String actualValue = getUserDetailsResponse.getStatus();
        assertEquals("success", actualValue);
        assertEquals(SharedTestContext.getPatientProfile().getFirstAndMiddleName(), getUserDetailsResponse.getData().getUserProfile().getFirstName());
        assertEquals(SharedTestContext.getPatientProfile().getLastName(), getUserDetailsResponse.getData().getUserProfile().getLastName());
//        assertEquals(SharedTestContext.getPatientProfile().getDateOfBirth(), getUserDetailsResponse.getData().getUserProfile().getDateOfBirth());
        assertEquals(SharedTestContext.getPatientProfile().getGender(), getUserDetailsResponse.getData().getUserProfile().getGender());
        assertEquals(SharedTestContext.getPatientProfile().getCountryCode(), getUserDetailsResponse.getData().getUserProfile().getCountryCode());
        if (!(SharedTestContext.getPatientProfile().getHnNumber() == null)) {
            assertEquals(SharedTestContext.getPatientProfile().getHnNumber(), getUserDetailsResponse.getData().getUserProfile().getHnNumber());
        }
        assertEquals(SharedTestContext.getPatientProfile().getPhoneNumber(), getUserDetailsResponse.getData().getUserProfile().getPhoneNumber());
        assertEquals(SharedTestContext.getPatientProfile().getEmail(), getUserDetailsResponse.getData().getUserProfile().getEmail());
        assertFalse(getUserDetailsResponse.getData().getUserProfile().getIsHNVerified()); //first time after signUp
        assertEquals(expectedProfileStatus, getUserDetailsResponse.getData().getHnVerificationOpenRequest().getStatus());
    }

    @Then("the error message should be {string}")
    public void the_error_message_should_be(String expectedErrorMessage) {
        assertEquals(expectedErrorMessage, signUpRes.jsonPath().getString("message"));
    }
}

