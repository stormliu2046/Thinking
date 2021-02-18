package com.example.demo.thread.thredlocal;

import java.util.concurrent.*;

/**
 * @author robert
 */
public class ExecutorsTest {

    private static final ExecutorService exec = Executors.newFixedThreadPool(50);

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Runnable runnable = () -> System.out.println(Thread.currentThread().getName() + "正在执行");
        exec.execute(runnable);

        Callable<Object> callable = () -> "执行结果   ";

        Future future = exec.submit(callable);
        System.out.println(future.get());
        System.out.println(future.isDone());
        System.out.println(future.isCancelled());
        System.out.println(future.cancel(true));
    }
}
