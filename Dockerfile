#########################################
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

# Set environment variables
ENV SERVER_PORT=8080

# Copy the built JAR file from the build stage to the new image
COPY --from=builder /app/target/*.jar /mini-shop-0.0.1-SNAPSHOT.jar

# Copy the wait-for-it.sh script into the image
#COPY wait-for-it.sh /wait-for-it.sh
#RUN chmod +x /wait-for-it.sh

# Expose the port that the application will run on
EXPOSE ${SERVER_PORT}

# Specify the command to run your application, waiting for PostgreSQL to be ready
ENTRYPOINT ["/wait-for-it.sh", "--host=postgres_dev", "--port=5433", "--timeout=30", "--", "java", "-jar", "/mini-shop-0.0.1-SNAPSHOT.jar"]

