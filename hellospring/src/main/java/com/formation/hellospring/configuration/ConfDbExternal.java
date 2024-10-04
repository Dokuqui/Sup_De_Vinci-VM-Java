package com.formation.hellospring.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.formation.hellospring.CustomDataSource;

@Configuration
public class ConfDbExternal {

    @Autowired
    Environment env;

    @Bean
    public CustomDataSource dataSourceCustom() {
        final CustomDataSource customDataSource = new CustomDataSource();
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(env.getProperty("driverClassName"));
        dataSource.setUrl(env.getProperty("url"));
        dataSource.setUsername(env.getProperty("user"));
        dataSource.setPassword(env.getProperty("password"));
        customDataSource.localeDataSource = dataSource;
        return customDataSource;
    }

}
