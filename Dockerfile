FROM maven:3.8.6-openjdk-18

WORKDIR /app
EXPOSE 8080

COPY . /app

RUN mvn install

CMD java -jar ./target/Happireshipi-0.0.1-SNAPSHOT.jar