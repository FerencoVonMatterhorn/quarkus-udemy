package org.ferenco.quarkus.starting;

import java.util.List;
import java.util.Optional;
import javax.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.config.inject.ConfigProperty;

@ApplicationScoped
public class BookRepository {

  @ConfigProperty(name = "books.genre", defaultValue = "Action")
  String genre;

  public List<Book> getAllBooks() {
    return List.of(
        new Book(1, "Pls help me", "Ferenco", 2023, genre),
        new Book(2, "Pls help me the return of da boy", "Ferenco", 2023, genre));
  }

  public int countAllBooks() {
    return getAllBooks().size();
  }

  public Optional<Book> getBook(int id) {
    return getAllBooks().stream().filter(book -> book.id == id).findFirst();
  }
}
