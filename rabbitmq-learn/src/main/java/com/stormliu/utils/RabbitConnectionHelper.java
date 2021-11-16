package com.stormliu.utils;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

/**
 * @author robert
 * @date 2021/11/5
 */
public class RabbitConnectionHelper {

    public static ConnectionFactory getConnFactory() {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("101.35.177.122");
        connectionFactory.setPort(5672);
        connectionFactory.setVirtualHost("/");
        connectionFactory.setUsername("admin");
        connectionFactory.setPassword("admin");
        connectionFactory.setConnectionTimeout(100000);
        return connectionFactory;
    }

    public static Connection getConnection() {
        try {
            return getConnFactory().newConnection();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
