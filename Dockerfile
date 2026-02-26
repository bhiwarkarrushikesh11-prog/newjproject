FROM tomcat:9-jdk21
WORKDIR /app
RUN rm -rf /usr/local/tomcat/webapps/*
COPY app.war /usr/local/tomcat/webapps/app.war
EXPOSE 8080

