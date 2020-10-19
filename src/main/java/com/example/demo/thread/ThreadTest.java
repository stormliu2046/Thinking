package com.example.demo.thread;

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
