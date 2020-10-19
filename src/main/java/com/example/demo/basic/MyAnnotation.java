package com.example.demo.basic;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author robert
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation {
    String name();
    int times() default 2;
    String[] interestArr() default {"z", "j", "t"};
}

class MyAnnotationProcessor {
    public void processMethod (Class<?> clazz) {
        //拿到类的所有方法
        Method[] methods = clazz.getMethods();
        //遍历方法，获取注解
        for (Method method : methods) {
            //判断注解是否有MyAnnotation
            MyAnnotation myAnnotation = method.getAnnotation(MyAnnotation.class);
            if (Objects.nonNull(myAnnotation)) {
                //如果是，执行方法
                ExecutorService executorService = Executors.newSingleThreadExecutor();
                executorService.execute(() -> {
                    for (int i = 0 ; i < myAnnotation.times(); i++) {
                        try {
                            method.invoke(clazz.newInstance(), myAnnotation.name(), myAnnotation.interestArr());
                            Thread.sleep(2000);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        }
    }
}

class MyAnnotationTest {

    @MyAnnotation(name = "ljh")
    public void runMyAnnotation(String name, String[] interestArr) {
        System.out.println(name + ", " + Arrays.toString(interestArr));
    }

    public static void main(String[] args) {
//        MyAnnotationProcessor myAnnotationProcessor = new MyAnnotationProcessor();
//        myAnnotationProcessor.processMethod(MyAnnotationTest.class);


        List strings = new ArrayList<>();
        List integers = new ArrayList<>();
        //true
        System.out.println(strings.getClass() == integers.getClass());
        System.out.println(strings == integers);
    }
}