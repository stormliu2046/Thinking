package com.example.demo.jvm.model;

/**
 * @author robert
 */
public class StackOverflow {

    static int counter = 0;

    public static void redo() {
        counter ++;
        redo();
    }

    public static void main(String[] args) {
        try {
            redo();
        } catch (Throwable t) {
            System.out.println("counter:" + counter);
            t.printStackTrace();
        }
    }
}
