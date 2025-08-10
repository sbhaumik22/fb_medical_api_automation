package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class verify_profile_steps {
    @Given("the user provides personal information including address, photo ID, and insurance details")
    public void the_user_provides_personal_information_including_address_photo_id_and_insurance_details() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("the user submits a HTTP {string} request to the profile details endpoint {string}")
    public void the_user_submits_a_http_request_to_the_profile_details_endpoint(String string, String string2) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("the API response status should be {string}")
    public void the_api_response_status_should_be(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("the response body should include valid verification request details with request status set to {string}")
    public void the_response_body_should_include_valid_verification_request_details_with_request_status_set_to(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("retrieve the profile verification request from the CMD system using the requestId")
    public void retrieve_the_profile_verification_request_from_the_cmd_system_using_the_request_id() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("validate that the CMD-side request data matches the patient-side submission")
    public void validate_that_the_cmd_side_request_data_matches_the_patient_side_submission() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("verify the Hospital Number \\(HN) assignment process and generate a unique HN")
    public void verify_the_hospital_number_hn_assignment_process_and_generate_a_unique_hn() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("confirm that post-verification, the profile status reflects isHNVerified as {string}")
    public void confirm_that_post_verification_the_profile_status_reflects_is_hn_verified_as(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("ensure the assigned HN matches the admin-provided HN value")
    public void ensure_the_assigned_hn_matches_the_admin_provided_hn_value() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

}
