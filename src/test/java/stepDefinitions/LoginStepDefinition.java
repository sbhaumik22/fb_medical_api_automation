package stepDefinitions;

import requestPayloads.LoginPayload;
import constants.EndPoints;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import responseModels.LoginResponse;

import static io.restassured.RestAssured.given;

public class LoginStepDefinition extends SpecificationConfig {
    RequestSpecification loginReqSpec;
    Response loginRes;
    LoginResponse loginResponse;

    @Given("the login payload with country code {string} phone Number {string} and password {string}")
    public void the_login_payload_with_country_code_phone_number_and_password(String countryCode, String phoneNumber, String password) {
        LoginPayload loginPayload = new LoginPayload(countryCode, phoneNumber, password);
        loginReqSpec = given().spec(getRequestSpec()).body(loginPayload);
    }
    @When("the user sends a HTTP {string} request to the login endpoint {string}")
    public void the_user_sends_a_http_request_to_the_login_endpoint(String HTTPMethod, String endpoint) {
        String apiResource = EndPoints.valueOf(endpoint).getPath();
        loginRes = loginReqSpec.when().post(apiResource).then().spec(getResponseSpecification()).extract().response();
    }
    @Then("the login response body should contain {string} as {string}")
    public void the_login_response_body_should_contain_as(String key, String expectedValue) {
        loginResponse = loginRes.as(LoginResponse.class);
        String actualValue = loginResponse.getStatus();
        assert expectedValue.equals(actualValue) : "Expected " + key + " should  be " + expectedValue + " but found " + actualValue;
    }
    @Then("the response should include a valid token")
    public void the_response_should_include_a_valid_token() {
        String token = loginResponse.getData().getToken();
        AuthTokenContext.setToken(token);
    }
}
