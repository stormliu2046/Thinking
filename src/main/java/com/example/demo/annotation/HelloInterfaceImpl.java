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

    @Override
    public void a() {
        b();
    }

    public static void main(String[] args) {
        HelloInterface hi = new HelloInterfaceImpl();
        hi.a();
        hi.b();
        HelloInterface.c();
    }
}
