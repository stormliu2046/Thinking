package com.stormliu.pubsub;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.stormliu.utils.RabbitConnectionHelper;
import com.stormliu.utils.RabbitConstant;

import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.TimeoutException;

/**
 * 发布/订阅模式（广播模式）
 *
 * @author robert
 * @date 2021/11/18
 */
public class WeatherBureau {

    public static void main(String[] args) throws IOException, TimeoutException {
        Scanner scanner = new Scanner(System.in);
        String message = scanner.next();

        Connection connection = RabbitConnectionHelper.getConnection();

        Channel channel = connection.createChannel();

        channel.exchangeDeclare(RabbitConstant.EXCHANGE_WEATHER, "fanout");

        channel.basicPublish(RabbitConstant.EXCHANGE_WEATHER, "", null, message.getBytes());

        channel.close();
        connection.close();
    }
}
