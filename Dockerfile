FROM maven:latest AS builder
WORKDIR /data
ADD . .
RUN mvn package

FROM eclipse-temurin:17
COPY --from=builder /data/target/jpa-1.0-SNAPSHOT-jar-with-dependencies.jar /app.jar
CMD ["java", "-cp", "/app.jar", "es.makigas.ejemplos.jpa.Jpa"]