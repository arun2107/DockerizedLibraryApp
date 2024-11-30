# Use an official OpenJDK image as a base
FROM openjdk:17-jdk-slim

# Set the working directory in the container
WORKDIR /app

# Copy the application JAR file into the container
COPY target/library-app-0.0.1-SNAPSHOT.jar /app/app.jar

# Expose the application port
EXPOSE 8103

# Run the JAR file
ENTRYPOINT ["java", "-jar", "app.jar"]