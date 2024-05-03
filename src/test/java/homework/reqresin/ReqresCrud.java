package homework.reqresin;

import io.restassured.RestAssured;
import org.testng.annotations.Test;


public class ReqresCrud {
    static final String BASE_URL = "https://reqres.in";


    @Test
    void getAListOfUsers() {
        RestAssured
                .get(BASE_URL + "/api/users?page=2")
                .then()
                .statusCode(200);
    }

    @Test
    void getASingleUser() {
        RestAssured
                .get(BASE_URL + "/api/users/2")
                .then()
                .statusCode(200);

    }

    @Test
    void getUserNotFound() {
        RestAssured
                .get(BASE_URL + "/api/users/23")
                .then()
                .statusCode(404);
    }

    @Test
    void postNewUser() {
        RestAssured
                .given()
                .body("{\"name\" : \"morpheus\", \"job\" : \"leader\"}")
                .when()
                .post(BASE_URL + "/api/users")
                .then()
                .statusCode(201);
    }

    @Test
    void patchAnUpdateForUser() {
        RestAssured
                .given()
                .body("{\"name\" : \"morpheus\", \"job\" : \"zion resident\"}")
                .when()
                .patch(BASE_URL + "/api/users/2")
                .then()
                .statusCode(200);
    }

    // този и следващия не знам защо не работят, през Postman същите нямат проблем и са статус 200
    @Test
    void postSuccessfulRegister() {
        RestAssured
                .given()
                .body("{\"email\" : \"eve.holt@reqres.in\", \"password\" : \"pistol\"}")
                .when()
                .post(BASE_URL + "/api/register")
                .then()
                .statusCode(200);
    }

    @Test
    void postSuccessfulLogin() {
        RestAssured
                .given()
                .body("{\"email\" : \"eve.holt@reqres.in\", \"password\" : \"cityslicka\"}")
                .when()
                .post(BASE_URL + "/api/login")
                .then()
                .statusCode(200);
    }

    @Test
    void postUnsuccessfulLogin() {
        RestAssured
                .given()
                .body("{\"email\" : \"peter@klaven\"}")
                .when()
                .post(BASE_URL + "/api/login")
                .then()
                .statusCode(400);
    }

    @Test
    void deleteUser() {
        RestAssured
                .given()
                .when()
                .delete(BASE_URL + "/api/users/2")
                .then()
                .statusCode(204);
    }

}
