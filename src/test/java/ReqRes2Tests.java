import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import data.factory.CreateUserDataFactory;
import model.CreateUserDataBuilder;
import model.CreateUserRequest;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

@Tag("Regression")
public class ReqRes2Tests extends BaseTest {

    @Test
    @Tag("Authentication")
    public void getSingleUserTest() {
        given()
                .pathParam("userId", 2)
                .get( Endpoints.USERS.path())
                .then()
                .statusCode(HttpStatus.SC_OK)
                .body("data.id", equalTo(2));
    }

    @Test
    @Tag("Authentication")
    public void getSingleUserTest2() {
        given()
                .pathParam("userId", 2)
                .get(Endpoints.USERS.path())
                .then()
                .statusCode(HttpStatus.SC_OK)
                .body("data.id", equalTo(2));
    }

    @Test
    public void destinatedToFail() {
        given()
                .pathParam("userId", 2)
                .get(Endpoints.USERS.path())
                .then()
                .statusCode(HttpStatus.SC_NO_CONTENT)
                .body("data.id", equalTo(2));
    }

    @Test
    public void destinatedToFail2() {
        given()
                .get(Endpoints.USERS.path())
                .then()
                .statusCode(HttpStatus.SC_NO_CONTENT)
                .body("data.id", equalTo(2));
    }

    @Test
    public void createUserMissingAllInformation() {
        given()
                .when()
                .body(CreateUserDataFactory.missingAllInformation())
                .post("register")
                .then();

    }

    @Test
    public void createUserWithValidInformation() {
        given()
                .when()
                .body(CreateUserDataFactory.validUser())
                .post(Endpoints.REGISTER.path())
                .then();
    }

    @Test
    public void createUserWithValidInformationTestDataBuilder() throws JsonProcessingException {

        ObjectMapper objectMapper = new ObjectMapper();

        CreateUserRequest user = CreateUserDataBuilder
                .anUser()
                .but()
                .withNullUsername()
                .build();

        System.out.println(objectMapper.writeValueAsString(user));

        given()
                .when()
                .body(user)
                .post("register")
                .then();
    }

}
