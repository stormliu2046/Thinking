package com.stormliu.quickstartonclass;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.stormliu.ConnectionFactoryHelper;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author robert
 * @date 2021/11/4
 */
public class QuickProducer {

    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory connectionFactory = ConnectionFactoryHelper.getConnFactory();

        Connection connection = connectionFactory.newConnection();

        Channel channel = connection.createChannel();

        for (int i=0; i<5; i++) {
            String message = "hello--"+i;
            channel.basicPublish("", "queue-01", null , message.getBytes());
        }

        channel.close();
        connection.close();
    }
}
