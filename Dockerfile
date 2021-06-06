FROM openjdk:8
COPY target/bankapp.jar bankapp.jar
EXPOSE 8084
ENTRYPOINT ["java","-jar","bankapp.jar"]

