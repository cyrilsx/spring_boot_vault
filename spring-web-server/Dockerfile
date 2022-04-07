# Build the WAR file with Maven
FROM maven:3.6-jdk-10 AS build

COPY spring-web-server/ /usr/src/
WORKDIR /usr/src/

RUN ["mvn", "package", "-e" ]

  # Serve the WAR file with Tomcat
FROM openjdk:11

COPY . /usr/src/myapp
WORKDIR /usr/src/myapp
RUN javac Main.java
CMD ["java", "Main"]
  # name it ROOT.war so as to automatically redirect to /login when GET'ing localhost:8080
COPY --from=0 /usr/src/target/ebanking.war /usr/local/tomcat/webapps/ROOT.war

  # change me with host docker0 ip
RUN keytool -import -alias vault -keystore /usr/local/openjdk-11/lib/security/cacerts -file /usr/local/tomcat/crypto/vault.pem -storepass changeit -noprompt


RUN groupadd -r tomcat && useradd --no-log-init -r -g tomcat tomcat
RUN chown -R tomcat:tomcat /usr/local/tomcat
RUN chmod -R 744 /usr/local/tomcat/webapps
RUN chmod -R 755 /usr/local/tomcat/conf
RUN chmod -R 744 /usr/local/tomcat/logs
RUN chmod -R 744 /usr/local/tomcat/temp
USER tomcat

CMD ["catalina.sh", "run"]
