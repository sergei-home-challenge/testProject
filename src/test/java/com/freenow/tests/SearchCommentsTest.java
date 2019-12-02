package com.freenow.tests;

import com.freenow.AppTest;
import com.freenow.utlis.Steps;
import io.restassured.response.ValidatableResponse;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static com.freenow.utlis.Steps.getPostsById;
import static com.freenow.utlis.Steps.getValuesFromResponse;
import static com.freenow.utlis.Steps.getUserByName;

public class SearchCommentsTest extends AppTest {

    @Test
    public void testSearchComments() {
        ValidatableResponse user = getUserByName("Samantha");
        Integer userId= getValuesFromResponse(user)
                .get(0)
                .intValue();

        ValidatableResponse userPosts= getPostsById(userId);
        ArrayList<Integer> userPostsIds = getValuesFromResponse(userPosts);

        for (Integer postId : userPostsIds) {
            ValidatableResponse comments = Steps
                    .getCommentsByPostId(postId);

            List<String> email = comments
                    .extract()
                    .jsonPath()
                    .getList("email");

            LOG.info("Emails for postId:" + postId + ":" +email);
        }
    }
}