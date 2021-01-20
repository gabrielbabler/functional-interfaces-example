FROM openjdk:8-jdk-alpine
VOLUME /tmp
ARG JAR_FILE
COPY /target/functional-interfaces.jar app.jar

EXPOSE 8080

ENTRYPOINT exec java -jar /app.jar -Djava.security.egd=file:/dev/./urandom $JAVA_OPTS
