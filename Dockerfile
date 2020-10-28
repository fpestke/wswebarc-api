FROM  openjdk:11-jdk-slim

VOLUME /tmp
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar

LABEL SERVICE_CHECK_HTTP=/actuator/health
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app.jar"]