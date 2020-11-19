package homework_8.posts;

import homework_8.BaseTest;
import homework_8.Endpoints;
import homework_8.response.body.people.OneUserResponseObject;
import homework_8.response.body.people.PeopleResponseObject;
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
                .get(Endpoints.posts)
                .then()
                .spec(responseSpecification)
                .statusCode(200)
                .body("data", notNullValue())
                .body("code", equalTo(200))
                .body("meta", notNullValue()).extract()
                .as(PostsResponseObject.class);

    }

    @ParameterizedTest()
    @MethodSource("homework_8.posts.GetApiDataProvider#getOneUser")
    public void getOneUserTest(long id) {
        PostResponseObject responseObject = given()
                .spec(requestSpecification)
                .when()
                .get(Endpoints.postsById, id)
                .then()
                .spec(responseSpecification)
                .statusCode(200)
                .body("data", notNullValue())
                .body("code", equalTo(200))
                .body("meta", nullValue())
                .extract()
                .as(PostResponseObject.class);
        Assertions.assertEquals(id, responseObject.getData().getId());
        ;
    }


}
