package hooks;

import com.fasterxml.jackson.databind.ObjectMapper;
import constants.EndPoints;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.restassured.response.Response;
import utils.PatientProfile;
import utils.SharedTestContext;

import java.io.File;
import java.io.IOException;

import static io.restassured.RestAssured.given;
import static utils.ApiConfig.getRequestSpecification;
import static utils.ApiConfig.getResponseSpecification;

public class Hooks {

    PatientProfile profile;


    @Before
    public void loadUserData() throws IOException {
        profile = new ObjectMapper().readValue(new File("src/test/resources/testData/signup_withoutHN_patient_profile.json"), PatientProfile.class);
        SharedTestContext.setPatientProfile(profile);
        System.out.println("Data loaded to PatientProfile obj");
    }

    @Before("@requireUser")
    public void setupUser() throws IOException {
        String preCheckPath = EndPoints.USER_SIGN_UP_PRE_CHECK.getPath();
        Response preCheckResponse = given()
                .spec(getRequestSpecification())
                .body(profile)
                .when().post(preCheckPath)
                .then().extract().response();

        if (preCheckResponse.getStatusCode() == 400) {
            login(profile);
            System.out.println("User already exists, Logged in");
        } else {
            Response signUpResponse = given()
                    .spec(getRequestSpecification())
                    .body(profile)
                    .when().post(EndPoints.USER_SIGN_UP.getPath())
                    .then().spec(getResponseSpecification())
                    .extract().response();

            SharedTestContext.setToken(signUpResponse.jsonPath().getString("data.token"));
            SharedTestContext.setUserId(signUpResponse.jsonPath().getString("data.user._id"));
            System.out.println("New user created");
        }
    }

    private void login(PatientProfile profile) {
        Response loginResponse = given()
                .spec(getRequestSpecification())
                .body(profile)
                .when().post(EndPoints.USER_LOGIN.getPath())
                .then().spec(getResponseSpecification())
                .extract().response();

        SharedTestContext.setToken(loginResponse.jsonPath().getString("data.token"));
        SharedTestContext.setUserId(loginResponse.jsonPath().getString("data.user._id"));
    }

    @After("@cleanUp")
    public void tearDown() {
        String deletePath = EndPoints.USER_DELETE.getPath();
        System.out.println(SharedTestContext.getToken());
        Response deleteResponse = given()
                .header("Authorization", "Bearer " + SharedTestContext.getToken())
                .spec(getRequestSpecification())
                .when().delete(deletePath)
                .then().spec(getResponseSpecification())
                .extract().response();
        System.out.println("Clean up done");
    }
}
