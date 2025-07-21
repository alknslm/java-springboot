package com.alknslm.configuration;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Bu class application.properties dosyasını okumak için oluşturuldu
 * Nerde kullanmak istiyorsan :
 * @Autowired
 *     private GlobalProperties globalProperties; bu şekilde yazıp istediğin field'a ulaşabilirsin.
 */
@Component // uygulama ayağa kalkarken conteiner'da bunu da oluştur. Class'ın bean'inin oluşturur.
@Data
public class GlobalProperties {

    @Value("${spring.datasource.url}") //application.properties içerisinde yazan field buraya yazılır
    private String url;

    @Value("${spring.datasource.username}") //application.properties içerisinde yazan field buraya yazılır
    private String username;

    @Value("${spring.datasource.password}") //application.properties içerisinde yazan field buraya yazılır
    private String password;
}
