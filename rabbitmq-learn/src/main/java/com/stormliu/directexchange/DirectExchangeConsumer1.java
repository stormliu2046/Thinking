package com.stormliu.directexchange;

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
 * @date 2021/11/5
 */
public class DirectExchangeConsumer1 {

    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory connFactory = ConnectionFactoryHelper.getConnFactory();

        Connection connection = connFactory.newConnection();

        Channel channel = connection.createChannel();

        String exchangeName = "tuling.directchange";
        String exchangeType = "direct";
        String queueName = "tuling.directqueue";
        String routingKey = "tuling.directchange.key";

        channel.exchangeDeclare(exchangeName, exchangeType, true, false, null);
        channel.queueDeclare(queueName, true, false, false, null);

        channel.queueBind(queueName, exchangeName, routingKey);
        DeliverCallback callback = ((consumerTag, delivery) -> {
            String message = new String(delivery.getBody(), StandardCharsets.UTF_8);
            System.out.println(" [x] Received '" + message + "'");
        });

        channel.basicConsume(queueName, true, callback, consumerTag -> {});
    }
}
