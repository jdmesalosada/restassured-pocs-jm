package tasks;

import conf.Endpoints;
import io.restassured.response.ValidatableResponse;
import models.CreateUserRequest;
import models.CreateUserResponse;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.notNullValue;

public class RegisterSuccessfulUser {

    public CreateUserResponse withInfo(CreateUserRequest createUserRequest){
        RegisterUser registerUser = new RegisterUser();
        var registerUserResponse = registerUser
                .withInfo(createUserRequest);

        registerUserResponse.statusCode(200);

        var registerUserResponseModel = registerUserResponse
                .extract()
                .as(CreateUserResponse.class);

        assertThat(registerUserResponseModel.getToken(), notNullValue());
        return registerUserResponseModel;
    }
}
