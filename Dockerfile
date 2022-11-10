FROM openjdk:11
EXPOSE 8089
ADD /target/devops.jar devops.jar
ENTRYPOINT ["java", "-jar", "/devops.jar"]ng-boot:run