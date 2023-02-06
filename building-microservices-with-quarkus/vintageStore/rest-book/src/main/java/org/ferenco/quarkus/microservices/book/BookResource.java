package org.ferenco.quarkus.microservices.book;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.Instant;

import javax.inject.Inject;
import javax.json.bind.JsonbBuilder;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.eclipse.microprofile.faulttolerance.Fallback;
import org.eclipse.microprofile.faulttolerance.Retry;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.jboss.logging.Logger;

@Path("/api/books")
@Tag(name = "Book REST endpoint")
public class BookResource {

  @Inject Logger logger;

  @Inject @RestClient NumberProxy proxy;

  // TODO: Change consume Type to JSON

  @POST
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
  @Operation(summary = "Creates a Book", description = "Creates a Book with an ISBN number")
  @Fallback(fallbackMethod = "fallbackOnCreatingABook")
  @Retry(maxRetries = 3, delay = 3000)
  public Response createABook(
      @FormParam("title") String title,
      @FormParam("author") String author,
      @FormParam("year") int yearOfPublication,
      @FormParam("genre") String genre) {
    Book book = new Book();
    book.isbn13 = proxy.generateIsbnNumbers().isbn13;
    book.creationDate = Instant.now();
    book.title = title;
    book.author = author;
    book.yearOfPublication = yearOfPublication;
    book.genre = genre;
    logger.info("Book created: " + book);
    return Response.status(201).entity(book).build();
  }

  public Response fallbackOnCreatingABook(
      String title, String author, int yearOfPublication, String genre) throws FileNotFoundException {

    Book book = new Book();
    book.isbn13 = "will be set later";
    book.creationDate = Instant.now();
    book.title = title;
    book.author = author;
    book.yearOfPublication = yearOfPublication;
    book.genre = genre;
    saveBookOnDisk(book);
    logger.warn("Book save on disk: " + book);
    return Response.status(206).entity(book).build();
  }

  private void saveBookOnDisk(Book book) throws FileNotFoundException {
    String bookJson =  JsonbBuilder.create().toJson(book);
    try (PrintWriter out = new PrintWriter("book-" + Instant.now().toEpochMilli() + ".json")){
      out.println(bookJson);
    }
  }
}
