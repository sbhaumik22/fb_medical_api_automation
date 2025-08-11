package com.org.utils;

import com.org.constants.EndPoints;
import com.org.responseModels.GetUserDetailsResponse;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class FetchUserDetails extends ApiConfig {
    public static GetUserDetailsResponse getUserDetails(String token, String relative) {
        RequestSpecification reqUserDetails = given().header("Authorization", "Bearer " + token);
        if (relative != null && !relative.isEmpty()) {
            reqUserDetails.queryParam("relative", relative);
        }
        Response userDetailsRes = reqUserDetails.spec(getRequestSpecification()).when().get(EndPoints.USER_DETAILS.getPath()).then().extract().response();
        return userDetailsRes.as(GetUserDetailsResponse.class);
    }
}
