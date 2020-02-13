package at.mycompany.tests;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

/**
 * @author: Codiyampa
 * @date: 13.02.2020
 */

@QuarkusTest
public class CatalogResourceTest {

    @Test
    public void testStatusEndpoint() {
        given()
          .when().get("/catalog/status")
          .then()
             .statusCode(200)
             .body(is("online"));
    }

    @Test
    public void testProductEndpoint() {
        Integer productId = 1;
        given()
                .pathParam("id", productId)
                .when().get("/catalog/product/{id}")
                .then()
                .statusCode(200)
                .body(is("{\"id\":1,\"name\":\"Getrocknete Apfelstücke 500 Gramm\",\"price\":7.99}"));
    }
}