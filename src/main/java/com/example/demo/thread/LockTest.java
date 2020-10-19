package com.example.demo.thread;

/**
 * @author robert
 */
public class LockTest extends Thread {

    @Override
    public void run() {
        synchronized (String.class) {
            System.out.println("---开始---" + Thread.currentThread().getName());
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("---结束---" + Thread.currentThread().getName());
        }

        System.out.println("外面的代码" + Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        Thread thread1 = new LockTest();
        Thread thread2 = new LockTest();
        thread1.start();
        thread2.start();
    }

}
