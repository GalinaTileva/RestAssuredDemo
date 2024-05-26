package com.github.bodyandconfig;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.equalTo;

public class GlobalVariablesDemo {

    @BeforeMethod
    void setUp() {
        RestAssured.baseURI = "https://reqres.in/";  //по подразбиране се използва този URL + следващия
        RestAssured.basePath = "api/users";
        RestAssured.rootPath = "data";
    }

    @Test
    void testOne() {
        RestAssured.get()
                .then()
                .body("id[0]", equalTo(1));
    }

}
