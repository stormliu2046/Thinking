package com.stormliu.quickstartonclass;

import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RabbitmqLearnApplicationTests {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Test
    void contextLoads() {
    }

    @Test
    void bootRmq() throws InterruptedException {
        rabbitTemplate.convertAndSend("boot_topic_exchange", "boot.a.b", "message boot...");

//        Thread.sleep(5000);
    }

}
