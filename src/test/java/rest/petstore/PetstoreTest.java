package rest.petstore;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class PetstoreTest extends BaseTest {
    public static final String PET_STATUS_PATH = "/findByStatus";
    public static final String PET_ID_PATH = "/{petId}";
    public static final String STORE_INVENTORY_PATH = "/inventory";
    public static final String STORE_ORDER_ID_PATH = "/{orderId}";
    public static final String USER_USERNAME_PATH = "/{username}";
    public static final String USER_LOGIN_PATH = "/login";
    public static final String USER_LOGOUT_PATH = "/logout";
    private final BaseTest baseTest = new BaseTest();

    @Test
    public void getPetStatus() {
        given()
                .spec(baseTest.specifications())
                .basePath("/pet")
                .when()
                .get(PET_STATUS_PATH)
                .then()
                .log().all()
                .statusCode(200);
    }

    @Test
    public void getPetByID() {
        given()
                .spec(baseTest.specifications())
                .basePath("/pet")
                .pathParam("petId", 710)
                .when()
                .get(PET_ID_PATH)
                .then()
                .log().all()
                .statusCode(200);
    }

    @Test
    public void getStoreInventoryByStatus() {
        given()
                .spec(baseTest.specifications())
                .basePath("/store")
                .when()
                .get(STORE_INVENTORY_PATH)
                .then()
                .log().all()
                .statusCode(200);
    }

    @Test
    public void getStoreOrderByID() {
        given()
                .spec(baseTest.specifications())
                .basePath("/store/order")
                .pathParam("orderId", 7777)
                .when()
                .get(STORE_ORDER_ID_PATH)
                .then()
                .log().all()
                .statusCode(200);
    }

    @Test
    public void getUserByUsername() {
        given()
                .spec(baseTest.specifications())
                .basePath("/user")
                .pathParam("username", "Hannya_irezumi")
                .when()
                .get(USER_USERNAME_PATH)
                .then()
                .log().all()
                .statusCode(200);
    }

    @Test
    public void getLogsUserIntoSystem() {
        given()
                .spec(baseTest.specifications())
                .basePath("/user")
                .queryParam("username", "Hannya_irezumi")
                .queryParam("password", "PASSWORD")
                .when()
                .get(USER_LOGIN_PATH)
                .then()
                .log().all()
                .statusCode(200);
    }

    @Test
    public void getLogsOutCurrentLoggedInUserSession() {
        given()
                .spec(baseTest.specifications())
                .basePath("/user")
                .when()
                .get(USER_LOGOUT_PATH)
                .then()
                .log().all()
                .statusCode(200);
    }
}