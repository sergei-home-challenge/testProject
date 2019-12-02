package com.freenow.tests;

import com.freenow.AppTest;
import com.freenow.testData.CommonSettings;
import io.restassured.response.ValidatableResponse;
import org.junit.Test;

import static com.freenow.utlis.Steps.getUserByName;

public class SearchUserTest extends AppTest {

    @Test
    public void testSearchUserByName() {
        ValidatableResponse userSamantha = getUserByName(CommonSettings.TEST_USER);
        LOG.info("Json for the user:" + userSamantha.extract().asString());
    }
}
