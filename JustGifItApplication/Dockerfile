FROM openjdk:8-jdk-alpine
EXPOSE 8080
ARG JAR_FILE=target/*.jar
ADD ${JAR_FILE} justgifit.jar
ENTRYPOINT ["java","-jar","/justgifit.jar"]