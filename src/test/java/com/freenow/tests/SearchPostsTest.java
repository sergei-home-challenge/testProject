package com.freenow.tests;

import com.freenow.AppTest;
import io.restassured.response.ValidatableResponse;
import org.junit.Test;

import java.util.ArrayList;

import static com.freenow.utlis.Steps.*;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.hasItems;

public class SearchPostsTest extends AppTest {

    @Test
    public void testSearchPostsByUserId() {
        ValidatableResponse user = getUserByName("Samantha");
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
