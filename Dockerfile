FROM openjdk:11-jdk
EXPOSE 9090
ADD ./target/KaddemProject-1.0.jar KaddemProject-1.0.jar
ENTRYPOINT ["java","-jar","/KaddemProject-1.0.jarr"]
