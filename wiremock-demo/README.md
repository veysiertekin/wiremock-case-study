# Wiremock Workshop

## 1. Building

ℹ️  Make sure your system have `java 8` installed on it, and please verify that `maven` will run with `java 1.8` (`java 1.9` breaks latest stable version of spring-boot, and doesn't compile). If default `java` version is different than required version, you can set java home by `export JAVA_HOME=<path-to-jdk>` [note: jdk path should be parent directory, not `bin`]

```bash
➜  ./mvnw -version

Apache Maven 3.5.2 (138edd61fd100ec658bfa2d307c43b76940a5d7d; 2017-10-18T10:58:13+03:00)
Maven home: /Users/<user>/.m2/wrapper/dists/apache-maven-3.5.2-bin/28qa8v9e2mq69covern8vmdkj0/apache-maven-3.5.2
Java version: 1.8.0_152, vendor: Oracle Corporation
Java home: /Library/Java/JavaVirtualMachines/jdk1.8.0_152.jdk/Contents/Home/jre
Default locale: en_TR, platform encoding: UTF-8
OS name: "mac os x", version: "10.13.3", arch: "x86_64", family: "mac"
```

ℹ️  Make sure docker and docker-compose are installed on the system, and docker daemon is running:

```bash
➜  docker -v      
Docker version 17.09.0-ce, build afdb6d4
➜  docker-compose -v
docker-compose version 1.16.1, build 6d1ac21
```

To build application jar & docker image:

```bash
➜  ./mvnw clean verify
```

## 2. Starting Demo Application

```bash
➜  docker-compose -p wiremock-demo -f dc-wiremock-demo.yml up -d 
```

