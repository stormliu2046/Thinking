package com.example.demo.basic.string;

/**
 * @author robert
 */
public class TestString {
    public static void main(String[] args) {
        String s0 = "1";
        final  String s1 = "2";
        String s2 = "1" + s1;
        System.out.println((s0 == s2));
    }
}
