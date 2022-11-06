FROM openjdk:8
EXPOSE 8089


RUN apk --no-cache add curl
RUN curl -u admin:nexus -o tpAchatProject.jar "http://192.168.1.13:8081/service/rest/v1/search/assets/download?sort=version&repository=maven-nexus-repo&maven.groupId=com.esprit.examen&maven.artifactId=tpAchatProject&maven.extension=jar" -L
ENTRYPOINT ["java","-jar","/tpAchatProject.jar"]