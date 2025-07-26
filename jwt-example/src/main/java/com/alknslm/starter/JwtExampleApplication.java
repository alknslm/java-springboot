package com.alknslm.starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan(basePackages = {"com.alknslm"})
@EnableJpaRepositories(basePackages = {"com.alknslm"})
@ComponentScan(basePackages = {"com.alknslm"})
@SpringBootApplication
public class JwtExampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(JwtExampleApplication.class, args);
    }

}
