import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import conf.BaseTest;
import conf.Endpoints;
import data.factory.CreateUserDataFactory;
import io.restassured.response.ValidatableResponse;
import model.CreateUserDataBuilder;
import model.CreateUserRequest;
import model.CreateUserResponse;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import tasks.GetSingleUser;
import tasks.RegisterSuccessfulUser;
import tasks.RegisterUser;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

@Tag("Regression")
public class ReqRes2Tests extends BaseTest {

    @Test
    @Tag("Authentication")
    public void getSingleUserTest() {

        GetSingleUser getSingleUser = new GetSingleUser();
        ValidatableResponse getSingleUserResponse = getSingleUser.byId(2);
        getSingleUserResponse.statusCode(200);
        getSingleUserResponse.body("data.id", equalTo(2));
    }

  /*  @Test
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

        RegisterSuccessfulUser registerSuccessfulUser = new RegisterSuccessfulUser();
        var successfulRegisterUserResponse = registerSuccessfulUser
                .withInfo(CreateUserDataFactory.validUser());

        successfulRegisterUserResponse.getId();

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
    }*/

}
