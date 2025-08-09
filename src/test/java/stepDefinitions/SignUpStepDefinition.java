package stepDefinitions;

import constants.EndPoints;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import requestPayloads.SignUpPayload;
import responseModels.SignUpResponse;
import utils.ApiConfig;
import utils.PatientProfile;
import utils.SharedTestContext;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.junit.Assert.assertEquals;

public class SignUpStepDefinition extends ApiConfig {
    static Response signUpRes;
    RequestSpecification signupReq;
    SignUpResponse signUpResponse;

    @Given("the user added a signup payload with patient details")
    public void the_user_added_a_signup_payload_with_patient_details() {
        PatientProfile profile = SharedTestContext.getPatientProfile();
        SignUpPayload signUpPayload = new SignUpPayload();
        signUpPayload.setFirstAndMiddleName(profile.getFirstAndMiddleName());
        signUpPayload.setLastName(profile.getLastName());
        signUpPayload.setEmail(profile.getEmail());
        signUpPayload.setAlpha2code(profile.getAlpha2code());
        signUpPayload.setDateOfBirth(profile.getDateOfBirth());
        signUpPayload.setCountryCode(profile.getCountryCode());
        signUpPayload.setPhoneNumber(profile.getPhoneNumber());
        signUpPayload.setPassword(profile.getPassword());
        signUpPayload.setPasswordConfirm(profile.getPassword());
        signUpPayload.setGender(profile.getGender());
        signUpPayload.setAcceptedVersion(profile.getAcceptedVersion());
//        signUpPayload.setHnNumber(profile.getHnNumber());
        // payload.setSelectedLanguage("EN"); // Uncomment if applicable
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

    @And("get the token and patient profile id")
    public void get_the_token_and_patient_profile_id() {
        SharedTestContext.setToken(signUpResponse.getData().getToken());
        SharedTestContext.setUserId(signUpResponse.getData().getUser().get_id());
    }
}

