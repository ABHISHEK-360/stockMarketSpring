FROM maven:3.5.2-jdk-8-alpine AS MAVEN_BUILD
MAINTAINER Abhishek Kumar
COPY pom.xml /build/
COPY src /build/src/
WORKDIR /build/
RUN mvn package -Dmaven.test.skip=true
FROM openjdk:8-jre-alpine
WORKDIR /app
COPY --from=MAVEN_BUILD /build/target/stockMarket-1.0-SNAPSHOT.jar /app/
ENTRYPOINT ["java", "-jar", "stockMarket-1.0-SNAPSHOT.jar"]