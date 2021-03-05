package com.example.demo.basic;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

/**
 * @author robert
 */
@Slf4j
public class BasicTest {

    //void f() {}

    int f() {
        return 1;
    }

    public static void main(String[] args) throws IOException {
        /*String str = "{\"amount\":\"20\"}";
        ObjectMapper mapper = new ObjectMapper();
        JsonNode jsonNode = mapper.readTree(str);
        JsonNode amountNode = jsonNode.get("amount");
        System.out.println(amountNode.asInt());
        FileWriter writer = new FileWriter("D://filewriter.txt");
        writer.write("hello world");*/

        A classA = new A("he");
        A classB = new A("he");
        log.info("classA == classB :" + (classA == classB));
        //equals默认用==比较地址，没重写equals方法依然为false
        log.info("classA.equals(classB) :" + classA.equals(classB));
    }
}

class A {
    public A(String str) {}
}

class Test {
    static {
        int x = 5;
    }

    static int x, y;

    public static void main(String[] args) {
        x--; //x=-1
        myMethod();
        System.out.println(x+y + ++x); //1+0+2=3
    }
    public static void myMethod() {
        y = x++ + ++x; //y=-1+1=0, x=1
    }
}
