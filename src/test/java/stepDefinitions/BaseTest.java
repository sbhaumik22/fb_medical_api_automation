package stepDefinitions;

import constants.Environments;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class BaseTest {
    String JWTToken;
    RequestSpecification requestSpecification;
    ResponseSpecification responseSpecification;
    static Environments environments = Environments.valueOf("DEV");
    public static RequestSpecification getRequestSpec(){
        return new RequestSpecBuilder()
                .setBaseUri(environments.getBaseUri())
                .setContentType("application/json")
                .build();
    }

    public static ResponseSpecification getResponseSpecification(){
        return new ResponseSpecBuilder()
                .expectContentType("application/json")
                .expectStatusCode(200)
                .build();
    }
}
