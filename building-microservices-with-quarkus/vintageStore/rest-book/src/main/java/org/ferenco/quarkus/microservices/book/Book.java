package org.ferenco.quarkus.microservices.book;

import java.time.Instant;
import javax.json.bind.annotation.JsonbDateFormat;
import javax.json.bind.annotation.JsonbProperty;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

@Schema(description = "This is a book")
public class Book {

  @JsonbProperty("isbn_13")
  public String isbn13;

  @Schema(required = true)
  public String title;
  public String author;

  @JsonbProperty("year_of_publication")
  public int yearOfPublication;

  public String genre;

  @JsonbDateFormat("dd/MM/yyyy")
  @JsonbProperty("creation_date")
  @Schema(implementation = String.class, format = "date")
  public Instant creationDate;

  @Override
  public String toString() {
    return "Book [isbn13="
        + isbn13
        + ", title="
        + title
        + ", author="
        + author
        + ", yearOfPublication="
        + yearOfPublication
        + ", genre="
        + genre
        + ", creationDate="
        + creationDate
        + "]";
  }
}
