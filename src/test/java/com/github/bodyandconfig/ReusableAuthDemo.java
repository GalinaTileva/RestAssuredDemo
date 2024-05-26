package com.github.bodyandconfig;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ReusableAuthDemo {

    static final String REPO_EP = "https://api.github.com/user/repos";
    static final String TOKEN = "abcdef";

    //Option 2 - string билдър
    static RequestSpecification spec = new RequestSpecBuilder()
            .setAuth(RestAssured.oauth2(TOKEN))
            .setBaseUri(REPO_EP).build();

    // точка преди билд дава опции за добавяне на настройки

    @BeforeMethod
    void setUp() {
        //Option 1
        RestAssured.authentication = RestAssured.oauth2(TOKEN);
    }

    @Test
    void authTest() {
        RestAssured.given()
                .spec(spec)  //задаваме спецификацията
                .get(REPO_EP)
                .then()
                .statusCode(200);
    }

}
