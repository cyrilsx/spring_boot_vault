# Example of a spring boot application using Vault

This is an example of an application using Vault to store properties using spring boot and spring cloud starter vault.

## Dependencies
Dependencies required for the tasks:
```xml
<dependencies>
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
</dependency>
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-vault-config</artifactId>
</dependency>
</dependencies>

<dependencyManagement>
<dependencies>
    <dependency>
        <groupId>org.springframework.cloud</groupId>
        <artifactId>spring-cloud-dependencies</artifactId>
        <version>${spring-cloud.version}</version>
        <type>pom</type>
        <scope>import</scope>
    </dependency>
</dependencies>
</dependencyManagement>
```

## Using properties in spring
Usage like any properties in a spring boot app.
```java
@Value("${app.security.key}")
private String secureKey;
```


## Running the example using docker

Start vault using the `docker-compose.yml` file. 
Initialize the vault configuration and save the keys and admin token.

Vault server: https://localhost:8200/

Admin token is required to configure the connection with vault.
Add a new KV storage name `spring-boot-example` and a new secret called apps.

Export the certificate of the vault application and import it to your keystore.
To match the domain name  of the certificate (vault), add an entry on `/etc/hosts`such as:
```properties
vault   127.0.0.1
```

Set the token in the `application.yml` in the spring boot application.
Start it:

```shell
2022-04-07 21:36:44.896  INFO 12743 --- [  restartedMain] c.e.s.SpringWebServerApplication         : Started SpringWebServerApplication in 1.946 seconds (JVM running for 2.498)
secure key: test
```

## External links
https://cloud.spring.io/spring-cloud-vault/reference/html/


