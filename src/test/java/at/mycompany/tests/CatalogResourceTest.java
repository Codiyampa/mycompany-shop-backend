package at.mycompany.tests;

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
        Integer productId = 1;
        given()
                .pathParam("id", productId)
                .when().get("/catalog/products/{id}")
                .then()
                .statusCode(200)
                .body(is("{\"categoryIds\":[1],\"id\":1,\"name\":\"Getrocknete Apfelstücke 500 Gramm\",\"price\":7.99}"));
    }

    @Test
    public void testProductsEndpoint() {
        given()
                .when().get("/catalog/products/")
                .then()
                .statusCode(200)
                .body(is("[{\"categoryIds\":[1],\"id\":1,\"name\":\"Getrocknete Apfelstücke 500 Gramm\",\"price\":7.99},{\"categoryIds\":[1],\"id\":2,\"name\":\"Getrocknete Bananenstücke 500 Gramm\",\"price\":7.99},{\"categoryIds\":[1,2],\"id\":3,\"name\":\"Getrocknete Pflaumenstücke Bio 500 Gramm\",\"price\":9.99}]"));
    }
}