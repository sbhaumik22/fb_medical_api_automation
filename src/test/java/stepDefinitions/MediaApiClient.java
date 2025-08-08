package stepDefinitions;

import constants.EndPoints;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import responseModels.MediaUploadResponse;

import java.io.File;
import java.util.List;

public class MediaApiClient extends BaseStepDefinition {
    public static List<String> getUserMediaLink(File mediaFile){
        String apiResource = EndPoints.valueOf("USER_UPLOAD_MEDIA").getPath();
        Response response = RestAssured
                .given()
                .baseUri(environments.getBaseUri())
                .header("Authorization", "Bearer " +  AuthTokenContext.getToken())
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
