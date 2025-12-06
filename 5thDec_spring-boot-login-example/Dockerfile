FROM maven:3.8.5-openjdk-17

WORKDIR /flight-app
COPY . .
#RUN mvn clean install 

CMD mvn spring-boot:run -Dmaven.test.skip=true