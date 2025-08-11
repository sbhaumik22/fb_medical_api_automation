package core;

import com.fasterxml.jackson.databind.ObjectMapper;
import config.EndPoints;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.io.File;
import java.io.IOException;

import static config.ApiConfig.getRequestSpecification;
import static config.ApiConfig.getResponseSpecification;

public class Hooks {

    PatientProfile profile;


    @Before(order = 1)
    public void loadUserData() throws IOException {
        profile = new ObjectMapper().readValue(new File("src/test/resources/testData/signup_withoutHN_patient_profile.json"), PatientProfile.class);
        SharedTestContext.setPatientProfile(profile);
        SharedTestContext.setAdminToken("");
        System.out.println("Data loaded to PatientProfile object with phone number: " + profile.getPhoneNumber());


    }

    @Before("@requireUser")
    public void setupUser() throws IOException {
        String preCheckPath = EndPoints.USER_SIGN_UP_PRE_CHECK.getPath();
        Response preCheckResponse = RestAssured.given()
                .spec(getRequestSpecification())
                .body(profile)
                .when().post(preCheckPath)
                .then().extract().response();

        System.out.println("--------------------------------------Sign up pre check is done--------------------------------------");
        System.out.println("Status code: " + preCheckResponse.getStatusCode());
        try {
            System.out.println("Message: " + preCheckResponse.jsonPath().getString("message"));
        } catch (Exception e) {
            System.out.println(e);
        }

        if (preCheckResponse.getStatusCode() == 400) {
            System.out.println("--------------------------------------Invoking login request--------------------------------------");
            login(profile);
            System.out.println("--------------------------------------Logged in--------------------------------------");
        } else if (preCheckResponse.getStatusCode() == 200) {
            System.out.println("--------------------------------------No active account found! Invoking Sign up request--------------------------------------");
            Response signUpResponse = RestAssured.given()
                    .spec(getRequestSpecification())
                    .body(profile)
                    .when().post(EndPoints.USER_SIGN_UP.getPath())
                    .then().spec(getResponseSpecification())
                    .extract().response();

            SharedTestContext.setUserToken(signUpResponse.jsonPath().getString("data.token"));
            SharedTestContext.setUserId(signUpResponse.jsonPath().getString("data.user._id"));
            System.out.println("--------------------------------------Signed up, New user created--------------------------------------");
        } else {
            System.out.println("--------------------------Unknown Error--------------------------");
        }
    }

    private void login(PatientProfile profile) {
        Response loginResponse = RestAssured.given()
                .spec(getRequestSpecification())
                .body(profile)
                .when().post(EndPoints.USER_LOGIN.getPath())
                .then().spec(getResponseSpecification())
                .extract().response();

        SharedTestContext.setUserToken(loginResponse.jsonPath().getString("data.token"));
        SharedTestContext.setUserId(loginResponse.jsonPath().getString("data.user._id"));
    }

    @After("@cleanUp")
    public void tearDown() {
        String deletePath = EndPoints.USER_DELETE.getPath();
        System.out.println(SharedTestContext.getUserToken());
        System.out.println("--------------------------------------Invoking delete request--------------------------------------");
        Response deleteResponse = RestAssured.given()
                .header("Authorization", "Bearer " + SharedTestContext.getUserToken())
                .spec(getRequestSpecification())
                .when().delete(deletePath)
                .then().spec(getResponseSpecification())
                .extract().response();
        System.out.println("--------------------------------------Account deleted, Clean up done--------------------------------------");
    }
}
