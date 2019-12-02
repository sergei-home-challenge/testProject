package com.freenow.tests;

import com.freenow.AppTest;
import com.freenow.testData.CommonSettings;
import com.freenow.utlis.Specs;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.Matchers.not;

public class SearchUserTest extends AppTest {

    RequestSpecification requestSpec = Specs.getRequestSpec();
    ResponseSpecification responseSpec = Specs.getResponseSpec();

    //TEST WILL FAIL
    //ADDED TO SEE HOW WILL IT WORK IN CIRCLECI
    @Test
    public void testThatFails() {
        ValidatableResponse user = given()
                .params("username", "Samantha")
                .spec(requestSpec)
                .when()
                .get(CommonSettings.USERS_ENDPOINT)
                .then()
                .spec(responseSpec)
                .assertThat()
                .body("username", hasItems("NotSamantha"));
    }

    @Test
    public void testSearchSamantha() {
        ValidatableResponse user = given()
                .params("username", "Samantha")
                .spec(requestSpec)
                .when()
                .get(CommonSettings.USERS_ENDPOINT)
                .then()
                .spec(responseSpec)
                .assertThat()
                .body("username", hasItems("Samantha"));
    }
}
