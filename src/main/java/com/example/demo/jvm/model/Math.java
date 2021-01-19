package com.example.demo.jvm.model;

/**
 * @author robert
 */
public class Math {
    public static int initData = 666;

    public int compute() {
        int a = 1;
        int b = 2;
        int c = (a + b) * 10;
        return c;
    }

    public static void main(String[] args) {
        Math math = new Math();
        math.compute();
    }
}
