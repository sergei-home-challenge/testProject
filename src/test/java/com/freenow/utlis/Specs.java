package com.freenow.utlis;


import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.apache.http.HttpStatus;

import static com.freenow.testData.CommonSettings.baseUrl;

public class Specs {
    public static RequestSpecification getRequestSpec() {
        RequestSpecification usersReqSpec = new RequestSpecBuilder()
                .setBaseUri(baseUrl)
                .setAccept(ContentType.JSON)
                .setContentType(ContentType.ANY)
                .log(LogDetail.ALL)
                .build();
        return usersReqSpec;
    }

    public static ResponseSpecification getResponseSpec() {
        ResponseSpecification responseSpec = new ResponseSpecBuilder()
                .expectStatusCode(HttpStatus.SC_OK)
                .build();
        return responseSpec;
    }
}

