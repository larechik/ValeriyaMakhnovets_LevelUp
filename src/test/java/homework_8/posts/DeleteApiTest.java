package homework_8.posts;

import homework_8.BaseTest;
import homework_8.Endpoints;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class DeleteApiTest extends BaseTest {

    @ParameterizedTest()
    @MethodSource("homework_8.posts.DeleteApiDataProvider#deletePosts")
    public void deletePostsTest(long id) {
        given()
                .spec(requestSpecification)
                .header(requestHeader)
                .when()
                .delete(Endpoints.postsById, id)
                .then()
                .spec(responseSpecification)
                .statusCode(200)
                .body("code", equalTo(204));
    }
}
