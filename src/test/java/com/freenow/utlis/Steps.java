package com.freenow.utlis;

import com.freenow.testData.CommonSettings;
import io.restassured.path.json.JsonPath;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import java.util.ArrayList;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.hasItems;

public class Steps {
    static RequestSpecification requestSpec = Specs.getRequestSpec();
    static ResponseSpecification responseSpec = Specs.getResponseSpec();

    public static ValidatableResponse getUserByName(String userName) {
        ValidatableResponse user = given()
                .params("username", "Samantha")
                .spec(requestSpec)
                .when()
                .get(CommonSettings.USERS_ENDPOINT)
                .then()
                .spec(responseSpec)
                .assertThat()
                .body("username", hasItems("Samantha"));
        return user;
    }

    public static ValidatableResponse getPostsById (Integer userId) {
        ValidatableResponse posts= given()
                .params("userId", userId)
                .spec(requestSpec)
                .when().get(CommonSettings.POSTS_ENDPOINT)
                .then()
                .spec(responseSpec);
        return posts;
    }

    public static ValidatableResponse getCommentsByPostId (Integer postId) {
        ValidatableResponse posts= given()
                .params("postId", postId)
                .spec(requestSpec)
                .when().get(CommonSettings.COMMENTS_ENDPOINT)
                .then()
                .spec(responseSpec);
        return posts;
    }

    public static ArrayList<Integer> getValuesFromResponse(ValidatableResponse response) {
        ArrayList<Integer> responseIds = JsonPath.from(
                response.extract()
                        .asString())
                .get("id");
        return responseIds;
    }
}
