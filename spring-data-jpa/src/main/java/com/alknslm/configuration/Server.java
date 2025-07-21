package com.alknslm.configuration;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Bu class ConfigurationProperties anotasyonu kullanımı için açıldı
 * app.servers[0].ip = 192.168.1.2
 * app.servers[0].location = Almanya
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Server {
/** application.properties dosyasındaki fieldlarla aynı isimde olmalı fieldlar*/
    private String ip;

    private String location;
}
