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
    "username": "Admin",
    "password": "1234"
}
```

Use the token received in the Authorization header of your requests.
## Documentation

The API has interactive documentation generated with Swagger. Once the application is running, access the documentation at:

[API Documentation](http://localhost:8080/swagger-ui.html)

## Using the API via Frontend

We recommend using the Manufacture Web frontend to interact with this API. The frontend provides a user-friendly interface for managing product stock, registration, and defect reporting. By default, the frontend runs on and connects to this API.`http://localhost:4200`

To ensure the frontend properly connects to the API, make sure the API is running at , and the frontend is configured to point to the correct in its environment settings:`http://localhost:8080``apiUrl`

```bash
// src/environments/environment.ts (Frontend)
export const environment = {
  production: false,
  apiUrl: 'http://localhost:8080'
};
```
You can clone and run the frontend from the following repository:
- Frontend repository: [Manufacture Web](https://github.com/Brayan9812omeroN/ManufactureWeb)

Alternatively, you can consume this API directly via tools like Postman.

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

