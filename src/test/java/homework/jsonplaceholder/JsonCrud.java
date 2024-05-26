package homework.jsonplaceholder;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class JsonCrud {
    static final String BASE_URL = "https://jsonplaceholder.typicode.com";

    @Test
    void getComment() {
        RestAssured
                .get(BASE_URL + "/posts/1/comments")
                .then()
                .statusCode(200);
    }

    @Test
    void getCommentId() {
        RestAssured
                .get(BASE_URL + "/comments?postId=1")
                .then()
                .statusCode(200);
    }

    @Test
    void postPost() {
        RestAssured
                .given()
                .when()
                .post(BASE_URL + "/posts")
                .then()
                .statusCode(201);

    }

    @Test
    void patchPost() {
        RestAssured
                .given()
                .when()
                .patch(BASE_URL + "/posts/1")
                .then()
                .statusCode(200);
    }

    @Test
    void deletePost() {
        RestAssured
                .given()
                .when()
                .delete(BASE_URL + "/posts/1")
                .then()
                .statusCode(204);

    }


}
