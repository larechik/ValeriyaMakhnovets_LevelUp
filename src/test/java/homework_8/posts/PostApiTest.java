package homework_8.posts;

import homework_8.BaseTest;
import homework_8.Endpoints;
import homework_8.response.body.comments.CommentObject;
import homework_8.response.body.comments.CommentResponseObject;
import homework_8.response.body.post.PostObject;
import homework_8.response.body.post.PostResponseObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class PostApiTest extends BaseTest {

    @ParameterizedTest()
    @MethodSource("homework_8.posts.PostApiDataProvider#setNewPostDataProvider")
    public void getOneUserTest(PostObject post) {
        PostResponseObject responseObject = given()
                .spec(requestSpecification)
                .header(requestHeader)
                .body(post)
                .when()
                .post(Endpoints.posts)
                .then()
                .spec(responseSpecification)
                .statusCode(200)
                .body("code", equalTo(201))
                .extract()
                .as(PostResponseObject.class);
        Assertions.assertEquals(post,responseObject.getData());
    }
}
