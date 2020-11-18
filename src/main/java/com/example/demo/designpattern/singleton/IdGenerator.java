package com.example.demo.designpattern.singleton;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import sun.rmi.runtime.Log;
import sun.security.jca.GetInstance;

import java.util.concurrent.atomic.AtomicLong;

/**
 * 如何实现一个单例？
 * 关注点：
 * 1.构造函数必须是private访问权限，避免外部通过new创建
 * 2.考虑对象创建时的线程安全问题
 * 3.考虑是否支持延迟加载
 * 4.考虑性能问题（是否加锁）
 * @author robert
 */
@Slf4j
//饿汉式
public class IdGenerator {
    private AtomicLong atomicLong = new AtomicLong(0);
    private static IdGenerator instance = new IdGenerator();
    //构造方法私有
    private IdGenerator(){}
    //获取类的静态方法
    public static IdGenerator getInstance() {
        return instance;
    }

    public long getId() {
        return atomicLong.incrementAndGet();
    }
}

//懒汉式
class IdGenerator2 {
    private AtomicLong atomicLong = new AtomicLong(0);
    private static IdGenerator2 instance;

    private IdGenerator2() {}

    public static synchronized IdGenerator2 getInstance() {
         if (instance == null) {
             instance = new IdGenerator2();
         }
         return instance;
    }

    public long getId() {
        return atomicLong.incrementAndGet();
    }
}

//双重检测
class IdGenerator3 {

    private AtomicLong atomicLong = new AtomicLong();
    private static IdGenerator3 instance;

    private IdGenerator3() {}

    public static IdGenerator3 getInstance() {
        if (instance == null) {
            synchronized (IdGenerator3.class) {
                if (instance == null) {
                    instance = new IdGenerator3();
                }
            }
        }
        return instance;
    }

    public long getId() {
        return atomicLong.incrementAndGet();
    }
}

//静态内部类
class IdGenerator4 {
    private AtomicLong atomicLong = new AtomicLong();

    private IdGenerator4() {}

    public static IdGenerator4 getInstance() {
        return InnerIdGenerator4.instance;
    }

    static class InnerIdGenerator4 {
        private static IdGenerator4 instance = new IdGenerator4();
    }
}

@Slf4j
//枚举
enum IdGenerator5 {
    /**单例枚举*/
    ID_GENERATOR_5;

    private AtomicLong atomicLong = new AtomicLong();

    public long getId() {
        return atomicLong.incrementAndGet();
    }
}