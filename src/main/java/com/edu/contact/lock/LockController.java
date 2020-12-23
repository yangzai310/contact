package com.edu.contact.lock;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/lock")
public class LockController {

    @Resource
    private UnSyncToSync unSyncToSync;

    @RequestMapping("/lock1")
    public void doSth() {
        new Thread(() -> {
            System.out.println("lock1 sleep before");
            try {
                TimeUnit.SECONDS.sleep(30);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("lock1 sleep after");
            unSyncToSync.done();
        }).start();
        unSyncToSync.doVoid();
        System.out.println("lock1 done -----");

    }
}
