package rest.petstore;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class BaseTest {
    public static final String PETSTORE_URI = "https://petstore.swagger.io/v2";

    public RequestSpecification specifications() {
        return new RequestSpecBuilder()
                .setBaseUri(PETSTORE_URI)
                .setAccept(ContentType.JSON)
                .setContentType(ContentType.ANY)
                .log(LogDetail.ALL)
                .build();
    }
}