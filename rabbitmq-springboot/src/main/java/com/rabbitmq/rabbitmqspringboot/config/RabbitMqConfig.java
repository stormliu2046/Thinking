package com.rabbitmq.rabbitmqspringboot.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author robert
 * @date 2021/11/28
 */
@Configuration
public class RabbitMqConfig {

    public static final String CONFIRM_EXCHANGE = "confirm_exchange";
    public static final String CONFIRM_QUEUE = "confirm_queue";

    @Bean
    public Exchange confirmExchange() {
        return ExchangeBuilder.directExchange(CONFIRM_EXCHANGE).durable(true).build();
    }

    @Bean
    public Queue confirmQueue() {
        return QueueBuilder.durable(CONFIRM_QUEUE).build();
    }

    @Bean
    public Binding bindingQueueExchange(@Qualifier("confirmExchange") Exchange confirmExchange, @Qualifier("confirmQueue") Queue confirmQueue) {
        return BindingBuilder.bind(confirmQueue).to(confirmExchange).with("test_confirm").noargs();
    }
}
