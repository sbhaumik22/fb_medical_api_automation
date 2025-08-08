package stepDefinitions;

import io.cucumber.java.en.And;
import models.PatientProfile;
import models.TestDataStore;
import requestPayloads.SignUpPayload;
import constants.EndPoints;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import responseModels.SignUpResponse;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class SignUpStepDefinition extends BaseStepDefinition {
    private final TestDataStore testData;
    static Response signUpRes;
    RequestSpecification signupReq;
    SignUpResponse signUpResponse;

    public SignUpStepDefinition(TestDataStore testData) {
        this.testData = testData;
    }

    @Given("the user added a signup payload with patient details")
    public void the_user_added_a_signup_payload_with_patient_details() {
        PatientProfile profile = testData.getPatientProfile();
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
        signUpPayload.setHnNumber(profile.getHnNumber());
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
        assert expectedValue.equals(actualValue) : "Expected " + key + " should  be " + expectedValue + " but found " + actualValue;
    }

    @And("get the token and patient profile id")
    public void get_the_token_and_patient_profile_id() {
        String token = signUpResponse.getData().getToken();
        String userId = signUpResponse.getData().getUser().get_id();

        // Store values in TestContext for use across features
        AuthTokenContext.setToken(token);
        System.out.println("token: " + token + " and " + "_id: " + userId);
    }
}

