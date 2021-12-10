package com.example.demo.reflect;

import java.lang.reflect.Field;

/**
 * @author robert
 * @date 2021/11/21
 */
public class Test1 {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        // 不改变s的引用，如何将s输出adcd
        String s = new String("abc");

        Field value = s.getClass().getDeclaredField("value");
        value.setAccessible(true);
        value.set(s, "abcd".toCharArray());

        System.out.println(s);
    }
}
