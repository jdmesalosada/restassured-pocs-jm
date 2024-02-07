package tasks;

import data.factory.CreateUserDataFactory;
import model.CreateUserRequest;
import model.CreateUserResponse;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.notNullValue;

public class RegisterSuccessfulUser {

    public CreateUserResponse withInfo(CreateUserRequest createUserRequest){

        RegisterUser registerUser = new RegisterUser();
        var registerUserResponse =
                registerUser.withInfo(createUserRequest);

        registerUserResponse.statusCode(200);

        var registerUserResponseModel = registerUserResponse
                .extract()
                .as(CreateUserResponse.class);

        assertThat(registerUserResponseModel.getToken(), notNullValue());

        return registerUserResponseModel;
    }

}
