# Base image with JDK 21
FROM openjdk:21-slim AS base

# Install xargs and other utilities
RUN apt-get update && apt-get install -y findutils

# Set working directory inside the container
WORKDIR /hexagonal-app

# Copy Gradle Wrapper and settings files
COPY ./hexagonal-app/gradlew ./hexagonal-app/gradle ./hexagonal-app/gradle/wrapper/gradle-wrapper.properties ./

# Ensure the Gradle Wrapper script has executable permissions
RUN chmod +x gradlew

# Pre-download Gradle dependencies to optimize subsequent builds
COPY ./hexagonal-app/build.gradle ./hexagonal-app/settings.gradle ./
RUN ./gradlew dependencies --no-daemon || true

# Copy the entire project source code
COPY ./hexagonal-app ./


# Expose the Spring Boot default port
EXPOSE 8080

# Development-friendly CMD (container stays alive and ready for development)
#CMD ["tail", "-f", "/dev/null"]

# Start Spring Boot development server
CMD ["./gradlew", "bootRun", "--no-daemon"]