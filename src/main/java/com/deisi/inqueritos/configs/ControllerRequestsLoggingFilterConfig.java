package com.deisi.inqueritos.configs;


import com.deisi.inqueritos.filter.ControllerRequestsLoggingFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ControllerRequestsLoggingFilterConfig {

    // ********** IMPORTANT **********
    // don't forget to include the following line in the aplication properties file:
    // logging.level.org.springframework.web.filter.ControllerRequestsLoggingFilter=INFO

    @Bean
    public ControllerRequestsLoggingFilter logFilter() {
        return new ControllerRequestsLoggingFilter();
    }
}
