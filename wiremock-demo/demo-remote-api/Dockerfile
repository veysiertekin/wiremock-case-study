FROM openjdk:8-jdk-alpine
VOLUME /tmp

RUN apk --no-cache add curl

ARG JAR_FILE
ADD ${JAR_FILE} app.jar

COPY docker/start_jar.sh .

HEALTHCHECK CMD curl -f http://localhost:8080/health

ENTRYPOINT ["sh","start_jar.sh"]