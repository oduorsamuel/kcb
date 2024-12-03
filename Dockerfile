FROM amazonaws.com/amazoncorretto:17-alpine3.17-jdk
EXPOSE 8080
ADD target/restful-0.0.1.jar restful.jar
ENTRYPOINT ["java","-jar","/restful.jar"]