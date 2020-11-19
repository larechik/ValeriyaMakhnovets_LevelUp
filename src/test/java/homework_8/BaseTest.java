package homework_8;

import io.restassured.RestAssured;
import io.restassured.authentication.OAuth2Scheme;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.assertj.core.api.SoftAssertions;
import org.junit.Ignore;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.*;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.not;


public class BaseTest {
    private static String token = "fe4c43c20c8dd7f0af9c290dc553cb50f3065d6401e805c56b1ed8edda06f5d6";
    protected static RequestSpecification requestSpecification;
    protected static ResponseSpecification responseSpecification;
    protected static Header requestHeader;

    @BeforeAll
    public static void setUp() {
        requestSpecification = new RequestSpecBuilder()
                .setBaseUri("https://gorest.co.in/")
                .setContentType(ContentType.JSON)
                .log(LogDetail.ALL)
                .build();

        responseSpecification = new ResponseSpecBuilder()
                .log(LogDetail.ALL)
                .expectContentType(ContentType.JSON)
                .build();

        requestHeader = new Header("Authorization", "Bearer " + token);
    }

}
