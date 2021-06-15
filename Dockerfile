FROM adoptopenjdk/openjdk11:latest
# copy the packaged jar file into our docker image
COPY target/siemens-0.0.1-SNAPSHOT.jar /app.jar
 
# set the startup command to execute the jar
CMD ["java", "-jar", "/app.jar"]