package com.edu.contact.threadpool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;

public class MyThreadPool {


    private LinkedBlockingQueue<Runnable> workerQueue;

    private List<Thread> workerThreads = new ArrayList<>();

    public MyThreadPool(int cool, LinkedBlockingQueue workerQueue) {
        this.workerQueue = workerQueue;
        for (int i = 0; i < cool; i++) {
            MyThread myThread = new MyThread();
            myThread.start();
            workerThreads.add(myThread);
        }
    }

    public void execute(Runnable runnable) throws Exception{
        workerQueue.put(runnable);
    }
    private class MyThread extends Thread{
        @Override
        public void run() {
            while (true) {
                try {
                    Runnable take = workerQueue.take();
                    take.run();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
    }

}
