package com.robert.listener;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.listener.api.ChannelAwareMessageListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @author robert
 * @date 2021/11/21
 */
@Component
public class AckListener implements ChannelAwareMessageListener {

    @Override
    public void onMessage(Message message, Channel channel) throws Exception {
        long deliveryTag = message.getMessageProperties().getDeliveryTag();

        try {
            System.out.println("message:" + new String(message.getBody()));

            System.out.println("===业务处理===");

            //模拟出现异常
            //int id = 5/0;
            channel.basicAck(deliveryTag, false);
            System.out.println("收到了消息：" + deliveryTag);
        } catch (IOException e) {
            channel.basicNack(deliveryTag, false, true);
        }
    }
}
