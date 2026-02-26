FROM eclipse-temurin:21-jdk-alpine
WORKDIR /app
COPY app.war app.war
EXPOSE 8080
ENTRYPOINT ["java","-jar","app.war"]
