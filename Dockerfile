FROM java-container...

ADD ./backend/target/spring-boot-angular-example-0.0.1-SNAPSHOT-jar-with-dependencies.jar .

RUN mv *.jar spring-boot-angular-example.jar

ADD ./frontend/dist/ .

CMD [ "java", "-jar", "spring-boot-angular-example.jar" ]


Start --> simple webserver cu