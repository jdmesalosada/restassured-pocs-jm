package model;

public class CreateUserRequest {
    private String password;
    private String email;

    public CreateUserRequest() {
    }

    public CreateUserRequest(String password, String email) {
        this.password = password;
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }
}
