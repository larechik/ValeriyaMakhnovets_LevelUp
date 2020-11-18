package homework_8.comments;

import homework_8.BaseTest;
import homework_8.Endpoints;
import homework_8.response.body.comments.CommentResponseObject;
import homework_8.response.body.comments.CommentsResponseObject;
import homework_8.response.body.post.PostResponseObject;
import homework_8.response.body.post.PostsResponseObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;


public class GetApiTest extends BaseTest {

    @Test
    public void getAllUsersTest() {
        given()
                .spec(requestSpecification)
                .when()
                .get(Endpoints.comments)
                .then()
                .spec(responseSpecification)
                .statusCode(200)
                .body("data", notNullValue())
                .body("code", equalTo(200))
                .body("meta", notNullValue()).extract()
                .as(CommentsResponseObject.class);
    }

    @ParameterizedTest()
    @MethodSource("homework_8.comments.GetApiDataProvider#getOneUser")
    public void getOneUserTest(long id) {
        CommentResponseObject responseObject = given()
                .spec(requestSpecification)
                .header(requestHeader)
                .when()
                .get(Endpoints.commentsById, id)
                .then()
                .spec(responseSpecification)
                .statusCode(200)
                .body("code", equalTo(200))
                .body("meta", nullValue())
                .body("data", notNullValue())
                .extract()
                .as(CommentResponseObject.class);
        Assertions.assertEquals(id, responseObject.getData().getId());
    }


}
