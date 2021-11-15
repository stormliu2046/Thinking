package com.stormliu.directexchange;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.stormliu.ConnectionFactoryHelper;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author robert
 * @date 2021/11/5
 */
public class DirectExchangeProducer {

    public static void main(String[] args) throws IOException, TimeoutException {
        //创建连接工厂
        ConnectionFactory connectionFactory = ConnectionFactoryHelper.getConnFactory();

        //创建连接
        Connection connection = connectionFactory.newConnection();

        //创建channel
        Channel channel = connection.createChannel();

        //定义交换机名称
        String exchangeName = "tuling.directchange";

        //定义routingKey
        String routingKey = "tuling.directchange.key";

        //消息体内容
        for (int i=0; i<5; i++) {
            String messageBody = "hello tuling--" + i;
            channel.basicPublish(exchangeName,routingKey,null,messageBody.getBytes());
            System.out.println(" [x] Sent '" + messageBody + "'");
        }

        channel.close();
        connection.close();
    }
}
