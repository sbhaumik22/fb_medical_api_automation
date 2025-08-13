package stepDefinitions;

import config.ApiConfig;
import config.EndPoints;
import core.SharedTestContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import models.requests.LoginPayload;
import models.responses.LoginResponse;

import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class login_steps extends ApiConfig {
    RequestSpecification loginReqSpec;
    Response loginRes;
    LoginResponse loginResponse;

    @Given("the login payload with valid countryCode, phone Number and password")
    public void the_login_payload_with_valid_country_code_phone_number_and_password(io.cucumber.datatable.DataTable dataTable) {
        Map<String, String> profileCredentials = dataTable.asMaps(String.class, String.class).get(0);
        LoginPayload loginPayload = new LoginPayload(profileCredentials.get("countryCode"), profileCredentials.get("phoneNumber"), profileCredentials.get("password"));
        loginReqSpec = given().spec(getRequestSpecification()).body(loginPayload);
    }

    @When("the user sends a HTTP {string} request to the login endpoint {string}")
    public void the_user_sends_a_http_request_to_the_login_endpoint(String HTTPMethod, String endpoint) {
        String loginPath = EndPoints.valueOf(endpoint).getPath();
        loginRes = loginReqSpec.when().post(loginPath).then().spec(getResponseSpecification()).extract().response();
    }

    @Then("the login response status code {string} and body should contain status message as {string} and set the token and userId")
    public void the_login_response_status_code_and_body_should_contain_status_message_as_and_set_the_token_and_user_id(String expectedStatusCode, String expectedStatusMessage) {
        loginResponse = loginRes.as(LoginResponse.class);
        assertEquals(Integer.parseInt(expectedStatusCode), loginRes.getStatusCode());
        assertEquals(expectedStatusMessage, loginResponse.getStatus());
        SharedTestContext.setUserToken(loginResponse.getData().getToken());
        SharedTestContext.setUserId(loginResponse.getData().getUser().get_id());
    }

    @Then("the login response status code {string} and body should contain status message as {string} with error message as {string}")
    public void the_login_response_status_code_and_body_should_contain_status_message_as_with_error_message_as(String expectedStatusCode, String expectedStatusMessage, String expectedErrorMessage) {
        assertEquals(Integer.parseInt(expectedStatusCode), loginRes.getStatusCode());
        assertEquals(expectedStatusMessage, loginRes.jsonPath().getString("status"));
        assertEquals(expectedErrorMessage, loginRes.jsonPath().getString("message"));
    }
}
