package clients;

import config.ApiConfig;
import config.EndPoints;
import config.Environments;
import core.SharedTestContext;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import models.responses.MediaUploadResponse;

import java.io.File;
import java.util.List;

public class MediaApiClient extends ApiConfig {
    public static List<String> getUserMediaLink(File mediaFile) {
        String environmentPath = Environments.DEV.getBaseUri();
        String apiResource = EndPoints.valueOf("USER_UPLOAD_MEDIA").getPath();
        Response response = RestAssured
                .given()
                .baseUri(environmentPath)
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