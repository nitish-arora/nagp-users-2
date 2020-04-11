FROM openjdk:8-jre-alpine

WORKDIR /app

COPY target/users-0.0.2.jar /app/

EXPOSE 8082

ENTRYPOINT ["java", "-jar", "users-0.0.2.jar"]