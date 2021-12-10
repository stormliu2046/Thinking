package com.stormliu.springbootrmq;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author robert
 * @date 2021/11/19
 */
@Component
public class RabbitmqListener {

    @RabbitListener(queues = "boot_queue")
    public void message(Message message) {
        System.out.println("监听到消息：" + new String(message.getBody()));
    }
}
