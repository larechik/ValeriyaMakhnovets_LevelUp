package homework_8.comments;

import homework_8.BaseTest;
import homework_8.Endpoints;
import homework_8.response.body.comments.CommentObject;
import homework_8.response.body.comments.CommentResponseObject;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class PostApiTest extends BaseTest {

    @ParameterizedTest()
    @MethodSource("homework_8.comments.PostApiDataProvider#setNewCommentsDataProvider")
    public void getOneUserTest(CommentObject comment) {
        CommentResponseObject responseObject = given()
                .spec(requestSpecification)
                .header(requestHeader)
                .body(comment)
                .when()
                .post(Endpoints.comments)
                .then()
                .spec(responseSpecification)
                .statusCode(200)
                .body("code", equalTo(201))
                .extract()
                .as(CommentResponseObject.class);
        Assertions.assertEquals(comment,responseObject.getData());
    }
}
