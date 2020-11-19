package homework_8.users;

import homework_8.BaseTest;
import homework_8.Endpoints;
import homework_8.response.body.people.PeopleResponseObject;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

public class DeleteApiTest extends BaseTest {

    @ParameterizedTest()
    @MethodSource("homework_8.users.DeleteApiDataProvider#deleteOneUser")
    public void getAllUsersTest(long id) {
        given()
                .spec(requestSpecification)
                .header(requestHeader)
                .when()
                .delete(Endpoints.usersById, id)
                .then()
                .spec(responseSpecification)
                .statusCode(200)
                .body("code", equalTo(204));
    }
}
