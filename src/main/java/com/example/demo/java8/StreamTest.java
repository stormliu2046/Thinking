package com.example.demo.java8;

import com.example.demo.java8.entity.Student;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author robert
 * @date 2021/3/9
 */
public class StreamTest {

    /********** 流的常用创建方法 ************/
    public static void listStream() {
        List<String> list = new ArrayList<>();
        Stream<String> stream = list.stream();
        Stream<String> parallelStream = list.parallelStream();
    }

    public static void arraysStream() {
        Integer[] nums = new Integer[10];
        Stream<Integer> stream = Arrays.stream(nums);
    }

    public static void streamStaticMethod() {
        Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5, 6);

        Stream<Integer> stream2 = Stream.iterate(0, (x) -> x + 2).limit(6);
        stream2.forEach(System.out::println);

        Stream<Double> stream3 = Stream.generate(Math::random).limit(2);
        stream3.forEach(System.out::println);
    }

    public static void bufferReaderLinesStream() throws FileNotFoundException {
        BufferedReader reader = new BufferedReader(new FileReader("D:\\test.txt"));
        Stream<String> lineStream = reader.lines();
        lineStream.forEach(System.out::println);
    }

    public static void patternSplitAsStream() {
        Pattern pattern = Pattern.compile(",");
        Stream<String> stringStream = pattern.splitAsStream("a,b,c,d");
        stringStream.forEach(System.out::println);
    }

    /******** 流的中间操作 ********/
    public static void filterAndLimitAndSkipAndDistinct() {
        Stream<Integer> stream = Stream.of(6, 4, 6, 7, 3, 9, 8, 10, 12, 14, 14);
        Stream<Integer> newStream = stream.filter(s -> s > 5)
                .distinct()
                .skip(2)
                .limit(2);
        newStream.forEach(System.out::println);
    }

    public static void mapAndFlatMap() {
        List<String> list = Arrays.asList("a,b,c", "1,2,3");
        Stream<String> s1 = list.stream().map(s -> s.replaceAll(",", ""));
        s1.forEach(System.out::println);

        Stream<String> s3 = list.stream().flatMap(s -> {
            //将每个元素转换成一个stream
            String[] split = s.split(",");
            Stream<String> s2 = Arrays.stream(split);
            return s2;
        });
        s3.forEach(System.out::println);
    }

    public static void sorted() {
        List<String> list = Arrays.asList("aa", "ff", "dd");
        list.stream().sorted().forEach(System.out::println);

        Student s1 = new Student("aa", 10, 1);
        Student s2 = new Student("bb", 20, 1);
        Student s3 = new Student("aa", 30, 1);
        Student s4 = new Student("dd", 40, 1);
        List<Student> studentList = Arrays.asList(s1, s2, s3, s4);

        //自定义排序：先按姓名升序，姓名相同则按年龄升序
        studentList.stream().sorted((o1, o2) -> {
            if (o1.getName().equals(o2.getName())) {
                return o1.getAge() - o2.getAge();
            } else {
                return o1.getName().compareTo(o2.getName());
            }
        }).forEach(System.out::println);
    }

    public static void collectors() {
        Student s1 = new Student("aa", 10, 1);
        Student s2 = new Student("bb", 20, 2);
        Student s3 = new Student("cc", 10, 3);
        List<Student> list = Arrays.asList(s1, s2, s3);
        List<Integer> ageList = list.stream().map(Student::getAge).collect(Collectors.toList());
        Set<Integer> ageSet = list.stream().map(Student::getAge).collect(Collectors.toSet());
        Map<String, Integer> studentMap = list.stream().collect(Collectors.toMap(Student::getName, Student::getAge));

        String joinName = list.stream().map(Student::getName).collect(Collectors.joining(",", "(", ")"));

    }

    public static void main(String[] args) {
        streamStaticMethod();
    }
}
