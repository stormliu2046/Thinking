package com.rabbitmq.rabbitmqspringboot;

import cn.hutool.json.JSONUtil;
import com.rabbitmq.client.ReturnCallback;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.amqp.core.ReturnedMessage;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
class RabbitmqSpringbootApplicationTests {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Test
    void contextLoads() {
    }

    @Test
    void testConfirms() {

//        rabbitTemplate.setConfirmCallback((correlationData, ack, cause) -> {
//            log.info(JSONUtil.toJsonStr(correlationData));
//            if (ack) {
//                System.out.println("接收成功消息");
//            } else {
//                System.out.println("接收失败消息：" + cause);
//            }
//        });

        for (int i = 0; i < 20; i++) {
            rabbitTemplate.convertAndSend("confirm_exchange", "test_confirm", "test confirm message.." + i);
        }

//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
    }

    @Test
    void testReturn() {

        rabbitTemplate.setMandatory(false);
        rabbitTemplate.setReturnsCallback(returned -> {
            System.out.println(returned.getExchange());
            System.out.println(returned.getMessage());
            System.out.println(returned.getReplyCode());
            System.out.println(returned.getReplyText());
            System.out.println(returned.getRoutingKey());
        });

        rabbitTemplate.convertAndSend("confirm_exchange", "test_confirm1", "test confirm message...");

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
