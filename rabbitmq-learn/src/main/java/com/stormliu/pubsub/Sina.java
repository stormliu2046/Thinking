package com.stormliu.pubsub;

import com.rabbitmq.client.*;
import com.stormliu.utils.RabbitConnectionHelper;
import com.stormliu.utils.RabbitConstant;

import java.io.IOException;

/**
 * @author robert
 * @date 2021/11/18
 */
public class Sina {

    public static void main(String[] args) throws IOException {

        Connection connection = RabbitConnectionHelper.getConnection();

        Channel channel = connection.createChannel();

        channel.queueDeclare(RabbitConstant.QUEUE_SINA, false, false, false, null);
        channel.queueBind(RabbitConstant.QUEUE_SINA, RabbitConstant.EXCHANGE_WEATHER, "");

        channel.basicQos(1);
        channel.basicConsume(RabbitConstant.QUEUE_SINA, false, new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println("新浪收到消息："+ new String(body));
                channel.basicAck(envelope.getDeliveryTag(), false);
            }
        });
    }
}
