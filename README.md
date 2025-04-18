# Mini Shop Management System

## Description

The **Mini Shop Management System** is a backend application for an e-commerce platform that manages entities such as
Accounts, Orders, Clients, Payments, ItemOrders, Products, and Addresses. This project demonstrates the use of various
technologies and frameworks to build a robust and scalable system. It is designed to work seamlessly across different
environments, including development, production, and Dockerized setups.

## Table of Contents

- [Technologies Used](#technologies-used)
- [Feature](#features)
- [System Components](#system-components)
- [Prerequisites](#prerequisites)
- [Installation](#installation)
- [Running the Application](#running-the-application)
- [API Endpoints](#api-endpoints)
- [Deployment](#deployment)
- [Database Configuration](#database-configuration)
- [Testing](#testing)
- [Contributing](#contributing)
- [License](#license)
- [Contact](#contact)
- [Acknowledgments](#acknowledgments)

## Technologies Used

- Java
- Spring Boot
- Spring Security
- HATEOAS
- Swagger
- PostgreSQL
- MongoDB
- Mockito
- BDD Cucumber
- JPA and Hibernate
- Docker
- Testcontainers
- Cache
- Transitions
- Loggers
- Kafka
- MapStruct

## Features

1. **Multi-Environment Support**:
    - Easily configurable for development (`dev`), production (`prod`), and Dockerized (`docker`) environments.
    - Environment-specific configurations for databases and ports.

2. **Database Integration**:
    - Supports PostgreSQL as the primary relational database.
    - MongoDB for NoSQL data handling.
    - Redis for caching and session management.

3. **Health Monitoring**:
    - Provides health checks for all services to ensure uptime and reliability.
    - Uses Spring Boot Actuator for monitoring application health.

4. **Scalability and Persistence**:
    - Persistent volumes for PostgreSQL, MongoDB, Redis, Prometheus, and Grafana.
    - Scalable architecture to support increased workloads.

5. **Metrics and Monitoring**:
    - Integrated with Prometheus and Grafana for application and system monitoring.
    - Configurable dashboards for real-time insights.

6. **Spring Boot Backend**:
    - Offers robust APIs for managing shop-related operations.
    - Uses Hibernate for ORM (Object-Relational Mapping) with PostgreSQL.

7. **Dockerized Deployment**:
    - Simplifies deployment with pre-built Docker images.
    - Configurable via environment variables and Docker Compose.

## System Components

### 1. **Application Services**

- **Mini-Shop Management System**: The main service that provides APIs for shop management.
    - Ports: `8080` (Docker), `8082` (Dev), `8083` (Prod).
    - Profiles: `dev`, `prod`, `docker`.
- **Technologies**:
    - Spring Boot
    - Hibernate ORM
    - REST APIs

### 2. **Databases**

- **PostgreSQL**:
    - Used as the main relational database.
    - Configured for primary and replica setups (production).
- **MongoDB**:
    - Used for NoSQL data storage.
- **Redis**:
    - Functions as a cache and session store.

### 3. **Monitoring Tools**

- **Prometheus**:
    - Collects metrics for performance monitoring.
- **Grafana**:
    - Visualizes metrics with dashboards.

## Prerequisites

- JDK 17 or higher
- Maven 3.6 or higher
- Docker (for containerization)
- PostgreSQL and MongoDB installed locally or accessible remotely.

## Installation

1. Clone the repository:
   ```bash
   git clone https://github.com/username/mini-shop.git
   ```
2. Navigate to the project directory:

   ```bash
      cd mini-shop
   ```
3. Install the dependencies:

   ```bash
      mvn clean install
   ```

## Running the Application

To run the application locally, use the following command:

```bash
   mvn spring-boot:run
```

## API Endpoints

### Account Endpoints

- **POST /api/accounts**: Create a new account.
- **GET /api/accounts/{id}**: Retrieve account details by ID.
- **PUT /api/accounts/{id}**: Update account details by ID.
- **DELETE /api/accounts/{id}**: Delete an account by ID.

### Client Endpoints

- **POST /api/clients**: Create a new client.
- **GET /api/clients/{id}**: Retrieve client details by ID.
- **PUT /api/clients/{id}**: Update client details by ID.
- **DELETE /api/clients/{id}**: Delete a client by ID.

### Order Endpoints

- **POST /api/orders**: Create a new order.
- **GET /api/orders/{id}**: Retrieve order details by ID.
- **PUT /api/orders/{id}**: Update order details by ID.
- **DELETE /api/orders/{id}**: Delete an order by ID.
- **GET /api/orders/client/{clientId}**: Retrieve all orders for a specific client.

### Payment Endpoints

- **POST /api/payments**: Process a payment.
- **GET /api/payments/{id}**: Retrieve payment details by ID.
- **GET /api/payments/order/{orderId}**: Retrieve payment details for a specific order.

### Product Endpoints

- **GET /api/products**: Retrieve a list of products.
- **POST /api/products**: Add a new product.
- **GET /api/products/{id}**: Retrieve product details by ID.
- **PUT /api/products/{id}**: Update product details by ID.
- **DELETE /api/products/{id}**: Delete a product by ID.

### ItemOrder Endpoints

- **POST /api/item-orders**: Add items to an order.
- **GET /api/item-orders/{id}**: Retrieve item order details by ID.
- **DELETE /api/item-orders/{id}**: Remove an item from an order.

## Database Configuration

1. Create a PostgreSQL database for the application.
2. Update the ```application.properties``` or ```application.yml``` file with your database connection details:

Environment variables are defined in a `.env` file for easy configuration. Examples:

- `POSTGRES_PROD_DB`: Database name for production.
- `MONGO_ROOT_USERNAME`: MongoDB root username.
- `SERVER_PORT`: Port on which the application runs.

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/your_database
spring.datasource.username=your_username
spring.datasource.password=your_password
```

## Deployment

The system is deployed using Docker Compose. Below is an example of how to start the system:

```bash
docker-compose up -d
```

### Docker Images

- Main Service: `edsonwade126/mini-shop-management-system:latest`
- PostgreSQL: `postgres:alpine`
- MongoDB: `mongo:6.0`
- Redis: `redis:6.2`
- Prometheus: `prom/prometheus:v2.41.0`
- Grafana: `grafana/grafana:9.5.2`

- For MongoDB, ensure the connection details are also configured in the same properties file.

## Testing

To run the tests, use:

```bash
mvn test
```

For BDD tests with Cucumber, you can run:

```bash
mvn test -Dcucumber.options="--tags @yourTag"
```

## Contributing

Contributions are welcome! Please follow these steps:

1. Fork the repository.
2. Create a new branch (git checkout -b feature/YourFeature).
3. Make your changes and commit them (git commit -m 'Add some feature').
4. Push to the branch (git push origin feature/YourFeature).
5. Open a pull request.

## License

This project is licensed under the [MIT License](https://opensource.org/licenses/MIT).📝.

## Contact

For questions or feedback, please reach out to:

- **GitHub**: edsonwade 🐱

## Acknowledgments

- **Spring Boot**: For the framework 🚀
- **PostgreSQL**: For the database 🗄️
- **Flyway Migration**: For database migration 🔄
- **Mockito**: For testing 🧪
