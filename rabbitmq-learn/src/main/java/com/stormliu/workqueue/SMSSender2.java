package com.stormliu.workqueue;

import com.rabbitmq.client.*;
import com.stormliu.utils.RabbitConnectionHelper;
import com.stormliu.utils.RabbitConstant;

import java.io.IOException;

/**
 * @author robert
 * @date 2021/11/17
 */
public class SMSSender2 {

    public static void main(String[] args) throws IOException {

        Connection connection = RabbitConnectionHelper.getConnection();

        Channel channel = connection.createChannel();

//        channel.queueDeclare(RabbitConstant.QUEUE_SMS, false, false, false,  null);
        channel.basicQos(1);

        channel.basicConsume(RabbitConstant.QUEUE_SMS, new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                String message = new String(body);
                System.out.println("SMSSender2 发送短信成功：" + message);

                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                channel.basicAck(envelope.getDeliveryTag(), false);
            }
        });

    }
}