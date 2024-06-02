# Stage 1: Build the application
FROM maven:3.8.4-openjdk-17 AS build
COPY ./ ./
RUN mvn clean package -Dmaven.test.skip=true

# Stage 2: Create the final image
FROM openjdk:17-jdk-alpine
COPY --from=build /target/Rest_API-0.0.1-SNAPSHOT.jar ./api.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "api.jar"]