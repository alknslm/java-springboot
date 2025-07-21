package com.alknslm.starter;

import com.alknslm.configuration.GlobalProperties;
import com.alknslm.configuration.GlobalPropertiesConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = {"com.alknslm"}) // entityleri görmesi için
@ComponentScan(basePackages = {"com.alknslm"}) // controller-service-repository anotasyonları için
@EnableJpaRepositories(basePackages = {"com.alknslm"}) // jpa repository için
// application.properties dosyasının adını değiştirmek istersen bu anotasyonu eklemen gerekiyor. Yada farklı bir properties okutmak için kullanılır.
//@PropertySource(value = "classpath:application.properties")
@EnableConfigurationProperties(value = GlobalPropertiesConfiguration.class)
public class SpringDataJpaApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringDataJpaApplication.class, args);
    }

}
