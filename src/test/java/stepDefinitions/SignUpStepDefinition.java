package stepDefinitions;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
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

public class SignUpStepDefinition extends BaseTest {
    static Response signUpRes;
    RequestSpecification signupReq;

    @Given("the user added a signup payload with {string}, {string}, {string},{string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}")
    public void theUserAddedASignupPayloadWith(String firstAndMiddleName, String lastName, String email, String alpha2code, String dateOfBirth, String countryCode, String phoneNumber, String password, String passwordConfirm, String gender, String acceptedVersion, String hnNumber) {
        SignUpPayload signUpPayload = new SignUpPayload();
        signUpPayload.setFirstAndMiddleName(firstAndMiddleName);
        signUpPayload.setLastName(lastName);
        signUpPayload.setEmail(email);
        signUpPayload.setAlpha2code(alpha2code);
        signUpPayload.setDateOfBirth(dateOfBirth);
        signUpPayload.setCountryCode(countryCode);
        signUpPayload.setPhoneNumber(phoneNumber);
        signUpPayload.setPassword(password);
        signUpPayload.setPasswordConfirm(passwordConfirm);
        signUpPayload.setGender(gender);
        signUpPayload.setAcceptedVersion(acceptedVersion);
        signUpPayload.setHnNumber(hnNumber);
        // payload.setSelectedLanguage("EN"); // Uncomment if applicable
        signupReq = given().spec(getRequestSpec()).body(signUpPayload);
    }

    @When("the user sends a HTTP {string} request to the signup endpoint {string}")
    public void the_user_sends_a_http_request_to_the_signup_endpoint(String HTTPMethod, String endpoint) {
        String apiResource = EndPoints.valueOf(endpoint).getPath();
        signUpRes = signupReq.when().post(apiResource).then().spec(getResponseSpecification()).extract().response();
        System.out.println("payload hit");
    }

    @Then("the sign-up response must match the expected schema")
    public void validate_signup_response_schema() {
        signUpRes.then().assertThat().body(matchesJsonSchemaInClasspath("schemas/signup_response_schema.json"));
    }

    @Then("the the sign-up response body should contain {string} as {string}")
    public void the_response_body_should_contain_as(String key, String expectedValue) {
        SignUpResponse signUpResponse = signUpRes.as(SignUpResponse.class);
        String actualValue = signUpResponse.getStatus();
        assert expectedValue.equals(actualValue) : "Expected " + key + " should  be " + expectedValue + " but found " + actualValue;
    }

    @Then("get the token and patient profile id")
    public void get_the_token_and_patient_profile_id() {
        String token = signUpRes.jsonPath().getString("data.token");
        String userId = signUpRes.jsonPath().getString("data.user._id");

        // Store values in TestContext for use across features
        AuthTokenContext.setToken(token);
        System.out.println("token: " + token + " and " + "_id: " + userId);
    }


}

