package tasks;

import conf.Endpoints;
import io.restassured.response.ValidatableResponse;
import org.apache.http.HttpStatus;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class GetSingleUser {

    public ValidatableResponse byId(Integer id) {
        return
                given()
                        .pathParam("userId", id)
                        .get(Endpoints.USERS.path())
                        .then();
    }

}
