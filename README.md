# Manufacture API

This API implements a complete solution for product management in a manufacturing plant. It allows the following operations to be carried out:

- Visualisation of products in stock, filtered by status.
- Registration of new products to the inventory (individual and massive).
- Registration of the exit of products.
- Marking products as defective.

The backend is a RESTful API, developed in Java, using Spring Framework and handles the business logic, authentication is implemented through JWT tokens.

### Tech Stack

- Java.
- Database: PostgreSQL.
- Spring Boot.
- Spring Security.
- JWT Authentication.

The client is in a separate repository, it was developed with **Angular 17**.

### Requirements

- Java 17+.
- PostgreSQL.
- Gradle as a build tool.



## Run Locally

### Database
To use PostgreSQL, make sure the service is running. The configuration file for the database connection is in src/main/resources/application.properties.

Run the following script to create the necessary tables:

Database Creation Script
```bash
CREATE DATABASE bd_manufactura;
```

The API will handle the rest of the database changes on start-up.

### API

Clone the project

```bash
git clone https://github.com/Brayan9812omeroN/Maufacture-API.git
```

Go to the project directory

```bash
cd Maufacture-API
```

**Build the project**

Make sure you have Gradle installed and run the following commands to build and run the project:

```bash
./gradlew build
```

```bash
./gradlew bootRun
```

This will compile the project and start the Spring Boot server. The API will be available at

```bash
http://localhost:8080
```
## Authentication

The API requires JWT token-based authentication. To obtain a token, send a request to:

```bash
POST /auth/login
{
    "username": "tu_usuario",
    "password": "tu_contraseña"
}
```

Use the token received in the Authorization header of your requests.
## Documentation

The API has interactive documentation generated with Swagger. Once the application is running, access the documentation at:

[API Documentation](http://localhost:8080/swagger-ui.html)


## Support

For support, email brayan2402romero@gmail.com 


## Authors

- [@Brayan Romero](https://github.com/Brayan9812omeroN)


## Sources

- OpenAPI 3 Library for spring-boot By Badr NASS LAHSEN & Library for OpenAPI 3 with spring-boot By Badr NASS LAHSEN. (s. f.). OpenAPI 3 Library for spring-boot. OpenAPI 3 Library For Spring-boot. https://springdoc.org/ 
- Spring Framework Documentation :: Spring Framework. (s. f.). https://docs.spring.io/spring-framework/reference/index.html 
- Nicolas. (s. f.). GitHub - nicolas-97/pa-c3-intro-spring-user-crud. GitHub. https://github.com/nicolas-97/pa-c3-intro-spring-user-crud.git 
- UnProgramadorNaceOfficial. (s. f.-a). GitHub - UnProgramadorNaceOfficial/spring-security-complete. GitHub. https://github.com/UnProgramadorNaceOfficial/spring-security-complete.git 
- UnProgramadorNaceOfficial. (s. f.-b). GitHub - UnProgramadorNaceOfficial/spring-security-token-universe. GitHub. https://github.com/UnProgramadorNaceOfficial/spring-security-token-universe.git

