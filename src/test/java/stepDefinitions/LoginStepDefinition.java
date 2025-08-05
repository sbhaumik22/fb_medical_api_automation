package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.specification.RequestSpecification;

public class LoginStepDefinition extends BaseTest{
    RequestSpecification loginReqSpec;

    @Given("the login endpoint is {string}")
    public void the_login_endpoint_is(String string) {

    }
    @When("the user provides login payload with country code {string} phone Number {string} and password {string}")
    public void the_user_provides_login_payload_with_country_code_phone_number_and_password(String string, String string2, String string3) {

    }
    @When("the user sends a HTTP {string} request to the login endpoint {string}")
    public void the_user_sends_a_http_request_to_the_login_endpoint(String string, String string2) {

    }
    @Then("the response status code should be {string}")
    public void the_response_status_code_should_be(String string) {

    }
    @Then("the response should include a valid token")
    public void the_response_should_include_a_valid_token() {

    }
}
