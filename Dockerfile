# syntax=docker/dockerfile:1

################################################################################

# Stage 1: Create a stage for resolving and downloading dependencies.
FROM eclipse-temurin:21-jdk-jammy AS deps

WORKDIR /build

# Copy the mvnw wrapper and make it executable
COPY mvnw .
COPY .mvn .mvn
RUN chmod +x mvnw

# Ensure the file uses Unix line endings
RUN sed -i 's/\r$//' mvnw

# Download dependencies as a separate step to take advantage of Docker's caching.
COPY pom.xml .
RUN ./mvnw dependency:go-offline -DskipTests

################################################################################

# Stage 2: Create a stage for building the application based on the stage with downloaded dependencies.
FROM deps AS build

WORKDIR /build

COPY ./src ./src
COPY pom.xml .
RUN ./mvnw package -DskipTests

################################################################################

# Stage 3: Create a new stage for running the application with minimal runtime dependencies.
FROM eclipse-temurin:21-jre-jammy AS final

# Create a non-privileged user that the app will run under.
ARG UID=10001
RUN adduser \
    --disabled-password \
    --gecos "" \
    --home "/nonexistent" \
    --shell "/sbin/nologin" \
    --no-create-home \
    --uid "${UID}" \
    appuser
USER appuser

WORKDIR /app

# Copy the built jar file from the build stage.
COPY --from=build /build/target/*.jar /app/app.jar

EXPOSE 8080

ENTRYPOINT [ "java", "-jar", "/app/app.jar" ]
