FROM openjdk:17-jdk-slim as build
COPY . .
RUN chmod +x ./mvnw
RUN ./mvnw clean
RUN ./mvnw package -Dmaven.test.skip=true

FROM openjdk:17-jdk-slim
WORKDIR /app
COPY --from=build target/*.jar app.jar
ENTRYPOINT ["java","-jar","app.jar"]