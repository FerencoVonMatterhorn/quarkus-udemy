package org.ferenco.quarkus.microservices.number;

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
            title = "Number Microservice",
            description = "This microservices generates book numbers",
            version = "1.0",
            contact = @Contact(name = "@ferencooo", url = "https://twitter.com/ferencooo")),
    externalDocs =
        @ExternalDocumentation(
            url = "https://github.com/FerencoVonMatterhorn/quarkus-udemy",
            description = "Find all the code here."),
    tags = @Tag(name = "api", description = "Public API that can be used by anybody."))
public class NumberMicroservice extends Application {}
