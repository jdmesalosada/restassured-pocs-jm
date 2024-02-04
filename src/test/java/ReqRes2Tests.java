import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import data.factory.CreateUserDataFactory;
import model.CreateUserDataBuilder;
import model.CreateUserRequest;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class ReqRes2Tests extends BaseTest {

    @Test
    public void getSingleUserTest() {
        given()
                .get("users/2")
                .then()
                .statusCode(HttpStatus.SC_OK)
                .body("data.id", equalTo(2));
    }

    @Test
    public void getSingleUserTest2() {
        given()
                .get("users/2")
                .then()
                .statusCode(HttpStatus.SC_OK)
                .body("data.id", equalTo(2));
    }

    @Test
    public void destinatedToFail() {
        given()
                .get("users/2")
                .then()
                .statusCode(HttpStatus.SC_NO_CONTENT)
                .body("data.id", equalTo(2));
    }

    @Test
    public void destinatedToFail2() {
        given()
                .get("users/2")
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
                .post("register")
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
