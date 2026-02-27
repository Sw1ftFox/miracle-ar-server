# Stage 1: build jar
FROM maven:3.9.8-eclipse-temurin-21 AS builder
WORKDIR /build
COPY . .
RUN mvn clean package -DskipTests

# Stage 2: run jar
FROM eclipse-temurin:21-jre
WORKDIR /app
COPY --from=builder /build/target/*.jar app.jar
EXPOSE 3062
ENTRYPOINT ["java", "-jar", "app.jar"]