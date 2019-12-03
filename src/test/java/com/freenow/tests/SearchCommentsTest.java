package com.freenow.tests;

import com.freenow.AppTest;
import com.freenow.testData.CommonSettings;
import com.freenow.utlis.Steps;
import io.restassured.response.ValidatableResponse;
import org.apache.commons.validator.routines.EmailValidator;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static com.freenow.utlis.Steps.getPostsById;
import static com.freenow.utlis.Steps.getUserByName;
import static com.freenow.utlis.Steps.getValuesFromResponse;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class SearchCommentsTest extends AppTest {
    @Test
    public void testSearchComments() {
        ValidatableResponse user = getUserByName(CommonSettings.TEST_USER );
        Integer userId= getValuesFromResponse(user)
                .get(0)
                .intValue();

        ValidatableResponse userPosts= getPostsById(userId);
        ArrayList<Integer> userPostsIds = getValuesFromResponse(userPosts);

        for (Integer postId : userPostsIds) {
            ValidatableResponse comments = Steps
                    .getCommentsByPostId(postId);

            List<String> emails = comments
                    .extract()
                    .jsonPath()
                    .getList("email");

            LOG.info("Emails for postId: " + postId + " : " +emails);
        }
    }

    @Test
    public void testSearchCommentsAndValidateEmails() {
        ValidatableResponse user = getUserByName(CommonSettings.TEST_USER );
        Integer userId= getValuesFromResponse(user)
                .get(0)
                .intValue();

        ValidatableResponse userPosts= getPostsById(userId);
        ArrayList<Integer> userPostsIds = getValuesFromResponse(userPosts);

        for (Integer postId : userPostsIds) {
            ValidatableResponse comments = Steps
                    .getCommentsByPostId(postId);

            List<String> emails = comments
                    .extract()
                    .jsonPath()
                    .getList("email");

            LOG.info("Emails for postId: " + postId + " : " +emails);

            for (String e : emails) {
                EmailValidator eValidator = EmailValidator.getInstance();
                if (eValidator.isValid(e)) {
                    LOG.info(e + " is valid email address.");
                } else {
                    throw new AssertionError("Incorrect email: " +
                            e + " in a post with id " + postId);
                }
            }
        }
    }

    @Test
    public void testSearchCommentsAndValidateSchema() {
        ValidatableResponse user = getUserByName(CommonSettings.TEST_USER);
        Integer userId = getValuesFromResponse(user)
                .get(0)
                .intValue();

        ValidatableResponse userPosts = getPostsById(userId);
        userPosts.assertThat()
                .body(matchesJsonSchemaInClasspath("postsResponse.json"));
    }

}