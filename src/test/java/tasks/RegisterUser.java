package tasks;

import conf.Endpoints;
import data.factory.CreateUserDataFactory;
import io.restassured.response.ValidatableResponse;
import model.CreateUserRequest;

import static io.restassured.RestAssured.given;

public class RegisterUser {
    public ValidatableResponse withInfo(CreateUserRequest createUserRequest) {
        return given()
                .when()
                .body(createUserRequest)
                .post(Endpoints.REGISTER.path())
                .then();
    }
}
