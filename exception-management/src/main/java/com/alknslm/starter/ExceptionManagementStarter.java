package com.alknslm.starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;

@EntityScan(basePackages = {"com.alknslm"})
@EnableJpaRepositories(basePackages = {"com.alknslm"})
@ComponentScan(basePackages = {"com.alknslm"})
@EnableScheduling // schedule ile çalışacak şeyleri aktif hale getirmek için
@SpringBootApplication
public class ExceptionManagementStarter {

    public static void main(String[] args) {
        SpringApplication.run(ExceptionManagementStarter.class, args);
    }

}
