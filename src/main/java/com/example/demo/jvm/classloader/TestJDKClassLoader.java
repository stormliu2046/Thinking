package com.example.demo.jvm.classloader;

import com.sun.crypto.provider.DESKeyFactory;

/**
 * @author robert
 */
public class TestJDKClassLoader {
    public static void main(String[] args) {
        //启动类是C++语言实现，所以打印不出来
        System.out.println(String.class.getClassLoader());
        System.out.println(DESKeyFactory.class.getClassLoader().getClass().getName());
        System.out.println(TestJDKClassLoader.class.getClassLoader().getClass().getName());
        System.out.println(ClassLoader.getSystemClassLoader().getClass().getName());
    }
}
