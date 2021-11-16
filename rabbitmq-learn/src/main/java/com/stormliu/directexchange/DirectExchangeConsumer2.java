package com.stormliu.directexchange;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;
import com.stormliu.utils.RabbitConnectionHelper;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author robert
 * @date 2021/11/5
 */
public class DirectExchangeConsumer2 {

    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory connFactory = RabbitConnectionHelper.getConnFactory();

        Connection connection = connFactory.newConnection();

        Channel channel = connection.createChannel();

        String exchangeName = "tuling.directchange";
        String exchangeType = "direct";
        String queueName = "tuling.directqueue";
        String routingKey = "tuling.directchange.key";

        channel.exchangeDeclare(exchangeName, exchangeType, true, false, null);
        channel.queueDeclare(queueName, true, false, false, null);

        channel.queueBind(queueName, exchangeName, routingKey);

        channel.basicQos(1); // accept only one unack-ed message at a time (see below)

        DeliverCallback deliverCallback = (consumerTag, delivery) -> {
            String message = new String(delivery.getBody(), "UTF-8");

            System.out.println(" [x] Received '" + message + "'");
            try {
                doWork(message);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println(" [x] Done");
                channel.basicAck(delivery.getEnvelope().getDeliveryTag(), false);
            }
        };
        channel.basicConsume(queueName, false, deliverCallback, consumerTag -> { });

    }

    private static void doWork(String task) throws InterruptedException {
        for (char ch : task.toCharArray()) {
            if (ch == '.') Thread.sleep(1000);
        }
    }
}
