package homework_8.comments;

import homework_8.BaseTest;
import homework_8.Endpoints;
import homework_8.response.body.comments.CommentObject;
import homework_8.response.body.comments.CommentResponseObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class PutApiTest extends BaseTest {

    @ParameterizedTest()
    @MethodSource("homework_8.comments.PutApiDataProvider#putCommentsDataProvider")
    public void getOneUserTest(long id, CommentObject comment) {
        CommentResponseObject responseObject = given()
                .spec(requestSpecification)
                .header(requestHeader)
                .body(comment)
                .when()
                .put(Endpoints.commentsById,id)
                .then()
                .spec(responseSpecification)
                .statusCode(200)
                .body("code", equalTo(200))
                .extract()
                .as(CommentResponseObject.class);
        Assertions.assertEquals(id,responseObject.getData().getId());
        Assertions.assertEquals(comment,responseObject.getData());
    }
}
