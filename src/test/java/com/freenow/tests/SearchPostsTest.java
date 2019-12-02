package com.freenow.tests;

import com.freenow.AppTest;
import com.freenow.testData.CommonSettings;
import io.restassured.response.ValidatableResponse;
import org.junit.Test;

import java.util.ArrayList;

import static com.freenow.utlis.Steps.getPostsById;
import static com.freenow.utlis.Steps.getUserByName;
import static com.freenow.utlis.Steps.getValuesFromResponse;

public class SearchPostsTest extends AppTest {

    @Test
    public void testSearchPostsByUserId() {
        ValidatableResponse user = getUserByName(CommonSettings.TEST_USER);
        Integer userId = getValuesFromResponse(user)
                .get(0)
                .intValue();

        ValidatableResponse posts = getPostsById(userId);
        ArrayList<Integer> postsIds = getValuesFromResponse(posts);

        for(Integer item : postsIds){
            LOG.info("Ids of the posts"+ item);
        }
    }
}
