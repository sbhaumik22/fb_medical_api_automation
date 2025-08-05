package stepDefinitions;

import POJOClasses.SignUpPayload;
import constants.EndPoints;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

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

    @When("the user sends a HTTP {string} request {string}")
    public void the_user_sends_a_http_request(String HTTPMethod, String endpoint) {
        String apiResource = EndPoints.valueOf(endpoint).getPath();
        System.out.println(apiResource);
        if (HTTPMethod.equalsIgnoreCase("POST")) {
            signUpRes = signupReq.when().post(apiResource).then().spec(getResponseSpecification()).extract().response();
            System.out.println("payload hit");
        }
    }

    @Then("the response body should contain {string} as {string}")
    public void the_response_body_should_contain_as(String key, String expectedValue) {
        String actualValue = signUpRes.jsonPath().getString(key);
        assert expectedValue.equals(actualValue) : "Expected " + key + " should  be " + expectedValue + " but found " + actualValue;
    }

    @Then("get the token and patient profile id")
    public void get_the_token_and_patient_profile_id() {
        JWTToken = signUpRes.jsonPath().getString("data.token");
        System.out.println(JWTToken);
    }
}

