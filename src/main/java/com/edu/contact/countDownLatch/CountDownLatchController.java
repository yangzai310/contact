package com.edu.contact.countDownLatch;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

@RestController
@RequestMapping("/countDownLatch")
public class CountDownLatchController {

    public static final ExecutorService EXECUTOR_SERVICE = Executors.newFixedThreadPool(10);

    @RequestMapping("/test")
    public void test() {
        CountDownLatch cd = new CountDownLatch(2);
        doSth1(cd);
        doSth2(cd);
        try {
            cd.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("test --- done");
    }


    @RequestMapping("/countDownLatch1")
    public void doSth1(CountDownLatch cd) {
        EXECUTOR_SERVICE.execute(() -> {
            System.out.println("cd before1");
            try {
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("cd after1");
            cd.countDown();
        });
    }

    @RequestMapping("/countDownLatch2")
    public void doSth2(CountDownLatch cd) {
        EXECUTOR_SERVICE.execute(() -> {
            System.out.println("cd before2");
            try {
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("cd after12");
            cd.countDown();
        });

    }


}
