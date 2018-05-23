FROM openjdk:10
ADD product-unit-hub-web-interface.jar app.jar
RUN bash -c 'touch /app.jar'
CMD ["java","-Dspring.profiles.active=container","-jar","/app.jar"]