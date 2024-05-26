package com.github.bodyandconfig;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;

public class BasicTest {

    @BeforeMethod
    void setUp() { // URL по подразбиране
        RestAssured.baseURI = "https://reqres.in/api/users?page=1";
    }

    @Test
    void basicTest () {
        RestAssured
                .given()
                // header винаги с 2 параметъра - key = value
                    .header("name", "value")
                .when()
                    .get()      //без url, без параметър
                .then()
                    .statusCode(200)
                    .header("Content-Type", "application/json; charset=utf-8")
                .body("page", equalTo(1))
                .rootPath("data")
                    .body("first_name[0]", equalTo("George")) // име на опред. място в масива
                    .body("first_name", hasItems("George", "Emma")) //проверява дали опред. име е в списъка
                .rootPath("")  //връщаме се назад
                    .body("per_page", equalTo(6));

    }

}
