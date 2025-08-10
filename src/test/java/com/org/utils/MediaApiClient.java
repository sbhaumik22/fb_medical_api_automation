package com.org.utils;

import com.SharedTestContext;
import com.org.constants.EndPoints;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import com.org.responseModels.MediaUploadResponse;

import java.io.File;
import java.util.List;

public class MediaApiClient extends ApiConfig {
    public static List<String> getUserMediaLink(File mediaFile) {
        String apiResource = EndPoints.valueOf("USER_UPLOAD_MEDIA").getPath();
        Response response = RestAssured
                .given()
                .baseUri(environments.getBaseUri())
                .header("Authorization", "Bearer " + SharedTestContext.getUserToken())
                .multiPart("files", mediaFile)
                .when()
                .post(apiResource)
                .then()
                .spec(getResponseSpecification())
                .extract()
                .response();
        MediaUploadResponse mediaUploadResponse = response.as(MediaUploadResponse.class);
        return mediaUploadResponse.getData().getUrls();
    }
}