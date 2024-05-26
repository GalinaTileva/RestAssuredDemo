package com.github.bodyandconfig;

import io.restassured.RestAssured;
import org.testng.annotations.Test;
import restassuredobjects.User;
import restassuredobjects.UserRecords;

import static org.testng.Assert.assertEquals;

public class ObjectMappingDemo {
    static final String URL = "https://api.github.com/users/rest-assured";

    @Test
    void objectMapping() {
        User user = RestAssured.get(URL).as(User.class);

        assertEquals(user.getId(), 19369327);
        assertEquals(user.getLogin(), "rest-assured");
        assertEquals(2, user.getPublicRepos());

    }

    @Test
    void objectMappingRecords() {
        UserRecords user = RestAssured.get(URL).as(UserRecords.class);

        assertEquals(user.id(), 19369327);
        assertEquals(user.login(), "rest-assured");

    }

}
