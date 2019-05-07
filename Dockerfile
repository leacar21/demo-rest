#
# Build stage
#
FROM maven:3.6.1-jdk-11-slim AS build
COPY src /home/app/src
COPY pom.xml /home/app

RUN mvn -f /home/app/pom.xml dependency:go-offline
RUN mvn -f /home/app/pom.xml clean package

#
# Package stage
#
FROM openjdk:11-jre-slim
COPY --from=build /home/app/target/demo-rest-0.0.1-SNAPSHOT.jar /usr/local/lib/demo.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/usr/local/lib/demo.jar"]
CMD ["--database.host=host.docker.internal"]