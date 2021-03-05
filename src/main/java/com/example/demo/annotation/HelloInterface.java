package com.example.demo.annotation;

/**
 * @author robert
 */
public interface HelloInterface {

    void sayHello();

    abstract void a();

    default void b() {
        System.out.println("default 默认实现");
    }

    static void c() {
        System.out.println("静态方法实现");
    }
}
