package com.rabbitmq.rabbitmqspringboot.listener;

import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.listener.api.ChannelAwareMessageListener;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Arrays;

/**
 * @author robert
 * @date 2021/11/28
 */
@Slf4j
@Component
public class RabbitMqListener {

    @RabbitListener(queues = "confirm_queue")
    public void confirmListener(Message message, Channel channel) throws Exception {
        log.info("message:" + new String(message.getBody()));

        Thread.sleep(1000);

        long deliveryTag = message.getMessageProperties().getDeliveryTag();
//        try {
//            int i = 1/0;
//            channel.basicAck(deliveryTag, false);
//        } catch (IOException e) {
//            channel.basicNack(deliveryTag, false, false);
//        }
    }
}
