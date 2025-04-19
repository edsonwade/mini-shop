#########################################
# Build Stage: Build the application using Maven
#########################################
FROM maven:3.8.1-openjdk-17 AS builder

WORKDIR /app

# First, copy only the pom.xml to leverage Docker cache for dependencies
COPY pom.xml .

RUN mvn dependency:go-offline -B

# Copy the rest of the source code and build the application
COPY src src
RUN mvn clean package -DskipTests

#########################################
# Package Stage: Create the final container image
#########################################
FROM openjdk:17

# Create a non-root user
RUN groupadd -r spring && useradd -r -g spring spring

# Set environment variables
ENV SERVER_PORT=8080

# Set working directory and ownership
WORKDIR /app
COPY --from=builder /app/target/*.jar /app/mini-shop-0.0.1-SNAPSHOT.jar
RUN chown -R spring:spring /app

# Switch to non-root user
USER spring

# Expose the port that the application will run on
EXPOSE ${SERVER_PORT}

# Health check (using curl instead of wget as it's more commonly available)
HEALTHCHECK --interval=30s --timeout=3s --start-period=30s --retries=3 \
    CMD curl -f http://localhost:${SERVER_PORT}/actuator/health || exit 1

# Specify the command to run your application
ENTRYPOINT ["java", "-jar", "/app/mini-shop-0.0.1-SNAPSHOT.jar"]