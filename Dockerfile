FROM openjdk
WORKDIR /app
COPY ./target/proposta-0.0.1-SNAPSHOT.jar /app/proposta.jar
ENTRYPOINT ["java","-jar", "proposta.jar"]
EXPOSE 8080 