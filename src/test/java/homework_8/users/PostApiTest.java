package homework_8.users;

import homework_8.BaseTest;
import homework_8.Endpoints;
import homework_8.response.body.comments.CommentObject;
import homework_8.response.body.comments.CommentResponseObject;
import homework_8.response.body.people.OneUserResponseObject;
import homework_8.response.body.people.PeopleObject;
import homework_8.response.body.people.PeopleResponseObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class PostApiTest extends BaseTest {

    @ParameterizedTest()
    @MethodSource("homework_8.users.PostApiDataProvider#createUserDataProvider")
    public void getOneUserTest(PeopleObject user) {
        OneUserResponseObject responseObject = given()
                .spec(requestSpecification)
                .header(requestHeader)
                .body(user)
                .when()
                .post(Endpoints.users)
                .then()
                .spec(responseSpecification)
                .statusCode(200)
                .body("code", equalTo(201))
                .extract()
                .as(OneUserResponseObject.class);
        Assertions.assertEquals(user,responseObject.getData());
    }
}
