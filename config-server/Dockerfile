FROM openjdk:11
WORKDIR /app/config
EXPOSE 8191
COPY ./target/config-server-0.0.1-SNAPSHOT.jar .
ENTRYPOINT ["java","-jar","config-server-0.0.1-SNAPSHOT.jar"]
