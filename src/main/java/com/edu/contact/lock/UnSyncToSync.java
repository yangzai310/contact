package com.edu.contact.lock;

import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Component
public class UnSyncToSync {

    public static Lock lock = new ReentrantLock();

    public static Condition done = lock.newCondition();

    public static AtomicLong flag = new AtomicLong(0);

    public void doVoid() {
        System.out.println("lock before");
        lock.lock();
        System.out.println("lock after");
        try {
            while (flag.get() != 1) {
                System.out.println("done before");
                done.await();
                System.out.println("done after");
            }
        } catch (Exception e) {

        } finally {
            lock.unlock();
        }
    }

    public void done() {
        lock.lock();
        try {
            flag.incrementAndGet();
            done.signalAll();
        } catch (Exception e) {

        } finally {
            lock.unlock();
        }
    }

}
