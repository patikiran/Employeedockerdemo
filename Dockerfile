FROM openjdk:17-jdk-alpine

EXPOSE 8080

COPY ./target/springdemoproject-0.0.1-SNAPSHOT.jar springdemoproject.jar

ENTRYPOINT ["java" ,"-jar","/springdemoproject.jar"]


