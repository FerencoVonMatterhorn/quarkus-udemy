package org.ferenco.quarkus.starting;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

import io.quarkus.test.junit.QuarkusTest;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import org.junit.jupiter.api.Test;

@QuarkusTest
public class BookResourceTest {

  @Test
  public void testGetAllBooks() {
    given()
        .header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON)
        .when()
        .get("/api/books")
        .then()
        .statusCode(200)
        .body("size()", is(2));
    // size() counts the number of elements in the JSON array
  }

  @Test
  public void testCountAllBooks() {
    given()
        .header(HttpHeaders.ACCEPT, MediaType.TEXT_PLAIN)
        .when()
        .get("/api/books/count")
        .then()
        .statusCode(200)
        .body(is("2"));
  }

  @Test
  public void testGetBook() {
    given()
        .header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON)
        .pathParams("id", 1)
        .when()
        .get("/api/books/{id}")
        .then()
        .statusCode(200)
        .body("title", is("Pls help me"))
        .body("yearOfPublication", is(2023))
        .body("genre", is("Thriller"))
        .body("author", is("Ferenco"));
  }
}
