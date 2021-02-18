package com.example.demo.thread;

import static java.util.concurrent.TimeUnit.*;

/**
 * @author robert
 */
public class ThreadTest implements Runnable {

    int b = 100;

    synchronized void m1() throws InterruptedException {
        System.out.println("m1 start");
        b = 1000;
        Thread.sleep(500);
        System.out.println("b = " + b);
        System.out.println("m1 end");
    }

    synchronized void m2() throws InterruptedException {
        System.out.println("m2 start");
        Thread.sleep(250);
        b = 2000;
        System.out.println("m2 end");
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadTest tt = new ThreadTest();
        Thread t = new Thread(tt);
        t.start();

        tt.m2();
        System.out.println("main thread b =" + tt.b);
    }

    @Override
    public void run() {
        try {
            m1();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

//    m2 start
//    m2 end
//    m1 start
//    main thread b =2000
//    b = 1000
//    m1 end

//    m2 start
//    m2 end
//    m1 start
//    main thread b =1000
//    b = 1000
//    m1 end

}

//join(),执行完才释放资源给其他线程执行
class ThreadTest2 implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() + " " + i);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread tt1 = new Thread(new ThreadTest2());
        Thread tt2 = new Thread(new ThreadTest2());
        tt1.start();
//        tt1.join(); //必须等tt1全部执行完才执行tt2
        tt2.start();
    }
}

//守护线程，主线程结束则结束
class DaemonThreadTest {
    public static void main(String[] args) {
        Runnable runnable = () -> {
            for (int i = 10; i > 0; --i) {
                System.out.println("Time #" + i);
                try {
                    SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Thread thread = new Thread(runnable);
        thread.setDaemon(false);
        thread.start();

        System.out.println("Main Thread waiting...");
        try {
            SECONDS.sleep(6);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Main Thread exits.");
    }
}