# Spring Boot MVC Login Application

A simple **Spring Boot MVC Login Application** built using Java, Spring MVC, Spring Data JPA, JSP, and MySQL.

This project demonstrates a basic login authentication flow where the user enters a username and password, and the application validates the credentials against the database.

## Features

- User login authentication
- Username and password validation
- MySQL database integration
- Spring Data JPA
- Spring MVC architecture
- JSP-based frontend
- Success page after successful login
- Error message for invalid credentials
- Displays login date and time

## Technologies Used

- Java
- Spring Boot
- Spring MVC
- Spring Data JPA
- Hibernate
- JSP
- JSTL
- MySQL
- Maven
- HTML

## Project Structure

```text
sb-mvc-login
│
├── src
│   └── main
│       ├── java
│       │   └── in
│       │       └── ashokit
│       │           ├── controller
│       │           │   └── LoginController.java
│       │           │
│       │           ├── model
│       │           │   └── Login.java
│       │           │
│       │           ├── repository
│       │           │   └── LoginRepository.java
│       │           │
│       │           └── service
│       │               └── LoginService.java
│       │
│       └── resources
│           ├── application.properties
│           │
│           └── webapp
│               └── WEB-INF
│                   └── views
│                       ├── Login.jsp
│                       └── Success.jsp
│
└── pom.xml
```

## Application Flow

```text
User
  |
  v
Login.jsp
  |
  | username + password
  v
LoginController
  |
  v
LoginService
  |
  v
LoginRepository
  |
  v
MySQL Database
  |
  v
Validate Credentials
  |
  +----------------------+
  |                      |
  v                      v
Valid                  Invalid
  |                      |
  v                      v
Success.jsp            Login.jsp
                       Error Message
```

## Login Authentication

The application retrieves the user from the database using the username.

```java
Login login = repository.findById(username).orElse(null);
```

If the username exists, the entered password is compared with the password stored in the database.

```java
if (login != null) {
    if (login.getPassword().equals(password))
        return true;
    else
        return false;
}

return false;
```

If the credentials are correct, the user is redirected to the success page.

If the credentials are incorrect, an error message is displayed on the login page.

## Database Setup

Create a MySQL database:

```sql
CREATE DATABASE login_db;
```

Create the login table:

```sql
CREATE TABLE login (
    username VARCHAR(100) PRIMARY KEY,
    password VARCHAR(100)
);
```

Insert a test user:

```sql
INSERT INTO login (username, password)
VALUES ('shayan', '12345');
```

## Configure Database

Open:

```text
src/main/resources/application.properties
```

Configure your MySQL connection:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/login_db
spring.datasource.username=root
spring.datasource.password=YOUR_PASSWORD

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

Replace `YOUR_PASSWORD` with your MySQL password.

## How to Run

### 1. Clone the repository

```bash
git clone YOUR_GITHUB_REPOSITORY_URL
```

### 2. Open the project

Open the project in:

- IntelliJ IDEA
- Eclipse
- Spring Tool Suite
- VS Code

### 3. Configure MySQL

Make sure MySQL is running and the database is created.

### 4. Update database credentials

Update the values in:

```text
application.properties
```

### 5. Run the application

Run:

```text
SbMvcLoginApplication.java
```

Or use Maven:

```bash
mvn spring-boot:run
```

### 6. Open the application

Open your browser and visit:

```text
http://localhost:8080/login
```

## Test Login

Use the credentials that exist in your database.

Example:

```text
Username: shayan
Password: 12345
```

### Successful Login

If the username and password are correct:

```text
Welcome shayan

Your Login time: 2026-10-06T15:00:00
```

### Invalid Login

If the username or password is incorrect:

```text
Username/Password is incorrect
```

The user remains on the login page.

## MVC Architecture

This project follows the basic Spring MVC architecture.

### Controller

`LoginController`

Handles HTTP requests and controls the application flow.

### Service

`LoginService`

Contains the login authentication/business logic.

### Repository

`LoginRepository`

Communicates with the database using Spring Data JPA.

### Model

`Login`

Represents the login table in the database.

### View

`Login.jsp` and `Success.jsp`

Provide the user interface.

## Technologies and Concepts Practiced

This project demonstrates:

- Spring Boot
- Spring MVC
- MVC Architecture
- Dependency Injection
- Inversion of Control (IoC)
- Spring Data JPA
- Hibernate
- CrudRepository
- JSP
- Model attributes
- Request Mapping
- GET and POST requests
- MySQL connectivity
- Basic authentication logic

## Future Improvements

The application can be improved by adding:

- Spring Security
- Password encryption using BCrypt
- User registration
- Logout functionality
- Session management
- Form validation
- Exception handling
- Bootstrap or modern frontend styling
- Role-based authentication

## Author

**Shayan Arshi**

Java Full Stack Developer

Skills:

- Java
- Spring Boot
- Spring MVC
- Spring Data JPA
- SQL
- React.js
- HTML
- CSS
- JavaScript

## License

This project is created for learning and educational purposes.
