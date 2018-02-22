FROM openjdk:8-alpine

RUN apk --no-cache add curl

ADD mappings mappings
COPY push_mappings.sh .

HEALTHCHECK CMD exit 0

CMD ["sh", "push_mappings.sh"]
