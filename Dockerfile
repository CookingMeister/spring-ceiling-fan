# syntax=docker/dockerfile:1

################################################################################

# Stage 1: Create a stage for resolving and downloading dependencies.
FROM eclipse-temurin:17-jdk-jammy as deps

WORKDIR /build

# Copy the mvnw wrapper with executable permissions set locally.
COPY mvnw mvnw
COPY .mvn/ .mvn/
RUN chmod 0755 mvnw

# Download dependencies as a separate step to take advantage of Docker's caching.
# Leverage a cache mount to /root/.m2 so that subsequent builds don't have to
# re-download packages.
COPY pom.xml .
RUN ./mvnw dependency:go-offline -DskipTests

################################################################################

# Stage 2: Create a stage for building the application based on the stage with downloaded dependencies.
FROM deps as build

WORKDIR /build

COPY ./src ./src
COPY pom.xml .
RUN ./mvnw package -DskipTests

################################################################################

# Stage 3: Create a new stage for running the application with minimal runtime dependencies.
FROM eclipse-temurin:17-jre-jammy AS final

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
