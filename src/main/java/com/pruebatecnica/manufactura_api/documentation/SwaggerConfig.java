package com.pruebatecnica.manufactura_api.documentation;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.http.HttpHeaders;

@OpenAPIDefinition(
        info = @Info(
                title = "API MANUFACTURE",
                description = "Our application provides storage control of finished products and prepares them for distribution",
                version = "1.0.0",
                contact = @Contact(
                        name = "Brayan Camilo Romero Nova",
                        url = "http://wa.me/+573114991754",
                        email = "brayan2402romero@gmail.com"
                )
        ),
        servers = {
                @Server(
                        description = "DEV Server",
                        url = "http://Localhost:8080"
                ),
                @Server(
                        description = "PROD Server",
                        url = "http://Localhost:8080"
                )
        },
        security = @SecurityRequirement(
                name = "Security Token"
        )
)
@SecurityScheme(
        name = "Security Token",
        description = "Access token for my API",
        type = SecuritySchemeType.HTTP,
        paramName = HttpHeaders.AUTHORIZATION,
        in = SecuritySchemeIn.HEADER,
        scheme = "bearer",
        bearerFormat = "JWT"
)
public class SwaggerConfig { }