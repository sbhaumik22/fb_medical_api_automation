package stepDefinitions;

import config.EndPoints;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import models.requests.SignUpPayload;
import models.responses.GetUserDetailsResponse;
import models.responses.SignUpResponse;
import config.ApiConfig;
import core.SharedTestContext;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class signup_steps extends ApiConfig {
    static Response signUpRes;
    RequestSpecification signupReq;
    SignUpResponse signUpResponse;
    RequestSpecification reqUserDetails;
    Response userDetailsRes;
    GetUserDetailsResponse getUserDetailsResponse;

    @Given("the user added a signup payload with patient details")
    public void the_user_added_a_signup_payload_with_patient_details() {
        SignUpPayload signUpPayload = new SignUpPayload();
        signUpPayload.setFirstAndMiddleName(SharedTestContext.getPatientProfile().getFirstAndMiddleName());
        signUpPayload.setLastName(SharedTestContext.getPatientProfile().getLastName());
        signUpPayload.setEmail(SharedTestContext.getPatientProfile().getEmail());
        signUpPayload.setAlpha2code(SharedTestContext.getPatientProfile().getAlpha2code());
        signUpPayload.setDateOfBirth(SharedTestContext.getPatientProfile().getDateOfBirth());
        signUpPayload.setCountryCode(SharedTestContext.getPatientProfile().getCountryCode());
        signUpPayload.setPhoneNumber(SharedTestContext.getPatientProfile().getPhoneNumber());
        signUpPayload.setPassword(SharedTestContext.getPatientProfile().getPassword());
        signUpPayload.setPasswordConfirm(SharedTestContext.getPatientProfile().getPassword());
        signUpPayload.setGender(SharedTestContext.getPatientProfile().getGender());
        signUpPayload.setAcceptedVersion(SharedTestContext.getPatientProfile().getAcceptedVersion());
        signUpPayload.setSelectedLanguage(SharedTestContext.getPatientProfile().getSelectedLanguage());
        signUpPayload.setProfilePic(SharedTestContext.getPatientProfile().getProfilePic());

        if (!(SharedTestContext.getPatientProfile().getHnNumber() == null)) {
            signUpPayload.setHnNumber(SharedTestContext.getPatientProfile().getHnNumber());
        }
        signupReq = given().spec(getRequestSpecification()).body(signUpPayload);

    }

    @When("the user sends a HTTP {string} request to the signup endpoint {string}")
    public void the_user_sends_a_http_request_to_the_signup_endpoint(String HTTPMethod, String endpoint) {
        String apiResource = EndPoints.valueOf(endpoint).getPath();
        signUpRes = signupReq.when().post(apiResource).then().spec(getResponseSpecification()).extract().response();
    }

    @Then("the sign-up response must match the expected schema")
    public void validate_signup_response_schema() {
        signUpRes.then().assertThat().body(matchesJsonSchemaInClasspath("schemas/signup_response_schema.json"));
    }

    @And("the the sign-up response body should contain {string} as {string}")
    public void the_response_body_should_contain_as(String key, String expectedValue) {
        signUpResponse = signUpRes.as(SignUpResponse.class);
        String actualValue = signUpResponse.getStatus();
        assertEquals(actualValue, expectedValue);
    }

    @And("get the token and patient userId and store those to SharedTestContext")
    public void get_the_token_and_patient_user_id_and_store_those_to_shared_test_context() {
        SharedTestContext.setUserToken(signUpResponse.getData().getToken());
        SharedTestContext.setUserId(signUpResponse.getData().getUser().get_id());
    }

    @When("I send a {string} request for the user details endpoint {string}")
    public void i_send_a_request_for_the_user_details_endpoint(String HTTPMethod, String endpoint) {
        reqUserDetails = given().header("Authorization", "Bearer " + SharedTestContext.getUserToken()).spec(getRequestSpecification());
        String apiResource = EndPoints.valueOf(endpoint).getPath();
        userDetailsRes = reqUserDetails.when().get(apiResource).then().extract().response();
    }

    @Then("the returned data should match the sign up details with profile status as {string}")
    public void the_returned_data_should_match_the_sign_up_details_with_profile_status_as(String expectedProfileStatus) {
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
}

