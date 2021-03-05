package com.example.demo.spring.ioc.testspringiocstarter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author robert
 * @date 2021/3/1
 */
@Configuration
@Import(value = {TuLingService.class})
@ComponentScan(basePackages = {"com.example.demo.spring.ioc.testspringiocstarter"})
public class MainConfig {

    @Bean
    public TuLingDataSource dataSource() {
        return new TuLingDataSource();
    }
}
