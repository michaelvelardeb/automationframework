FROM openjdk:15.0.2
COPY . .
RUN ./gradlew build
