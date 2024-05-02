package homework.reqresin;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class Operations {
    static final String LIST_USERS = "https://reqres.in/api/users?page=2";

    @Test(description = "Get a list of users")
    void getListUsers() {
        Response response = RestAssured.get(LIST_USERS);
        assertEquals(response.getStatusCode(), 200);
    }


    // по-красиво :
    @Test(description = "Get a list of users")
    void getListUsersAgain() {
        RestAssured.get(LIST_USERS)
                .then()
                .statusCode(200);
    }




}
