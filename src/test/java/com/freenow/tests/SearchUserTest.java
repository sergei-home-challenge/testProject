package com.freenow.tests;

import com.freenow.AppTest;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;

public class SearchUserTest extends AppTest {
    @Test
    public void testSearchSamanthaTest() {
        RequestSpecification usersReqSpec = new RequestSpecBuilder()
                .setBaseUri("https://jsonplaceholder.typicode.com/users")
                .setAccept(ContentType.JSON)
                .setContentType(ContentType.ANY)
                .build();

        given()
                .spec(usersReqSpec)
                .then()
                .body(containsString("Samantha"));
    }
}
