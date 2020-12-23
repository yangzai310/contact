package com.edu.contact.readWriteLock;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

@RestController
@RequestMapping("/readWriteLockController")
public class ReadWriteLockController {


    public static final ReadWriteLock READ_WRITE_LOCK = new ReentrantReadWriteLock();

    public static final Lock RL = READ_WRITE_LOCK.readLock();

    public static final Lock WL = READ_WRITE_LOCK.writeLock();

    public static final ExecutorService EXECUTOR_SERVICE = Executors.newFixedThreadPool(10);

    @RequestMapping("/test")
    public void test() {
        doSth3();
        doSth1();
        doSth2();
    }


    @RequestMapping("/readWriteLock1")
    public void doSth1() {
        EXECUTOR_SERVICE.execute(() -> {
            RL.lock();
            try {
                System.out.println("RL before1");
                TimeUnit.SECONDS.sleep(10);
                System.out.println("RL after1");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                RL.unlock();
            }

        });
    }

    @RequestMapping("/readWriteLock2")
    public void doSth2() {
        EXECUTOR_SERVICE.execute(() -> {
            RL.lock();
            try {
                System.out.println("RL before2");
                TimeUnit.SECONDS.sleep(10);
                System.out.println("RL after2");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                RL.unlock();
            }
        });

    }

    @RequestMapping("/readWriteLock3")
    public void doSth3() {
        EXECUTOR_SERVICE.execute(() -> {
            WL.lock();
            try {
                System.out.println("RL before3");
                TimeUnit.SECONDS.sleep(10);
                System.out.println("RL after3");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                WL.unlock();
            }
        });
    }
}
