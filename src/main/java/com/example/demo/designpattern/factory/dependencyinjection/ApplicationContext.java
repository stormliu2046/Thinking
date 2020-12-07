package com.example.demo.designpattern.factory.dependencyinjection;

/**
 * @author robert
 */
public interface ApplicationContext {

    Object getBean(String beanId);
}
