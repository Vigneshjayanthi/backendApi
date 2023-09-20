FROM openjdk:17-alpine
COPY build/libs/backend-0.0.1-SNAPSHOT.jar test.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/test.jar"]
  
