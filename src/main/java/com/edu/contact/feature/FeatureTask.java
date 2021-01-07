package com.edu.contact.feature;

import java.util.concurrent.*;

public class FeatureTask {

    public static final ExecutorService EXECUTOR_SERVICE = Executors.newFixedThreadPool(6);

    public static void main(String[] args) {


        FutureTask<Integer> futureTask = new FutureTask<Integer>(() -> {
            TimeUnit.SECONDS.sleep(15);
            return 10;
        });
        Callable<Integer> callable = () -> {
            TimeUnit.SECONDS.sleep(15);
            return 10;
        };
//        Future<?> submit = EXECUTOR_SERVICE.submit(futureTask);
        Future<Integer> submit = EXECUTOR_SERVICE.submit(callable);
        try {
//            futureTask.get();
            submit.get();
            System.out.println("done ---");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
