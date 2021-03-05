package com.example.demo.thread;

/**
 * @author robert
 * @date 2021/2/26
 */
public class DeadLockTest {

    public static final String RESOURCE_A = "A";
    public static final String RESOURCE_B = "B";

    public static void main(String[] args) {
        Thread A = new Thread(() -> {
            synchronized(RESOURCE_A) {
                try {
                    Thread.sleep(1000);
                    synchronized (RESOURCE_B) {
                        Thread.sleep(1000);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread B = new Thread(() -> {
           synchronized (RESOURCE_B) {
               try {
                   Thread.sleep(1000);
                   synchronized (RESOURCE_A) {
                       Thread.sleep(1000);
                   }
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
           }
        });
        A.start();
        B.start();
    }
}
