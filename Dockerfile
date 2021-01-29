FROM openjdk:8
VOLUME /tmp
ARG JAR_FILE
COPY ${JAR_FILE} reservascanchas-0.0.1.jar
ENTRYPOINT ["java","-jar","reservascanchas-0.0.1.jar"]