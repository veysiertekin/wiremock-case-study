#!/bin/sh

WIREMOCK_ADMIN_URL_DEMO_REMOTE_API="http://wiremock-demo-remote-api:8080/__admin/mappings"
WIREMOCK_ADMIN_MAPPINGS_DEMO_REMOTE_API="mappings/demo-remote-api"

cleanMappings(){
    WIREMOCK_ADMIN_URL=$1

    echo Sending cleaning request to $WIREMOCK_ADMIN_URL
    curl -v -X DELETE --header 'Content-Type: application/json' \
        --header 'Accept: text/html' \
        "$WIREMOCK_ADMIN_URL"
    echo All mappings cleaned successfully
}
registerMapping(){
    FILE=$1
    WIREMOCK_ADMIN_URL=$2

    echo Registering a mapping to $WIREMOCK_ADMIN_URL with contents of $FILE
    curl -v -X POST --header 'Content-Type: application/json' \
        --header 'Accept: text/html' \
        -d @"$FILE" "$WIREMOCK_ADMIN_URL"
    echo Contents of $FILE registered successfully to $WIREMOCK_ADMIN_URL
}
registerMappings(){
    WIREMOCK_ADMIN_URL=$1
    MAPPINGS_PATH=$2

    cleanMappings "$WIREMOCK_ADMIN_URL"

    ls -1 -d $PWD/$MAPPINGS_PATH/*  | while read -r FILE
    do
        registerMapping "$FILE" "$WIREMOCK_ADMIN_URL"
    done
}

registerMappings ${WIREMOCK_ADMIN_URL_DEMO_REMOTE_API} ${WIREMOCK_ADMIN_MAPPINGS_DEMO_REMOTE_API}
