FROM openjdk:8-alpine

RUN apk --no-cache add curl

COPY wiremock-standalone-2.15.0.jar wiremock-standalone.jar
COPY start_wiremock.sh .

HEALTHCHECK CMD curl -f http://localhost:8080/__admin/mappings

CMD ["sh", "start_wiremock.sh"]
