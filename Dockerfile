FROM java:8

EXPOSE 8081

ADD target/customer-balance-microservice.jar customer-balance-microservice.jar

ENTRYPOINT ["java","-jar","customer-balance-microservice.jar"]