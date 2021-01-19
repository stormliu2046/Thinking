package com.example.demo.jvm.model;

import java.util.ArrayList;

/**
 * 测试JVM年轻代、老年代运行情况
 * @author robert
 */
public class HeapTest {
    byte[] a = new byte[1024*100]; //100KB

    public static void main(String[] args) throws InterruptedException {
        ArrayList<HeapTest> heapTests = new ArrayList<>();
        while (true) {
            heapTests.add(new HeapTest());
            Thread.sleep(30);
        }
    }
}
