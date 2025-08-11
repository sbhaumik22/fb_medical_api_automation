package utils;

import config.EndPoints;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import models.responses.GetUserDetailsResponse;

import static org.junit.Assert.assertEquals;

public class FetchUserDetails {
    RequestSpecification reqUserDetails;
    Response userDetailsRes;
    GetUserDetailsResponse getUserDetailsResponse;

    public GetUserDetailsResponse getUserDetails(String token, String relative) {
        String apiResource = EndPoints.USER_DETAILS.getPath();
        reqUserDetails = RestAssured.given().header("Authorization", "Bearer " + token);
        if (relative != null && !relative.isEmpty()) {
            reqUserDetails.queryParam("relative", relative);
        }
        userDetailsRes = reqUserDetails.when().get(apiResource).then().extract().response();
        assertEquals("success", userDetailsRes.jsonPath().getString("status"));
        return userDetailsRes.as(GetUserDetailsResponse.class);
    }
}
