package com.freenow.tests;

import com.freenow.AppTest;
import com.freenow.testData.CommonSettings;
import com.freenow.utlis.Specs;
import com.freenow.utlis.Steps;
import io.restassured.path.json.JsonPath;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.Test;

import static com.freenow.utlis.Steps.*;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.hasItems;

public class SearchUserTest extends AppTest {

    RequestSpecification requestSpec = Specs.getRequestSpec();
    ResponseSpecification responseSpec = Specs.getResponseSpec();

    @Test
    public void testSearchUserByName() {
        ValidatableResponse userSamantha = getUserByName("Samantha");
        LOG.info("Json for the user:" + userSamantha.extract().asString());
    }
}
