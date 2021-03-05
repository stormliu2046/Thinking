package com.example.demo.spring.ioc.testApplicationListener;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @author robert
 * @date 2021/3/1
 */
@Component
public class TuLingApplicationListener implements ApplicationListener {

    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        System.out.println("TuLingApplicationListener监听发布了事件:" + event);
    }
}
