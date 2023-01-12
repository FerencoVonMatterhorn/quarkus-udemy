package org.ferenco.quarkus.starting;

import java.util.List;
import java.util.Optional;
import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class BookRepository {

  public List<Book> getAllBooks() {
    return List.of(
        new Book(1, "Pls help me", "Ferenco", 2023, "Thriller"),
        new Book(2, "Pls help me the return of da boy", "Ferenco", 2023, "Thriller"));
  }

  public int countAllBooks() {
    return getAllBooks().size();
  }

  public Optional<Book> getBook(int id) {
    return getAllBooks().stream().filter(book -> book.id == id).findFirst();
  }
}
