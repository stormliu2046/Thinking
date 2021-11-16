package com.stormliu.quickstartonclass;

import com.rabbitmq.client.*;
import com.stormliu.utils.RabbitConnectionHelper;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeoutException;

/**
 * @author robert
 * @date 2021/11/4
 */
public class QuickConsumer {

    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory factory = RabbitConnectionHelper.getConnFactory();

        Connection connection = factory.newConnection();

        Channel channel = connection.createChannel();

        String queueName = "queue-01";
        channel.queueDeclare(queueName, true, false, false, null);
        System.out.println(" [*] Waiting for messages. To exit press CTRL+C");

        DeliverCallback deliverCallback = (consumerTag, delivery) -> {
            String message = new String(delivery.getBody(), StandardCharsets.UTF_8);
            System.out.println(" [x] Received '" + message + "'");
        };
        channel.basicConsume(queueName, true, deliverCallback, consumerTag -> {
        });

        // channel.basicConsume(queueName, new Receiver(channel));
    }
}

class Receiver extends DefaultConsumer {

    private Channel channel;

    /**
     * Constructs a new instance and records its association to the passed-in channel.
     *
     * @param channel the channel to which this consumer is attached
     */
    public Receiver(Channel channel) {
        super(channel);
        this.channel = channel;
    }

    @Override
    public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body)
            throws IOException {
        // no work to do
        String message = new String(body);
        System.out.println("接收到的消息：" + message);

        System.out.println("消息的TagId" + envelope.getDeliveryTag());

        channel.basicAck(envelope.getDeliveryTag(), false);
    }
}