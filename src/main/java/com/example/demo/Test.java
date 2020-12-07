package com.example.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author robert
 */
public class Test {
    static final int low = -128;
    public static void main(String[] args) {
//        String a = "aaa";
//        String b = "bbb";
//        String c = "aaa" + "bbb";
//        String d = a + b;
//        String e = new String("aaa") + new String("bbb");
//        StringBuilder builder = new StringBuilder();
//        builder.append("aa");
//        builder.toString();

//        Integer[] arr = new Integer[] {1,2,3};
//        List<Integer> integers = Arrays.asList(arr);
//        integers.add(4);
//        List<Integer> list = new ArrayList<>(integers);
//        list.add(4);
//        System.out.println(integers);
//        System.out.println(list);

        String c = new String("a") + new String("b");
        String d = "ab";
        System.out.println(c == d);
    }
}
