package at.mycompany.shop.tests;

import io.quarkus.test.common.QuarkusTestResource;
import io.quarkus.test.h2.H2DatabaseTestResource;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

/**
 * @author: Codiyampa
 * @date: 13.02.2020
 */

@QuarkusTest
@QuarkusTestResource(H2DatabaseTestResource.class)
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
    public void testProductByIdEndpoint() {
        Integer productId = 5;
        given()
                .pathParam("id", productId)
                .when().get("/catalog/products/{id}")
                .then()
                .statusCode(200)
                .body(is("{\"id\":5,\"categoryIds\":[3],\"name\":\"Pizza Calzone\",\"price\":8.80}"));
    }

    @Test
    public void testProductsEndpoint() {
        given()
                .when().get("/catalog/products")
                .then()
                .statusCode(200)
                .body("$.size()", is(14),
                        "[0].name", is("Getrocknete Apfelstücke 500 Gramm"));
    }
}