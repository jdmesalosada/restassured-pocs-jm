package data.factory;

import com.github.javafaker.Faker;
import model.CreateUserBuilder;
import model.CreateUserRequest;
import org.apache.commons.lang3.StringUtils;

public class CreateUserDataFactory {

    private static final Faker faker = new Faker();
    private static final String DEFAULT_USERNAME = "eve.holt@reqres.in";

    public static CreateUserRequest validUser() {
        return newUserRequest();
    }

    public static CreateUserRequest missingAllInformation() {
        return new CreateUserBuilder()
                .email(StringUtils.EMPTY)
                .password(StringUtils.EMPTY)
                .build();
    }

    private static CreateUserRequest newUserRequest() {
        return new CreateUserBuilder()
                //.email(faker.internet().emailAddress())
                .email(DEFAULT_USERNAME)
                .password(faker.internet().password())
                .build();
    }
}
