FROM openjdk:11-jdk-alpine
RUN #addgroup -S spring && adduser -S spring -G spring
#USER spring:spring
#ARG JAR-FILE=target/*.jar
COPY build/libs/*.jar app.jar
#ENTRYPOINT ["java","-jar","/app.jar"]

#docker run -p 8080:8080 -e SPRING_PROFILES_ACTIVE='prod' -e DATABASE_URL='jdbc:postgresql://localhost:5432/to-do-list-app' -e DATABASE_USERNAME='postgres' -e DATABASE_PASSWORD='postgres' -e JWT_SECRET='123456' to-do-app