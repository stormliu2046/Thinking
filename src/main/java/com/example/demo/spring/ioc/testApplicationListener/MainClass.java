package com.example.demo.spring.ioc.testApplicationListener;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author robert
 * @date 2021/3/1
 */
public class MainClass {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfig.class);
        context.publishEvent(new ApplicationEvent("手动发布了一个事件") {
            @Override
            public Object getSource() {
                return super.getSource();
            }
        });
        context.close();
    }
}
