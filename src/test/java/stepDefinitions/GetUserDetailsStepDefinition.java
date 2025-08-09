package stepDefinitions;

import constants.EndPoints;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import responseModels.GetUserDetailsResponse;
import utils.SharedTestContext;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static utils.ApiConfig.getRequestSpecification;

public class GetUserDetailsStepDefinition {
    RequestSpecification reqUserDetails;
    Response userDetailsRes;
    GetUserDetailsResponse getUserDetailsResponse;

    @Given("the user sets the {string} header with a valid bearer token")
    public void the_user_sets_the_header_with_a_valid_bearer_token(String auth) {
        reqUserDetails = given().header(auth, "Bearer " + SharedTestContext.getToken()).spec(getRequestSpecification());
    }

    @When("the user sends a HTTP {string} request to the get details endpoint {string}")
    public void the_user_sends_a_http_request_to_the_get_details_endpoint(String HTTPMethod, String endpoint) {
        String apiResource = EndPoints.valueOf(endpoint).getPath();
        userDetailsRes = reqUserDetails.when().get(apiResource).then().extract().response();
    }

    @Then("the get details response body should contain {string} as {string}")
    public void the_get_details_response_body_should_contain_as(String key, String expectedValue) {
        getUserDetailsResponse = userDetailsRes.as(GetUserDetailsResponse.class);
        String actualValue = getUserDetailsResponse.getStatus();
        assert expectedValue.equals(actualValue) : "Expected value is " + expectedValue + " but found " + actualValue;
    }

    @And("the response body should contain valid patient profile details")
    public void the_response_body_should_contain_valid_patient_profile_details() {
        assertEquals(SharedTestContext.getPatientProfile().getFirstAndMiddleName(), getUserDetailsResponse.getData().getUserProfile().getFirstName());
        assertEquals(SharedTestContext.getPatientProfile().getLastName(), getUserDetailsResponse.getData().getUserProfile().getLastName());
//        assertEquals(SharedTestContext.getPatientProfile().getDateOfBirth(), getUserDetailsResponse.getData().getUserProfile().getDateOfBirth());
        assertEquals(SharedTestContext.getPatientProfile().getGender(), getUserDetailsResponse.getData().getUserProfile().getGender());
        assertEquals(SharedTestContext.getPatientProfile().getCountryCode(), getUserDetailsResponse.getData().getUserProfile().getCountryCode());
//        assertEquals(SharedTestContext.getPatientProfile().getHnNumber(), getUserDetailsResponse.getData().getUserProfile().getHnNumber());
        assertEquals(SharedTestContext.getPatientProfile().getPhoneNumber(), getUserDetailsResponse.getData().getUserProfile().getPhoneNumber());
        assertEquals(SharedTestContext.getPatientProfile().getEmail(), getUserDetailsResponse.getData().getUserProfile().getEmail());
    }

    @And("all required verification flags should be present and boolean")
    public void all_required_verification_flags_should_be_present_and_boolean() {
        assertFalse(getUserDetailsResponse.getData().getUserProfile().getIsHNVerified()); //first time after signUp
    }

    @And("get the relative id of the user")
    public void get_the_relative_id_of_the_user() {

    }
}
