package org.ferenco.quarkus.starting;

import java.util.List;
import java.util.Optional;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.jboss.logging.Logger;

@Path("/api/books")
@Produces(MediaType.APPLICATION_JSON)
public class BookResource {

  @Inject BookRepository repository;

  @Inject Logger logger;

  @GET
  public List<Book> getAllBooks() {
    logger.info("Asking Bookrepository for all books available");
    return repository.getAllBooks();
  }

  @GET
  @Path("/count")
  @Produces(MediaType.TEXT_PLAIN)
  public int countAllBooks() {
    logger.info("Asking Bookrepository for a count of all books");
    return repository.getAllBooks().size();
  }

  @GET
  @Path("{id}")
  public Optional<Book> getBook(@PathParam("id") int id) {
    logger.info("Asking Bookrepository for book with id:" + id);
    return repository.getBook(id);
  }
}
