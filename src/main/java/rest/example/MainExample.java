package rest.example;
import static io.restassured.RestAssured.given;

public class MainExample {
    public static final String NUMBERS_URI = "http://numbersapi.com";
    public static final String ID_PATH = "/{id}";

    public static void main(String[] args) {
        given()
                .baseUri(NUMBERS_URI)
                .pathParam("id",100)
                .when()
                .get(ID_PATH)
                .then()
                .log().all()
                .statusCode(200);
    }
}