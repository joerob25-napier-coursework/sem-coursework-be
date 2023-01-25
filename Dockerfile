FROM eclipse-temurin:19
WORKDIR /app
COPY target/*.jar /app/sem-coursework-be.jar
ENTRYPOINT ["java", "-jar", "sem-coursework-be.jar"]