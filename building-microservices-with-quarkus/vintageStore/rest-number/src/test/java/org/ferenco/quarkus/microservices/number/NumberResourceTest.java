package org.ferenco.quarkus.microservices.number;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.startsWith;
import static org.hamcrest.Matchers.hasKey;
import static org.hamcrest.Matchers.not;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

@QuarkusTest
public class NumberResourceTest {

  @Test
  public void shouldGenerateIsbnNumbers() {
    given()
        .when()
        .get("/api/numbers")
        .then()
        .statusCode(200)
        .body("isbn_13", startsWith("13-"))
        .body("isbn_10", startsWith("10-"))
        .body(not(hasKey("generationDate")));
  }
}
