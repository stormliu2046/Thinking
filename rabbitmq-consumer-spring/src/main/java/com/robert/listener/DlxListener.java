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
public class DlxListener implements ChannelAwareMessageListener {
    @Override
    public void onMessage(Message message, Channel channel) throws Exception {
        long deliveryTag = message.getMessageProperties().getDeliveryTag();

        try {
            System.out.println(new String(message.getBody()));

            System.out.println("处理业务逻辑...");

            channel.basicAck(deliveryTag, true);
        } catch (IOException e) {
            System.out.println("出现异常，拒绝签收");
            channel.basicNack(deliveryTag, true, false);
        }
    }
}
