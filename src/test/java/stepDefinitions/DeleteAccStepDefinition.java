package stepDefinitions;

import constants.EndPoints;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class DeleteAccStepDefinition extends SpecificationConfig {
    RequestSpecification reqDeleteSpec;
    Response delRes;
    @Given("the user sets the {string} header with a valid bearer token for deletion")
    public void the_user_sets_the_header_with_a_valid_bearer_token_for_deletion(String auth) {
        reqDeleteSpec = given().header(auth, "Bearer " +  AuthTokenContext.getToken()).spec(getRequestSpec());
    }
    @When("the user sends a HTTP {string} request to the delete endpoint {string}")
    public void the_user_sends_a_http_request_to_the_delete_endpoint(String HTTPMethod, String endpoint) {
        String apiResource = EndPoints.valueOf(endpoint).getPath();
        delRes = reqDeleteSpec.when().delete(apiResource).then().spec(getResponseSpecification()).extract().response();
    }
    @Then("the delete response body should contain {string} as {string}")
    public void the_delete_response_body_should_contain_as(String key, String expectedValue) {
        String actualValue = delRes.jsonPath().getString(key);
        assert expectedValue.equals(actualValue) : "Expected " + key + " should  be " + expectedValue + " but found " + actualValue;
    }
}
