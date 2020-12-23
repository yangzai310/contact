package com.edu.contact.semaphore;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.*;

@RestController
@RequestMapping("/semaphore")
public class SemaphoreController {

    public static final Semaphore SEMAPHORE = new Semaphore(2);

    public static final ExecutorService EXECUTOR_SERVICE = Executors.newFixedThreadPool(10);

    @RequestMapping("/test")
    public void test() {
        doSth1();
        doSth2();
        doSth3();
    }


    @RequestMapping("/semaphore1")
    public void doSth1() {
        EXECUTOR_SERVICE.execute(() -> {
            try {
                System.out.println("semaphore1 acquire before");
                SEMAPHORE.acquire();
                TimeUnit.SECONDS.sleep(10);
                System.out.println("semaphore1 acquire after");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                SEMAPHORE.release();
            }

        });
    }

    @RequestMapping("/semaphore2")
    public void doSth2() {
        EXECUTOR_SERVICE.execute(() -> {
            try {
                System.out.println("semaphore2 acquire before");
                SEMAPHORE.acquire();
                TimeUnit.SECONDS.sleep(10);
                System.out.println("semaphore2 acquire after");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                SEMAPHORE.release();
            }
        });

    }

    @RequestMapping("/semaphore3")
    public void doSth3() {
        EXECUTOR_SERVICE.execute(() -> {
            try {
                System.out.println("semaphore3 acquire before");
                SEMAPHORE.acquire();
                TimeUnit.SECONDS.sleep(10);
                System.out.println("semaphore3 acquire after");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                SEMAPHORE.release();
            }
        });
    }



}
