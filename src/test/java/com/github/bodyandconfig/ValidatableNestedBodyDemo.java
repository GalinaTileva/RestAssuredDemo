package com.github.bodyandconfig;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.lessThanOrEqualTo;

public class ValidatableNestedBodyDemo {
    static final String LIMIT_EP = "https://api.github.com/rate_limit";
    static final String USERS_EP = "https://reqres.in/api/users?page=1";

/*   за Тест 1
    @BeforeMethod
     void setUp() {
        RestAssured.baseURI = "https://api.github.com/rate_limit";
    }*/

    @Test
    void nestedBodyValidation() {
        RestAssured
                .get(LIMIT_EP)
                .then()
                    .rootPath("resources.core")
                        .body("limit", equalTo(60))
                        .body("remaining", lessThanOrEqualTo(60))
                        .body("reset", notNullValue())
                    .rootPath("resources.graphqL")
                        .body("limit", equalTo(0))
                        .body("remaining", lessThanOrEqualTo(10))
                    .noRootPath()
                        .body("resources.search.limit", equalTo(10));
    }

    @Test
    void repeatingItems() {
        RestAssured
                .get(USERS_EP)
                .then()
                .body("data.id[0]", equalTo(1))
                .body("data.id[5]", equalTo(6))
                .body("data.first_name[2]", equalTo("Emma"))
                .body("data.first_name[3]", equalTo("Eve"))
                .body("data.first_name", hasItem("Eve"))
                .body("data.first_name", hasItems("Eve", "Emma"))
                .body("data.first_name", hasItem(endsWith("ma")));
    }


}
