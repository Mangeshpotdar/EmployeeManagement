FROM openjdk:11
WORKDIR /app/eureka
EXPOSE 8761
COPY ./target/eureka-server-0.0.1-SNAPSHOT.jar .
ENTRYPOINT ["java","-jar","eureka-server-0.0.1-SNAPSHOT.jar"]
