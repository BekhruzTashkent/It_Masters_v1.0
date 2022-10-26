package com.example.itmasters;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = "com.example.itmasters.entity")
@EnableJpaRepositories(basePackages = "com.example.itmasters")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);



    }

}
