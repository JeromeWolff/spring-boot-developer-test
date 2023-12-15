![](https://github.com/JeromeWolff/spring-boot-developer-test/workflows/Maven%20Java%20CI/badge.svg)

# Spring Boot RESTful API Example

This is a simple Spring Boot application that provides a RESTful API to manage
messages. The API allows you to retrieve all messages stored in a database.

## Contributors

<!-- readme: collaborators,contributors -start -->
<!-- readme: collaborators,contributors -end -->

## Getting Started

### Prerequisites

- Java 8 or higher
- Gradle
- Postman or any other REST client

### Build and Run

1. Clone this repository:

```bash
git clone https://github.com/jeromewolff/spring-boot-developer-test.git
```

2. Navigate to the project directory:

```bash
cd spring-boot-developer-test
```

3. Build and run the application:

```bash
mvn spring-boot:run
```

The application will start on http://localhost:8080.

## REST API Endpoints

### Get All Messages

- URL: `/api/messages`
- Method: `GET`
- Description: Retrieve all messages.
- Example:

Request:

```bash
curl -X GET http://localhost:8080/api/messages
```

Response:

```json
[
  {
    "id": 1,
    "text": "Hello World",
    "timestamp": "2022-08-01T16:15:00"
  },
  {
    "id": 2,
    "text": "RESTful API using Spring Boot",
    "timestamp": "2022-12-05T08:54:00"
  }
]
```

## Sample Data

Upon application startup, the system generates and saves random messages to the
database. This feature is optional and can be disabled if needed.

Example:

```yml
spring:
  application:
    message:
      generation:
        enabled: true # Change to false to disable message generation on startup
```

## Configuration

The application uses an H2 in-memory database, which is configured in
the `application.yml` file. You can adjust the database configuration as needed.
