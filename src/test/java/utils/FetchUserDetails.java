package utils;

import constants.EndPoints;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import responseModels.GetUserDetailsResponse;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class FetchUserDetails {
    RequestSpecification reqUserDetails;
    Response userDetailsRes;
    GetUserDetailsResponse getUserDetailsResponse;

    public GetUserDetailsResponse getUserDetails(String token, String relative) {
        String apiResource = EndPoints.USER_DETAILS.getPath();
        reqUserDetails = given().header("Authorization", "Bearer " + token);
        if (relative != null && !relative.isEmpty()) {
            reqUserDetails.queryParam("relative", relative);
        }
        userDetailsRes = reqUserDetails.when().get(apiResource).then().extract().response();
        assertEquals("success", userDetailsRes.jsonPath().getString("status"));
        return userDetailsRes.as(GetUserDetailsResponse.class);
    }
}
