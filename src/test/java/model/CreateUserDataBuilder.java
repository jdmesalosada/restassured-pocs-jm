package model;

import data.factory.CreateUserDataFactory;
import org.apache.commons.lang3.StringUtils;

public class CreateUserDataBuilder {

    private CreateUserRequest userRequest;

    private CreateUserDataBuilder() {
        createDefaultUser();
    }

    public CreateUserDataBuilder but() {
        return this;
    }

    public CreateUserDataBuilder and() {
        return this;
    }

    private void createDefaultUser() {
        this.userRequest = CreateUserDataFactory.validUser();
    }

    public static CreateUserDataBuilder anUser() {
        return new CreateUserDataBuilder();
    }

    public CreateUserDataBuilder withUsername(String username) {
        this.userRequest.setEmail(username);
        return this;
    }

    public CreateUserDataBuilder withPassword(String password) {
        this.userRequest.setPassword(password);
        return this;
    }

    public CreateUserDataBuilder withEmptyPassword() {
        this.userRequest.setPassword(StringUtils.EMPTY);
        return this;
    }

    public CreateUserDataBuilder withEmptyUsername() {
        this.userRequest.setEmail(StringUtils.EMPTY);
        return this;
    }

    public CreateUserDataBuilder withNullPassword() {
        this.userRequest.setPassword(null);
        return this;
    }

    public CreateUserDataBuilder withNullUsername() {
        this.userRequest.setEmail(null);
        return this;
    }

    public CreateUserRequest build() {
        return this.userRequest;
    }
}
