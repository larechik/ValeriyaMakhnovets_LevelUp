package homework_8.users;

import homework_8.BaseTest;
import homework_8.Endpoints;
import homework_8.response.body.people.OneUserResponseObject;
import homework_8.response.body.people.PeopleObject;
import homework_8.response.body.post.PostObject;
import homework_8.response.body.post.PostResponseObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class PutApiTest extends BaseTest {

    @ParameterizedTest()
    @MethodSource("homework_8.users.PutApiDataProvider#putUserDataProvider")
    public void getOneUserTest(long id, PeopleObject user) {
        OneUserResponseObject responseObject = given()
                .spec(requestSpecification)
                .header(requestHeader)
                .body(user)
                .when()
                .put(Endpoints.usersById,id)
                .then()
                .spec(responseSpecification)
                .statusCode(200)
                .body("code", equalTo(200))
                .extract()
                .as(OneUserResponseObject.class);
        Assertions.assertEquals(id,responseObject.getData().getId());
        Assertions.assertEquals(user,responseObject.getData());
    }
}
