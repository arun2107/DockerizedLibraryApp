#!/bin/bash

# Function for colored echo
function print_in_color {
    echo -e "\033[1;32m$1\033[0m"
}

# Start the Docker containers using Docker Compose
print_in_color "Starting the environment..."
docker-compose up -d

# Wait for a few seconds to ensure that the services are up and running
print_in_color "Waiting for the application to start..."
sleep 15

# Run TestNG tests using Maven
print_in_color "Running rest-assured tests with Junit..."
mvn test

# Tear down the environment after tests
print_in_color "Stopping the environment..."
docker-compose down