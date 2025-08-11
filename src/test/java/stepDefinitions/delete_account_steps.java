package stepDefinitions;

import config.EndPoints;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import config.ApiConfig;
import core.SharedTestContext;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class delete_account_steps extends ApiConfig {
    private RequestSpecification reqDeleteSpec;
    private Response delRes;

    @Given("the user sets the Authorization header with a valid bearer token for deletion")
    public void the_user_sets_the_Authorization_header_with_a_valid_bearer_token_for_deletion() {
        System.out.println(SharedTestContext.getUserToken());
        reqDeleteSpec = given().header("Authorization", "Bearer " + SharedTestContext.getUserToken()).spec(getRequestSpecification());
    }

    @When("the user sends a HTTP {string} request to the delete endpoint {string}")
    public void the_user_sends_a_http_request_to_the_delete_endpoint(String HTTPMethod, String endpoint) {
        String apiResource = EndPoints.valueOf(endpoint).getPath();
        delRes = reqDeleteSpec.when().delete(apiResource).then().spec(getResponseSpecification()).extract().response();
    }

    @Then("the delete response body should contain {string} as {string}")
    public void the_delete_response_body_should_contain_as(String key, String expectedValue) {
        String actualValue = delRes.jsonPath().getString(key);
        assertEquals(actualValue, expectedValue);
    }
}
