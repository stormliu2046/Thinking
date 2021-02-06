package com.example.demo.annotation;

import org.springframework.stereotype.Service;

/**
 * @author robert
 */
@Service
@FeignExceptionApi
public class HelloInterfaceImpl implements HelloInterface {

    @Override
    public void sayHello() {
        System.out.println("say hello...");
    }
}
