package com.org.api.stepDefinitions;

import com.SharedTestContext;
import com.org.constants.EndPoints;
import com.org.requestPayloads.*;
import com.org.responseModels.CreateProfileVerificationResponse;
import com.org.responseModels.GetAllInfoAboutRequestResponse;
import com.org.responseModels.GetUserDetailsResponse;
import com.org.responseModels.VerifyHNNumberResponse;
import com.org.utils.ApiConfig;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.org.utils.FetchNIDCategories.getNIDCategoryId;
import static com.org.utils.FetchUserDetails.getUserDetails;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class verify_profile_steps extends ApiConfig {
    RequestSpecification createProfileVerificationRequestSpec;
    RequestSpecification getAllInfoAboutRequestSpec;

    CreateProfileVerificationRequestPayload createProfileVerificationRequestPayload;
    VerifyHNNumberRequestPayload verifyHNNumberRequestPayload;
    VerifyPersonalInfo verifyPersonalInfo;
    CreatePersonalInfo createPersonalInfo;
    Address address;
    NationalIdentity nationalIdentity;
    List<Insurance> insurances;

    CreateProfileVerificationResponse createProfileVerificationRequestResponse;
    GetAllInfoAboutRequestResponse getAllInfoAboutRequestResponse;
    VerifyHNNumberResponse verifyHNNumberResponse;

    String hnVerificationRequestId;
    String relativeId;

    @Given("a user has signed up without an HN")
    public void a_user_has_signed_up_without_an_hn() {
        createProfileVerificationRequestSpec = given().header("Authorization", "Bearer " + SharedTestContext.getUserToken()).spec(getRequestSpecification());
    }

    @Given("the user provides personal information:")
    public void the_user_provides_personal_information(DataTable dataTable) {
        Map<String, String> personalDetails = dataTable.asMaps(String.class, String.class).get(0);
        createPersonalInfo = new CreatePersonalInfo();
        createPersonalInfo.setFirstName(personalDetails.get("firstName"));
        createPersonalInfo.setLastName(personalDetails.get("lastName"));
        createPersonalInfo.setGender(personalDetails.get("gender"));
        createPersonalInfo.setDateOfBirth(personalDetails.get("dateOfBirth"));
        createPersonalInfo.setCountryCode(personalDetails.get("countryCode"));
        createPersonalInfo.setPhoneNumber(personalDetails.get("phoneNumber"));
        createPersonalInfo.setEmail(personalDetails.get("email"));
        createPersonalInfo.setProfilePhoto(personalDetails.get("profilePhoto"));
        createPersonalInfo.setRelation(personalDetails.get("relation"));
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
        createProfileVerificationRequestPayload.setPersonalInfo(createPersonalInfo);
        createProfileVerificationRequestPayload.setAddress(address);
        createProfileVerificationRequestPayload.setNationalIdentity(nationalIdentity);
        createProfileVerificationRequestPayload.setInsurances(insurances);

        Response response = createProfileVerificationRequestSpec.body(createProfileVerificationRequestPayload).when().post(createProfileVerificationRequestPath).then().spec(getResponseSpecification()).extract().response();
        createProfileVerificationRequestResponse = response.as(CreateProfileVerificationResponse.class);
        hnVerificationRequestId = createProfileVerificationRequestResponse.getData().getRequest().get_id();
        relativeId = createProfileVerificationRequestResponse.getData().getRequest().getRelative();
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
        String getReqInfoPath = EndPoints.GET_ALL_INFO_ABOUT_REQUEST.getPath() + "/" + hnVerificationRequestId;
        getAllInfoAboutRequestSpec = given()
                .header("Authorization", "Bearer " + SharedTestContext.getAdminToken())
                .spec(getRequestSpecification());
        Response response = getAllInfoAboutRequestSpec
                .when()
                .get(getReqInfoPath)
                .then().extract().response();
        getAllInfoAboutRequestResponse = response.as(GetAllInfoAboutRequestResponse.class);
    }

    @Then("CMD request data should match the patient-side submission")
    public void cmd_request_data_should_match_the_patient_side_submission() {
        assertEquals(createProfileVerificationRequestPayload.getPersonalInfo().getEmail(), getAllInfoAboutRequestResponse.getData().getUserProfile().getEmail());
        assertEquals(createProfileVerificationRequestPayload.getPersonalInfo().getPhoneNumber(), getAllInfoAboutRequestResponse.getData().getUserProfile().getPhoneNumber());
        assertEquals(createProfileVerificationRequestPayload.getAddress().getStreet(), getAllInfoAboutRequestResponse.getData().getHnVerificationOpenRequest().getUserAddress().getStreet());
        assertEquals(createProfileVerificationRequestPayload.getNationalIdentity().getNumber(), getAllInfoAboutRequestResponse.getData().getHnVerificationOpenRequest().getNationalId().getNumber());
        assertEquals(createProfileVerificationRequestPayload.getInsurances().get(0).getCompany(), getAllInfoAboutRequestResponse.getData().getHnVerificationOpenRequest().getInsurance().get(0).getInsurance().getCompany());
    }

    @Then("assign admin to the verification request")
    public void assign_admin_to_the_verification_request() {
        String putReqInfoPath = EndPoints.VERIFY_PERSONAL_INFO_BY_REQUEST_ID.getPath() + "/" + hnVerificationRequestId;
        given()
                .header("Authorization", "Bearer " + SharedTestContext.getAdminToken())
                .spec(getRequestSpecification())
                .when().put(putReqInfoPath)
                .then().spec(getResponseSpecification());
    }

    @Then("the admin assigns a unique Hospital Number")
    public void the_admin_assigns_a_unique_hospital_number(DataTable dataTable) {
        Map<String, String> personalInfoDetail = dataTable.asMaps(String.class, String.class).get(0);
        verifyHNNumberRequestPayload = new VerifyHNNumberRequestPayload();
        verifyPersonalInfo = new VerifyPersonalInfo();
        verifyPersonalInfo.setId(relativeId);
        verifyPersonalInfo.setFirstName(personalInfoDetail.get("firstName"));
        verifyPersonalInfo.setLastName(personalInfoDetail.get("lastName"));
        verifyPersonalInfo.setGender(personalInfoDetail.get("gender"));
        verifyPersonalInfo.setDateOfBirth(personalInfoDetail.get("dateOfBirth"));
        verifyPersonalInfo.setEmail(personalInfoDetail.get("email"));
        verifyPersonalInfo.setCountryCode(personalInfoDetail.get("countryCode"));
        verifyPersonalInfo.setPhoneNumber(personalInfoDetail.get("phoneNumber"));
        verifyPersonalInfo.setInsuranceCategory(personalInfoDetail.get("insuranceCategory"));
        verifyPersonalInfo.setHnNumber(personalInfoDetail.get("hnNumber"));

        verifyHNNumberRequestPayload.setPersonalInfo(verifyPersonalInfo);
        verifyHNNumberRequestPayload.setAddress(address);
        verifyHNNumberRequestPayload.setNationalIdentity(nationalIdentity);
        verifyHNNumberRequestPayload.setInsurances(insurances);

        System.out.println(hnVerificationRequestId);

        String verifyHnNumberPath = EndPoints.VERIFY_HN_NUMBER.getPath() + "/" + hnVerificationRequestId;
        Response response = given()
                .header("Authorization", "Bearer " + SharedTestContext.getAdminToken())
                .spec(getRequestSpecification())
                .body(verifyHNNumberRequestPayload)
                .when().post(verifyHnNumberPath)
                .then().spec(getResponseSpecification()).extract().response();
        verifyHNNumberResponse = response.as(VerifyHNNumberResponse.class);
    }

    @Then("the profile status should have isHNVerified")
    public void the_profile_status_should_have_is_hn_verified() {
        assertTrue(verifyHNNumberResponse.getData().getUser().getIsHNVerified());
        assertTrue(verifyHNNumberResponse.getData().getUser().getIsActive());
    }

    @Then("check the profile is marked as verified using GetProfileRequest using relativeId and the assigned HN should match the admin-provided HN")
    public void check_the_profile_is_marked_as_verified_using_get_profile_request_using_relative_id_and_the_assigned_hn_should_match_the_admin_provided_hn() {
        GetUserDetailsResponse relativeDetails = getUserDetails(SharedTestContext.getUserToken(), relativeId);
        assertTrue(relativeDetails.getData().getUserProfile().getIsHNVerified());
        assertEquals(verifyHNNumberRequestPayload.getPersonalInfo().getHnNumber(), relativeDetails.getData().getHnVerificationOpenRequest().getRelative().getHnNumber());
    }
}
