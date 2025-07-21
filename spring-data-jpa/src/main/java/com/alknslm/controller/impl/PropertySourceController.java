package com.alknslm.controller.impl;

import com.alknslm.configuration.DataSource;
import com.alknslm.configuration.GlobalProperties;
import com.alknslm.configuration.GlobalPropertiesConfiguration;
import com.alknslm.configuration.Server;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Configuration propertieslari çekmek için oluşturuldu.
 */
@RestController
@RequestMapping("rest/api/property")
public class PropertySourceController {

    @Autowired
    private GlobalProperties globalProperties;

    @Autowired
    private GlobalPropertiesConfiguration globalPropertiesConfiguration;

    @GetMapping("/datasource")
    public DataSource getDatasource(){
        DataSource datasource = new DataSource();
        datasource.setUrl(globalProperties.getUrl());
        datasource.setUsername(globalProperties.getUsername());
        datasource.setPassword(globalProperties.getPassword());

        return datasource;
    }

    @GetMapping("/getServers")
    public List<Server> getServers(){
        System.out.println(globalPropertiesConfiguration.getKey());
        return globalPropertiesConfiguration.getServers();
    }
}
