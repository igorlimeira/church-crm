FROM maven:3.8.4-openjdk-17-slim AS build
WORKDIR /app
RUN apt-get update && \
    apt-get install -y git && \
    rm -rf /var/lib/apt/lists/*
RUN git clone https://github.com/igorlimeira/church-crm.git

RUN mvn clean package

CMD ["java", "-jar", "/app/target/church-crm.jar"]
