package com.edu.contact.threadpool;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/threadPool")
public class MyThreadPoolController {

    private static final MyThreadPool MYTHREADPOOL = new MyThreadPool(5, new LinkedBlockingQueue(5));

    @RequestMapping("/test")
    public void doSth() throws Exception{

        for (int i = 0; i <6; i++) {
            MYTHREADPOOL.execute(() -> {
                System.out.println("threadName" + Thread.currentThread().getName() + "  start");
                try {
                    TimeUnit.SECONDS.sleep(15);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("threadName" + Thread.currentThread().getName() + "  end");
            });
        }
    }
}
