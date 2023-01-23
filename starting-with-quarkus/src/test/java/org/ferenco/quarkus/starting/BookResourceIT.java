package org.ferenco.quarkus.starting;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

import io.quarkus.test.junit.QuarkusIntegrationTest;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import org.junit.jupiter.api.Test;

@QuarkusIntegrationTest
public class BookResourceIT extends BookResourceTest {

  //We override the method because there are different values in the native image which has the prod profile loaded 
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
        .body("genre", is("Drama"))
        .body("author", is("Ferenco"));
  }
}
