package homework_8.users;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import homework_8.BaseTest;
import homework_8.Endpoints;
import homework_8.response.MetaObject;
import homework_8.response.PaginationObject;
import homework_8.response.body.people.PeopleObject;
import homework_8.response.body.people.OneUserResponseObject;
import homework_8.response.body.people.PeopleResponseObject;
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
                .header(requestHeader)
                .when()
                .get(Endpoints.users)
                .then()
                .spec(responseSpecification)
                .statusCode(200)
                .body("data", notNullValue())
                .body("code", equalTo(200))
                .body("meta", notNullValue())
                .extract()
                .as(PeopleResponseObject.class);
    }

    @ParameterizedTest()
    @MethodSource("homework_8.users.GetApiDataProvider#getOneUser")
    public void getOneUserTest(long id) {
        OneUserResponseObject responseObject = given()
                .spec(requestSpecification)
                .header(requestHeader)
                .when()
                .get(Endpoints.usersById, id)
                .then()
                .spec(responseSpecification)
                .statusCode(200)
                .body("data", notNullValue())
                .body("code", equalTo(200))
                .body("meta", nullValue())
                .extract()
                .as(OneUserResponseObject.class);
        Assertions.assertEquals(id, responseObject.getData().getId());
    }



}
