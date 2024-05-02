package com.github.params;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class ParamsDemoQuery {
    static final String BASE_URL = "https://api.github.com/search/repositories";

    @Test
    void withoutParam() {
        RestAssured.get(BASE_URL + "?q=java&per_page=1")
                .prettyPeek()
                .then()
                .statusCode(200);
    }

    @Test
    void withParam() {
        RestAssured
                .given()
                .param("q", "java")
                .param("per_page", "1")
                .get(BASE_URL)
                .then()
                .statusCode(200);
    }


}
