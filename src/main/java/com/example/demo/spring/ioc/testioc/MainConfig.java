package com.example.demo.spring.ioc.testioc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

/**
 * @author robert
 * @date 2021/2/28
 */
@Configuration
public class MainConfig {

    @Bean
    public TuLingAspect tuLingAspect() {
        return new TuLingAspect();
    }

    @Bean
    @Conditional(value = TuLingCondition.class)
    public TuLingLog tuLingLog() {
        return new TuLingLog();
    }

}
