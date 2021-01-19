package com.example.demo.test;

import java.util.Iterator;
import java.util.LinkedList;
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

//        String c = new String("a") + new String("b");
//        String d = "ab";
//        System.out.println(c == d);
//
//        Integer[] fileIdsArray = {1,9,7,5,8,4,6,2};
//        List<Integer> fileIds = new ArrayList<>(Arrays.asList(fileIdsArray));
//        String sourceFileIds = fileIds.stream().sorted().map(String::valueOf).collect(Collectors.joining(","));
//        System.out.println(sourceFileIds);

        String b = "\n";
        String c = "\101";
        // iterator会改变原集合里的元素
        List<Long> a = new LinkedList<>();
        a.add(5L);
        a.add(4L);
        a.add(9L);
        a.add(8L);
        a.add(6L);
        System.out.println(a + "");
        Iterator<Long> iter = a.iterator();
//        a.removeIf(next -> next == 4L);
        while (iter.hasNext()) {
            Long next = iter.next();
            if (next == 4L) {
                iter.remove();
            }
        }
        System.out.println(a + "");
    }
}
