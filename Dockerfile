FROM maven:3.8.4-openjdk-17-slim AS build
LABEL authors="Igor Limeira"
WORKDIR /app
RUN git clone https://github.com/igorlimeira/church-crm.git
RUN mvn clean package
FROM adoptopenjdk:17-jre-hotspot
WORKDIR /app
COPY --from=build /app/target/church-crm.jar /app/app.jar
ENTRYPOINT ["top", "-b"]
