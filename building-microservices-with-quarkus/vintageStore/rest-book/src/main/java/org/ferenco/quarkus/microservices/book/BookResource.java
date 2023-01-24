package org.ferenco.quarkus.microservices.book;

import java.time.Instant;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import org.jboss.logging.Logger;

@Path("/api/books")
@Tag(name = "Book REST endpoint")
public class BookResource {

  @Inject Logger logger;



  //TODO: Change consume Type to JSON 
  @POST
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
  @Operation(summary = "Creates a Book", description = "Creates a Book with an ISBN number")
  public Response createABook(
      @FormParam("title") String title,
      @FormParam("author") String author,
      @FormParam("year") int yearOfPublication,
      @FormParam("genre") String genre) {
    Book book = new Book();
    book.isbn13 = "13-Will get later";
    book.creationDate = Instant.now();
    book.title = title;
    book.author = author;
    book.yearOfPublication = yearOfPublication;
    book.genre = genre;
    logger.info("Book created: " + book);
    return Response.status(201).entity(book).build();
  }
}
