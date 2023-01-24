package org.ferenco.quarkus.microservices.book;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import org.eclipse.microprofile.openapi.annotations.ExternalDocumentation;
import org.eclipse.microprofile.openapi.annotations.OpenAPIDefinition;
import org.eclipse.microprofile.openapi.annotations.info.Contact;
import org.eclipse.microprofile.openapi.annotations.info.Info;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

@ApplicationPath("/")
@OpenAPIDefinition(
    info =
        @Info(
            title = "Book Microservice",
            description = "This Microservice generates books",
            version = "1.0",
            contact = @Contact(name = "@ferencooo", url = "https://twitter.com/ferencooo")),
    externalDocs = @ExternalDocumentation(url = "", description = ""),
    tags = @Tag(name = "api", description = "Public API that can be used by anybody."))
public class BookMicroservice extends Application {}
