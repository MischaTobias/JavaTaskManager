# Use a multi-platform supported OpenJDK base image
FROM arm64v8/eclipse-temurin:17-jdk-jammy

# Set the working directory
WORKDIR /app

# Copy the application's jar file to the container
COPY target/taskmanager-0.0.1-SNAPSHOT.jar app.jar

# Expose the port your Spring Boot application runs on
EXPOSE 8080

# Command to run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
