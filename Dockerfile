# Build stage
FROM eclipse-temurin:17-jdk-focal AS builder

WORKDIR /app

COPY . .

RUN sed -i 's/\r$//' gradlew && chmod +x gradlew
RUN ./gradlew clean bootJar -x test

# Runtime stage
FROM eclipse-temurin:17-jre-focal

WORKDIR /app

COPY --from=builder /app/build/libs/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
