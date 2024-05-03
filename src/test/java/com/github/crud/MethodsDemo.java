package com.github.crud;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class MethodsDemo {

    static final String REPO_EP = "https://api.github.com/user/repos";
    static final String TOKEN = "abcdef";

    @Test(description = "Create a repo")
    void postTest() {
        RestAssured
                .given()
             //   .header("Authorization", "token " + TOKEN)
                .auth()
                .oauth2(TOKEN)
                .body("{\"name\" : \"deleteme\"}")
                .when()
                .post(REPO_EP)
                .then()
                .statusCode(201);
    }

    @Test(description = "Update repo")
    void patchTest() {
        RestAssured
                .given()
                .auth()
                .oauth2(TOKEN)
                .body("{\"name\": \"deleteme-patched1\"}")
                .when()
                .patch("https://api.github.com/repos/dermenji/deleteme")
                .then()
                .statusCode(200);
    }

    @Test
    void deleteTest() {
        RestAssured
                .given()
                .header("Authorization", "token " + TOKEN)
                .when()
                .delete("https://api.github.com/repos/dermenji/deleteme-patched1")
                .then()
                .statusCode(204);
    }


}
