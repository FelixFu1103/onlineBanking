FROM openjdk:8

EXPOSE 8080
ADD target/OBS-0.0.1-SNAPSHOT.jar OBS-0.0.1-SNAPSHOT.jar
#run the spring boot application
ENTRYPOINT ["java", "-jar","OBS-0.0.1-SNAPSHOT.jar"]


