package com.example.demo.annotation;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

/**
 * @author robert
 */
@SpringBootTest
@Slf4j
class HelloInterfaceImplTest {

    @Resource
    private HelloInterface helloInterface;

    @Test
    void sayHello() {
        helloInterface.sayHello();
    }
}