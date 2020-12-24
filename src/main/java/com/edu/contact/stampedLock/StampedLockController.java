package com.edu.contact.stampedLock;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.StampedLock;

@RestController
@RequestMapping("/stampedLock")
public class StampedLockController {

    public static final StampedLock SL = new StampedLock();

    public static final ExecutorService EXECUTOR_SERVICE = Executors.newFixedThreadPool(10);

    public static int count = 0;

    @RequestMapping("/test")
    public void test() {
        doSth3();
        doSth1();
        doSth2();
    }


    @RequestMapping("/stampedLock1")
    public void doSth1() {
        EXECUTOR_SERVICE.execute(() -> {
            long stamp = SL.tryOptimisticRead();
            System.out.println("stampedLock1 count =" + count);
            if(!SL.validate(stamp)) {
                System.out.println("stampedLock1 锁升级 --");
                stamp = SL.readLock();
            }
            System.out.println("stampedLock1 count =" + count);
            try {
                System.out.println("SL before1");
                TimeUnit.SECONDS.sleep(10);
                System.out.println("SL after1");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                SL.unlockRead(stamp);
            }

        });
    }

    @RequestMapping("/stampedLock2")
    public void doSth2() {
        EXECUTOR_SERVICE.execute(() -> {
            long stamp = SL.tryOptimisticRead();
            System.out.println("stampedLock2 count =" + count);
            if(!SL.validate(stamp)) {
                System.out.println("stampedLock2 锁升级 --");
                stamp = SL.readLock();
            }
            System.out.println("stampedLock2 count =" + count);
            try {
                System.out.println("SL before2");
                TimeUnit.SECONDS.sleep(10);
                System.out.println("SL after2");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                SL.unlockRead(stamp);
            }
        });

    }

    @RequestMapping("/stampedLock3")
    public void doSth3() {
        EXECUTOR_SERVICE.execute(() -> {
            long stamp = SL.writeLock();
            System.out.println("stampedLock3 count =" + count++);
            try {
                System.out.println("SL before3");
                TimeUnit.SECONDS.sleep(10);
                System.out.println("SL after3");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                SL.unlockWrite(stamp);
            }
        });
    }
}
