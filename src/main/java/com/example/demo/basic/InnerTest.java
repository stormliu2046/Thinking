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

    /**
     * 1.非静态内部类不能声明
     */
    class Inner1 {
//        public static int a; //内部类不能定义静态变量

        void test () {
            System.out.println(a); //外部类属性
            System.out.println(b); //外部类静态属性
            System.out.println(s); //外部类私有属性
            System.out.println(j); //外部类静态私有属性
            Inner2 inner2 = new Inner2();
            inner2.test();
            InnerTest.Inner2 inner21 = new InnerTest.Inner2();
            inner21.test();
            /*
             * 总结：
             * 非静态内部类
             * 1.可以访问外部类的所有静态数据
             * 2.可以访问外部类的所有非静态数据
             */
        }
    }

    /**
     * 1.static修饰的类，称为静态内部类
     * 2.static关键字作用：修饰的成员变成类相关
     * 3.静态内部类只能访问外部类静态成员变量
     */
    static class Inner2 {
        private static String name;
        private int age;
        void test () {
//            System.out.println(a);
            System.out.println(b);
//            System.out.println(s);
            System.out.println(j);
            /*
             * 总结：
             * 静态内部类
             * 1.可以访问外部类的所有静态数据
             * 2.不能访问外部类的非静态数据
             */
        }
    }

}
