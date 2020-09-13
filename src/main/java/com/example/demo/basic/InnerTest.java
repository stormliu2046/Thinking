package com.example.demo.basic;

/**
 * @author robert
 * 内部类
 */
public class InnerTest {

    int a = 2;
    static int b = 9;
    private String s;
    private static String j;

    class Inner1 {
        void test () {
            System.out.println(a); //外围类属性
            System.out.println(b); //外围类静态属性
            System.out.println(s); //外围类私有属性
            System.out.println(j); //外围类静态私有属性
            /*
             * 总结：
             * 非静态内部类
             * 1.可以访问外围类的所有静态数据
             * 2.可以访问外围类的所有非静态数据
             */
        }
    }

    static class Inner2 {
        void test () {
//            System.out.println(a);
            System.out.println(b);
//            System.out.println(s);
            System.out.println(j);
            /*
             * 总结：
             * 静态内部类
             * 1.可以访问外围类的所有静态数据
             * 2.不能访问外围类的非静态数据
             */
        }
    }

}
