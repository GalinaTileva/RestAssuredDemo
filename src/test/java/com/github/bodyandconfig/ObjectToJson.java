package com.github.bodyandconfig;

import io.restassured.RestAssured;
import org.testng.annotations.Test;
import restassuredobjects.Repository;


//конвертираме response в обект и го подаваме като боди
public class ObjectToJson {
    static final String REPOS = "https://";
    static final String TOKEN = "abcdefg";


    @Test(description = "Create a repo")
    void postTest() {

        var repo = new Repository("deleteme");

        RestAssured
                .given()
                //   .header("Authorization", "token " + TOKEN)
                .auth()
                .oauth2(TOKEN)
                .body(repo)
                .when()
                .post(REPOS)
                .then()
                .statusCode(201);
    }

}
