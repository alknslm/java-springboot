package com.alknslm.configuration;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @ConfigurationProperties anotasyonu kullanımını göstermek için oluşturuldu.
 *
 */
@Data
@Component
@ConfigurationProperties(prefix = "app") // application.properties dosyası içerisinde okunacak değerlerin ortak başlangıcı
public class GlobalPropertiesConfiguration {

    private List<Server> servers;

    /**
     * @Value --> properties d
     * ConfigurationProperties
     * beraber kullanımı
     * */
    @Value("${key}")
    private String key;
}
