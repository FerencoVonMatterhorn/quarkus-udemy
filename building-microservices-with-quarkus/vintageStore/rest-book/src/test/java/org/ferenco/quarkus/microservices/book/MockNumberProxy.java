package org.ferenco.quarkus.microservices.book;

import io.quarkus.test.Mock;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@Mock
@RestClient
public class MockNumberProxy implements NumberProxy {

  @Override
  public IsbnThriteen generateIsbnNumbers() {
    IsbnThriteen isbnThriteen = new IsbnThriteen();
    isbnThriteen.isbn13 = "13-mock";
    return isbnThriteen;
  }
}
