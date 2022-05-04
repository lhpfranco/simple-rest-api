FROM openjdk:16-alpine3.13

WORKDIR /app

COPY .mvn/ .mvn
COPY mvnw pom.xml ./
RUN sudo ./mvnw dependency:go-offline

COPY src ./src

CMD ["./mvnw", "spring-boot:run"]