package com.edu.contact.feature;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class FeatureTask {

    public static void main(String[] args) {

        FutureTask<Integer> futureTask = new FutureTask<Integer>(() -> {
            return 10;
        });
        Callable<Integer> callable = () -> {
            return 10;
        };


        try {
            futureTask.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
