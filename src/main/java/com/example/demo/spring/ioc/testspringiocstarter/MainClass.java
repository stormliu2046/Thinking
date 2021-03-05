package com.example.demo.spring.ioc.testspringiocstarter;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author robert
 * @date 2021/3/1
 */
public class MainClass {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfig.class);
    }
}
