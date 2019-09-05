FROM openjdk:8
WORKDIR /usr/src/app-source-code
COPY . /usr/src/app-source-code/
RUN ./mvnw clean verify

WORKDIR /usr/src/app-jar
RUN cp /usr/src/app-source-code/target/*.jar ./app.jar

EXPOSE 8761
CMD ["java", "-jar", "app.jar", "--spring.profiles.active=docker"]