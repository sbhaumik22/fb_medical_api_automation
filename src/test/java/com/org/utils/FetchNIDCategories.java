package com.org.utils;

import com.SharedTestContext;
import com.org.constants.EndPoints;
import io.restassured.response.Response;
import com.org.responseModels.Category;
import com.org.responseModels.GetNIDCategoriesResponse;

import java.util.List;

import static io.restassured.RestAssured.given;

public class FetchNIDCategories extends ApiConfig {
    public static String getNIDCategoryId(String categoryTitle) {
        String getNationalCategoriesPath = EndPoints.GET_NATIONAL_CATEGORIES.getPath();
        Response getNationalCategories = given()
                .header("Authorization", "Bearer " + SharedTestContext.getUserToken())
                .spec(getRequestSpecification())
                .when().get(getNationalCategoriesPath)
                .then().spec(getResponseSpecification()).extract().response();

        GetNIDCategoriesResponse nidCategories = getNationalCategories.as(GetNIDCategoriesResponse.class);
        List<Category> categoryList = nidCategories.getData().getCategories();
        String categoryId = null;
        for (Category category : categoryList) {
            if (category.getTitle().equalsIgnoreCase(categoryTitle)) {
                categoryId = category.get_id();
                break;
            }
        }
        return categoryId;
    }
}