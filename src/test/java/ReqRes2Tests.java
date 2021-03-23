import org.apache.http.HttpStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;


import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

@DisplayName("TestInfo Demo")
@Tag("algo")
public class ReqRes2Tests extends BaseTest {

    @Test
    public void getSingleUserTest() {
        given()
                .get("users/2")
                .then()
                .statusCode(HttpStatus.SC_OK)
                .body("data.id", equalTo(2));
    }

    @Test
    @DisplayName("Obtener la informacion del usuario")
    public void getSingleUserTest2() {
        given()
                .get("users/2")
                .then()
                .statusCode(HttpStatus.SC_OK)
                .body("data.id", equalTo(2));
    }

    @Test
    @DisplayName("Este test debe fallar")
    public void destinatedToFail() {
        given()
                .get("users/2")
                .then()
                .statusCode(HttpStatus.SC_NO_CONTENT)
                .body("data.id", equalTo(2));
    }

    @Test
    @Tag("e2e")
    @DisplayName("Este test debe fallar")
    public void destinatedToFail2() {
        given()
                .get("users/2")
                .then()
                .statusCode(HttpStatus.SC_NO_CONTENT)
                .body("data.id", equalTo(2));
    }

}
