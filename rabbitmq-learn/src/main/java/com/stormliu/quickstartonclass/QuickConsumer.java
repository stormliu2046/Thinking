package com.stormliu.quickstartonclass;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;
import com.stormliu.ConnectionFactoryHelper;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeoutException;

/**
 * @author robert
 * @date 2021/11/4
 */
public class QuickConsumer {

    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory factory = ConnectionFactoryHelper.getConnFactory();

        Connection connection = factory.newConnection();

        Channel channel = connection.createChannel();

        String queueName = "queue-01";
        channel.queueDeclare(queueName, true, false, false, null);
        System.out.println(" [*] Waiting for messages. To exit press CTRL+C");

        DeliverCallback deliverCallback = (consumerTag, delivery) -> {
            String message = new String(delivery.getBody(), StandardCharsets.UTF_8);
            System.out.println(" [x] Received '" + message + "'");
        };
        channel.basicConsume(queueName, true, deliverCallback, consumerTag -> { });
    }
}
