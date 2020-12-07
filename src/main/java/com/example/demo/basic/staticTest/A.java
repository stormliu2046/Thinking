package com.example.demo.basic.staticTest;

import java.util.Arrays;

/**
 * @author robert
 */
public class A {

    private static int a = B();

    static
    {
        System.out.println("Enter A.static block");
    }

    public static void main(String[] args)
    {
        new A();
    }

    public static int B()
    {
        System.out.println("Enter A.B()");
        return 1;
    }

}

class B {
    {
        System.out.println("b.non static");
    }

    static {
        System.out.println("b.static");
    }

    public B() {
        System.out.println("b.constructor");
    }
}

class C extends B {
    {
        System.out.println("c.non static");
    }
    static {
        System.out.println("c.static");
    }

    public C() {
        System.out.println("c.constructor");
    }

    public static void main(String[] args) {
        new C();
        new C();
    }
}