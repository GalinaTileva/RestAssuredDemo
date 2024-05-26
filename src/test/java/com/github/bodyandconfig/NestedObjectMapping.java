package com.github.bodyandconfig;

import io.restassured.RestAssured;
import org.testng.annotations.Test;
import restassuredobjects.RateLimit;
import static org.testng.Assert.assertEquals;

public class NestedObjectMapping {

    static final String URL = "https://api.github.com/rate_limit";

    @Test
    void nestedObjectMapping() {
        RateLimit limit = RestAssured.get(URL).as(RateLimit.class);
        assertEquals(60, limit.getCoreLimit());
        assertEquals(10, limit.getSearchLimit());
    }
}
