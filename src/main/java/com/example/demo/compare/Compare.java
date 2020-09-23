package com.example.demo.compare;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.text.Collator;
import java.util.*;

/**
 * @author robert
 */
public class Compare {
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    static class Person {
        private int id;
        private String name;
    }

    public void sort() {
        List<Person> personList = Arrays.asList(
                new Person(1, "张小同"),
                new Person(3, "靖大同"),
                new Person(3, "王五"),
                new Person(2, "赵三"),
                new Person(3, "刘小刀")
        );
        //获取中文环境
        Comparator comparator = Collator.getInstance(Locale.CHINA);
        //进行排序
        Collections.sort(personList, (p1, p2) -> {
            if (p1.getId() > p2.getId()) {
                return 1;
            } else if (p1.getId() == p2.getId()) {
                return  comparator.compare(p1.getName(), p2.getName());
            } else {
                return -1;
            }
        });
//        Collections.sort(personList, Comparator.comparing(Person::getName));
        //打印结果
        personList.stream().forEach(System.out::println);
    }

    public static void main(String[] args) {
        Compare compare = new Compare();
        compare.sort();
    }
}
