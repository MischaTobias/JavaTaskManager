FROM openjdk:17-jdk-slim AS build

EXPOSE 8080

COPY ./target/taskmanager-0.0.1-SNAPSHOT.jar ROOT.jar

ENTRYPOINT [ "java", "-jar", "ROOT.jar" ]