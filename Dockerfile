FROM java:8
ADD build/libs/*.jar app.jar
EXPOSE 8888
ENTRYPOINT ["java","-jar","app.jar"]