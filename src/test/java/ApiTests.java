import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;
import static org.hamcrest.Matchers.*;

public class ApiTests {
    static ApiConfig config = ConfigFactory
            .create(ApiConfig.class, System.getProperties());

    @Test
    @DisplayName("ApiTest")
    void ApiTest(){
    given()
            .body("{\"email\": \"eve.holt@reqres.in\",\"password\": \"cityslicka\"}")
            .contentType(JSON)
            .log().all()
            .when()
            .post("https://reqres.in/api/login")
            .then()
            .log().all()
            .statusCode(200)
            .assertThat().body("token", is(config.getToken()));
    }
}
