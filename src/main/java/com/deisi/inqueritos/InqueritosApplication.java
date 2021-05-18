package com.deisi.inqueritos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

@SpringBootApplication
@PropertySource("classpath:inqueritos.properties")
public class InqueritosApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(InqueritosApplication.class).properties("spring.config.name: inqueritos");
    }

    public static void main(String[] args) {
        SpringApplication.run(InqueritosApplication.class, args);
    }


}
