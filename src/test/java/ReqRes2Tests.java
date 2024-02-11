//import data.factory.CreateUserDataFactory;
//import model.CreateUserDataBuilder;
//import model.models.CreateUserRequest;
import conf.Endpoints;
import models.CreateUserRequest;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import tasks.GetSingleUser;
import tasks.RegisterSuccessfulUser;
import tasks.RegisterUser;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

@Tag("Regression")
public class ReqRes2Tests extends BaseTest {

    @Test
    @Tag("Authentication")
    public void createNewUserTest() {

        CreateUserRequest createUserRequest = new CreateUserRequest();
        createUserRequest.setEmail("eve.holt@reqres.in");
        createUserRequest.setPassword("pistol");

        RegisterSuccessfulUser registerSuccessfulUser = new RegisterSuccessfulUser();
        var token = registerSuccessfulUser.withInfo(createUserRequest).getToken();
    }

    @Test
    @Tag("Authentication")
    public void getSingleUserTest() {

        GetSingleUser getSingleUser = new GetSingleUser();
        var singleUserResponse = getSingleUser.byId(2);
        singleUserResponse.statusCode(200);
    }

    @Test
    @Tag("Authentication")
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

  /*  @Test
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

        models.CreateUserRequest user = CreateUserDataBuilder
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