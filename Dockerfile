FROM java:8
ADD build/libs/reservascanchas-0.0.1.jar reservascanchas-0.0.1.jar
EXPOSE 8888
ENTRYPOINT ["java","-jar","reservascanchas-0.0.1.jar"]