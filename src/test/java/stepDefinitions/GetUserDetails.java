package stepDefinitions;

import constants.EndPoints;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import models.TestDataStore;
import responseModels.GetUserDetailsResponse;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.*;
import static stepDefinitions.SpecificationConfig.getRequestSpec;

public class GetUserDetails {
    private final TestDataStore testData;

    public GetUserDetails(TestDataStore testData){
        this.testData = testData;
    }
    RequestSpecification reqUserDetails;
    Response userDetailsRes;
    GetUserDetailsResponse getUserDetailsResponse;

    @Given("the user sets the {string} header with a valid bearer token")
    public void the_user_sets_the_header_with_a_valid_bearer_token(String auth) {
        reqUserDetails = given().header(auth, "Bearer " + AuthTokenContext.getToken()).spec(getRequestSpec());
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
    @Then("the response body should contain valid patient profile details")
    public void the_response_body_should_contain_valid_patient_profile_details() {
        assertEquals(testData.getPatientProfile().getFirstAndMiddleName(), getUserDetailsResponse.getData().getUserProfile().getFirstName());
        assertEquals(testData.getPatientProfile().getLastName(), getUserDetailsResponse.getData().getUserProfile().getLastName());
        assertEquals(testData.getPatientProfile().getDateOfBirth(), getUserDetailsResponse.getData().getUserProfile().getDateOfBirth());
        assertEquals(testData.getPatientProfile().getGender(), getUserDetailsResponse.getData().getUserProfile().getGender());
        assertEquals(testData.getPatientProfile().getCountryCode(), getUserDetailsResponse.getData().getUserProfile().getCountryCode());
        assertEquals(testData.getPatientProfile().getHnNumber(), getUserDetailsResponse.getData().getUserProfile().getHnNumber());
        assertEquals(testData.getPatientProfile().getPhoneNumber(), getUserDetailsResponse.getData().getUserProfile().getPhoneNumber());
        assertEquals(testData.getPatientProfile().getEmail(), getUserDetailsResponse.getData().getUserProfile().getEmail());
    }
    @Then("all required verification flags should be present and boolean")
    public void all_required_verification_flags_should_be_present_and_boolean() {
        assertFalse(getUserDetailsResponse.getData().getUserProfile().getIsHNVerified()); //first time after signUp
    }
}
