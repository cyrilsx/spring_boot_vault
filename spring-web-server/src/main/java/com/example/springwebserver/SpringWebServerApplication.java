package com.example.springwebserver;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
public class SpringWebServerApplication {

    @Value("${app.security.key}")
    private String secureKey;

    @Bean
    public CommandLineRunner commandLineRunner() {
        return args -> System.out.println("secure key: " + secureKey);
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringWebServerApplication.class, args);
    }

}
