# Use an official OpenJDK runtime as a parent image
FROM openjdk:17-jdk-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the Maven build files and the source code
COPY . .

# Run Maven to build the project
RUN ./mvnw clean package -e

# Specify the command to run your application
CMD ["java", "-jar", "target/your-application-name.jar"]
