package com.example.demo.jvm.classloader;

/**
 * 类加载是使用到时才加载，不是一次性加载的
 * @author robert
 */
public class TestDynamicLoad {

    static {
        System.out.println("******static code******");
    }

    public static void main(String[] args) {
        new A();
        System.out.println("******load test******");
        B b = null;
    }
}

class A{
    public A() {
        System.out.println("******initial A******");
    }
}

class B {
    public B() {
        System.out.println("******initial B******");
    }
}