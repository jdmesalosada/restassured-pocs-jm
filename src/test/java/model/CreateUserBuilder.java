package model;

public class CreateUserBuilder {

    private String password;
    private String email;

    public CreateUserBuilder password(String password){
        this.password = password;
        return this;
    }

    public CreateUserBuilder email(String email){
        this.email = email;
        return this;
    }

    public CreateUserRequest build(){
        return new CreateUserRequest(password, email);
    }
}

