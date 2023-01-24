package org.ferenco.quarkus.microservices.book;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.startsWith;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

@QuarkusTest
public class BookResourceTest {

  @Test
  public void shouldCreateABook() {
    given()
        .formParam("title", "Quarkus")
        .formParam("author", "Ferenco")
        .formParam("year", 2020)
        .formParam("genre", "IT")
        .when()
        .post("/api/books")
        .then()
        .statusCode(201)
        .body("isbn_13", startsWith("13-"))
        .body("title", is("Quarkus"))
        .body("author", is("Ferenco"))
        .body("year_of_publication", is(2020))
        .body("genre", is("IT"));
  }
}
