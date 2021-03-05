package com.example.demo.spring.ioc.testioc;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author robert
 * @date 2021/2/28
 */
public class MainClass {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfig.class);
        context.getBean("tuLingLog");
        for (String beanName : context.getBeanDefinitionNames()) {
            System.out.println("beanName:" + beanName);
        }
        System.out.println(context.getBeanDefinitionCount());
//        ApplicationContext ctx = new ClassPathXmlApplicationContext("bean.xml");
    }
}
