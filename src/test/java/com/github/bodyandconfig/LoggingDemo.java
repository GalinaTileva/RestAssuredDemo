package com.github.bodyandconfig;

import io.restassured.RestAssured;
import io.restassured.filter.log.LogDetail;
import org.testng.annotations.Test;

//за анализ и дебъгване
public class LoggingDemo {
    static final String POSTS_EP = "https://jsonplaceholder.typicode.com";

    @Test
    void logTest() {
        RestAssured
                .given()
             //   .log().all()
                .log().headers()
                .log().body()
                .when()
                    .get(POSTS_EP)
                .then()
                    .log().headers()
                .log().ifValidationFails(LogDetail.ALL)
                    .statusCode(200);
    }

}
