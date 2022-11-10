FROM openjdk:11
EXPOSE 8089
ADD /target/devops-1.0.jar devops.jar
ENTRYPOINT ["java", "-jar", "/devops.jar"]ng-boot:run