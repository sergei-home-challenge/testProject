package com.freenow.tests;

import com.freenow.AppTest;
import com.freenow.testData.CommonSettings;
import io.restassured.response.ValidatableResponse;
import org.junit.Test;

import static com.freenow.utlis.Steps.getUserByName;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class SearchUserTest extends AppTest {

    @Test
    public void testSearchUserByName() {
        ValidatableResponse userSamantha = getUserByName(CommonSettings.TEST_USER);
        LOG.info("Json for the user:" + userSamantha.extract().asString());
    }

    @Test
    public void testUsersCheckJsonSchema() {
        ValidatableResponse userSamantha = getUserByName(CommonSettings.TEST_USER);
        userSamantha
                .assertThat()
                .body(matchesJsonSchemaInClasspath("usersResponse.json"));
    }
}
