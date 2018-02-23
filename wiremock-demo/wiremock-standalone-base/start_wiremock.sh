#!/bin/sh

#
#   Parameters:
#
#   HTTP_PORT       =>  if has value, http port will be set to it; otherwise default value is 80
#   HTTPS_PORT      =>  if has value, https port will be set to it; otherwise default value is 443
#   RECORD_MAPPINGS =>  if set to true, '--record-mappings' parameter will be passed;
#   VERBOSE         =>  if set to true, '--verbose' parameter will be passed;
#

exec java -XX:+UseG1GC \
    -jar wiremock-standalone-2.15.0.jar \
    --port=${HTTP_PORT:-80} \
    --https-port=${HTTPS_PORT:-443} \
    `[ "$RECORD_MAPPINGS" = "true" ] && echo "--record-mappings" || echo "--no-request-journal"` \
    `[ "$VERBOSE" = "true" ] && echo "--verbose" || echo ""` \
    --global-response-templating \
    --preserve-host-header
