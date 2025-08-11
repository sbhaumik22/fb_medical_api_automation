package com.org.api.stepDefinitions;

import com.org.constants.EndPoints;
import com.org.requestPayloads.*;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import com.org.responseModels.CreateProfileVerificationResponse;
import com.org.utils.ApiConfig;
import com.org.utils.JsonUtil;
import com.SharedTestContext;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static com.org.utils.FetchNIDCategories.getNIDCategoryId;

public class verify_profile_steps extends ApiConfig {
    CreateProfileVerificationRequestPayload createProfileVerificationRequestPayload;
    PersonalInfo personalInfo;
    Address address;
    NationalIdentity nationalIdentity;
    List<Insurance> insurances;
    RequestSpecification createProfileVerificationRequestSpec;
    RequestSpecification getAllInfoAboutRequestSpec;
    CreateProfileVerificationResponse createProfileVerificationRequestResponse;

    @Given("a user has signed up without an HN")
    public void a_user_has_signed_up_without_an_hn() {
        createProfileVerificationRequestSpec = given().header("Authorization", "Bearer " + SharedTestContext.getUserToken()).spec(getRequestSpecification());
        getAllInfoAboutRequestSpec = given().header("Authorization", "Bearer " + SharedTestContext.getAdminToken()).spec(getRequestSpecification());
    }

    @Given("the user provides personal information:")
    public void the_user_provides_personal_information(DataTable dataTable) {
        Map<String, String> personalDetails = dataTable.asMaps(String.class, String.class).get(0);
        personalInfo = new PersonalInfo();
        personalInfo.setFirstName(personalDetails.get("firstName"));
        personalInfo.setLastName(personalDetails.get("lastName"));
        personalInfo.setGender(personalDetails.get("gender"));
        personalInfo.setDateOfBirth(personalDetails.get("dateOfBirth"));
        personalInfo.setCountryCode(personalDetails.get("countryCode"));
        personalInfo.setPhoneNumber(personalDetails.get("phoneNumber"));
        personalInfo.setEmail(personalDetails.get("email"));
        personalInfo.setProfilePhoto(personalDetails.get("profilePhoto"));
        personalInfo.setRelation(personalDetails.get("relation"));
    }

    @Given("the user provides current address details")
    public void the_user_provides_current_address_details(DataTable dataTable) {
        Map<String, String> addressDetails = dataTable.asMaps(String.class, String.class).get(0);
        address = new Address();
        address.setPersonalCountryCode(addressDetails.get("personalCountryCode"));
        address.setPersonalPhoneNumber(addressDetails.get("personalPhoneNumber"));
        address.setOfficeCountryCode(addressDetails.get("officeCountryCode"));
        address.setOfficePhoneNumber(addressDetails.get("officePhoneNumber"));
        address.setStreet(addressDetails.get("street"));
        address.setWard(addressDetails.get("ward"));
        address.setDistrict(addressDetails.get("district"));
        address.setPostalCode(addressDetails.get("postalCode"));
        address.setCity(addressDetails.get("city"));
        address.setProvince(addressDetails.get("province"));
        address.setSaveAs(addressDetails.get("saveAs"));
    }

    @Given("the user provides photo ID details with category title as {string}")
    public void the_user_provides_photo_id_details_with_category_title_as(String categoryTitle, io.cucumber.datatable.DataTable dataTable) {
        nationalIdentity = new NationalIdentity();
        Map<String, String> nationalIDDetails = dataTable.asMaps(String.class, String.class).get(0);
        Images images = new Images();
        images.setBack(nationalIDDetails.get("back"));
        images.setFront(nationalIDDetails.get("front"));
        nationalIdentity.setImages(images);
        nationalIdentity.setCategory(getNIDCategoryId(categoryTitle));
        nationalIdentity.setNumber(nationalIDDetails.get("number"));
        System.out.println(nationalIdentity.getCategory());
    }

    @Given("the user provides insurance details")
    public void the_user_provides_insurance_details(io.cucumber.datatable.DataTable dataTable) {
        Map<String, String> insuranceDetails = dataTable.asMaps(String.class, String.class).get(0);
        Insurance insurance = new Insurance();
        insurance.setCompany(insuranceDetails.get("company"));
        insurance.setImage(insuranceDetails.get("image"));
        insurances = new ArrayList<>();
        insurances.add(insurance);
    }

    @When("the user submits a {string} request to endpoint {string} and store all verification request details from the response")
    public void the_user_submits_a_request_to_endpoint_and_store_all_verification_request_details_from_the_response(String HTTPMethod, String endpoint) {
        String createProfileVerificationRequestPath = EndPoints.valueOf(endpoint).getPath();
        createProfileVerificationRequestPayload = new CreateProfileVerificationRequestPayload();
        createProfileVerificationRequestPayload.setPersonalInfo(personalInfo);
        createProfileVerificationRequestPayload.setAddress(address);
        createProfileVerificationRequestPayload.setNationalIdentity(nationalIdentity);
        createProfileVerificationRequestPayload.setInsurances(insurances);
        String jsonPayload = JsonUtil.toJson(createProfileVerificationRequestPayload);
        System.out.println(jsonPayload);

        Response response = createProfileVerificationRequestSpec.body(createProfileVerificationRequestPayload).when().post(createProfileVerificationRequestPath).then().spec(getResponseSpecification()).extract().response();
        createProfileVerificationRequestResponse = response.as(CreateProfileVerificationResponse.class);
        SharedTestContext.setRelativeId(createProfileVerificationRequestResponse.getData().getRequest().getRelative());
    }

    @Then("the response status should be {string}")
    public void the_response_status_should_be(String expectedStatus) {
        assertEquals(expectedStatus, createProfileVerificationRequestResponse.getStatus());
    }

    @Then("the verification request status should be {string}")
    public void the_verification_request_status_should_be(String expectedRequestStatus) {
        assertEquals(expectedRequestStatus, createProfileVerificationRequestResponse.getData().getRequest().getStatus());
    }

    @Then("the system retrieves the verification request from CMD using the stored requestId")
    public void the_system_retrieves_the_verification_request_from_cmd_using_the_stored_request_id() {
        String getReqInfoPath = EndPoints.GET_ALL_INFO_ABOUT_REQUEST.getPath();
//        getAllInfoAboutRequestSpec.when().get(getReqInfoPath).then().extract().response();

    }

    @Then("CMD request data should match the patient-side submission")
    public void cmd_request_data_should_match_the_patient_side_submission() {

    }

    @Then("the system assigns a unique Hospital Number")
    public void the_system_assigns_a_unique_hospital_number() {

    }

    @Then("the profile is marked as verified")
    public void the_profile_is_marked_as_verified() {

    }

    @Then("the profile status should have isHNVerified as {string}")
    public void the_profile_status_should_have_is_hn_verified_as(String string) {

    }

    @Then("the assigned HN should match the admin-provided HN")
    public void the_assigned_hn_should_match_the_admin_provided_hn() {

    }
}
