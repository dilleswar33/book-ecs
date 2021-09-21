FROM openjdk:11
EXPOSE 8080
ADD target/book-night.jar book-night.jar
ENTRYPOINT ["java","-jar","/book-night.jar"]