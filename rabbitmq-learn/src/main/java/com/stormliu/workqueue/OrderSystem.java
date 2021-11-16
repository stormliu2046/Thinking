package com.stormliu.workqueue;

import com.google.gson.Gson;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.stormliu.utils.RabbitConnectionHelper;
import com.stormliu.utils.RabbitConstant;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author robert
 * @date 2021/11/17
 */
public class OrderSystem {

    public static void main(String[] args) throws IOException, TimeoutException {
        Connection connection = RabbitConnectionHelper.getConnection();

        Channel channel = connection.createChannel();

        channel.queueDeclare(RabbitConstant.QUEUE_SMS, false, false, false, null);

        for (int i = 1; i <= 100; i++) {
            SMS sms = new SMS("乘客" + i, "13000000" + i, "您的车票已预订成功");
            String message = new Gson().toJson(sms);
            channel.basicPublish("", RabbitConstant.QUEUE_SMS, null, message.getBytes());
        }

        System.out.println("发送消息成功");
        channel.close();
        connection.close();
    }
}
