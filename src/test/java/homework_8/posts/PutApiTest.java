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

public class PutApiTest extends BaseTest {

    @ParameterizedTest()
    @MethodSource("homework_8.posts.PutApiDataProvider#putPostDataProvider")
    public void getOneUserTest(long id, PostObject post) {
        PostResponseObject responseObject = given()
                .spec(requestSpecification)
                .header(requestHeader)
                .body(post)
                .when()
                .put(Endpoints.postsById,id)
                .then()
                .spec(responseSpecification)
                .statusCode(200)
                .body("code", equalTo(200))
                .extract()
                .as(PostResponseObject.class);
        Assertions.assertEquals(id,responseObject.getData().getId());
        Assertions.assertEquals(post,responseObject.getData());
    }
}
