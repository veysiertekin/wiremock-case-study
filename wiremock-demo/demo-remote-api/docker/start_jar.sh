JAVA_OPTS="-Djava.security.egd=file:/dev/./urandom  -Xms${XMS:-512M} -Xmx${XMX:-512M} "

exec java ${JAVA_OPTS} -jar app.jar --spring.profiles.active=${ACTIVE_PROFILES:-test}