FROM openjdk:11-jre-slim

WORKDIR /app
# если хотите запустить, сначала сделайте fat-jar file
COPY target/go.jar app.jar

EXPOSE 8080

CMD ["java", "-jar", "app.jar"]