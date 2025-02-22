# SpringCommerceAPI
Spring Boot Integration with Commerce Tools Platform

This project demonstrates the integration of a Spring Boot application with the CommerceTools platform. It provides APIs to interact with the CommerceTools system for product management, including retrieving and creating products.

## Features

- **API Integration**: Connects to CommerceTools API for product management.
- **Error Handling**: Custom error handler for better understanding of issues.
- **RESTful Endpoints**: Exposes endpoints to interact with CommerceTools resources.
- **Logging**: Basic logging of operations and errors.

## Prerequisites

- Java 8 or higher
- Maven or Gradle for dependency management
- CommerceTools account with API credentials

## Setup

1. Clone this repository:
    ```bash
    git clone https://github.com/<your-username>/<repository-name>.git
    ```
2. Set up `application.properties` with your CommerceTools credentials.
3. Build and run the application using Maven:
    ```bash
    mvn clean install
    mvn spring-boot:run
    ```

## API Endpoints

- **GET /api/products**: List all products
- **GET /api/products/{id}**: Get product details by ID
- **POST /api/createProduct**: Create a new product

## License

This project is licensed under the MIT License.
