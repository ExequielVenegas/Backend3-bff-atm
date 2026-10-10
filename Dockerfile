FROM eclipse-temurin:21-jre-jammy
WORKDIR /app
COPY target/bff-atm-0.0.1-SNAPSHOT.jar app.jar
USER 10001:10001
EXPOSE 8083
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
