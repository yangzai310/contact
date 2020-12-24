package com.edu.contact.cyclicBarrier;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Vector;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/cyclicBarrier")
public class CyclicBarrierController {

    public static final ExecutorService PRODUCT = Executors.newFixedThreadPool(6);

    public static final ExecutorService CONSUMER = Executors.newFixedThreadPool(1);

    public static final Vector<String> orders = new Vector();

    public static final Vector<String> items = new Vector();

    public static final AtomicLong al1  = new AtomicLong(0);

    public static final AtomicLong al2  = new AtomicLong(0);

    Runnable rb = () -> {
        CONSUMER.execute( () -> {
            String order = orders.remove(0);
            String item = items.remove(0);
            System.out.println(order + "----" + item);
        });
    };

    CyclicBarrier cl = new CyclicBarrier(2, rb);


    @RequestMapping("/test")
    public void test() {
        PRODUCT.execute(() -> {
            System.out.println("product1 --- before");
            try {
                TimeUnit.SECONDS.sleep(10);
                long andIncrement = al1.getAndIncrement();
                orders.add(String.valueOf(andIncrement));
                System.out.println("product1 --- after");
                cl.await();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });


        PRODUCT.execute(() -> {
            System.out.println("product2 --- before");
            try {
                TimeUnit.SECONDS.sleep(20);
                long andIncrement = al2.getAndIncrement();
                items.add(String.valueOf(andIncrement));
                System.out.println("product2 --- after");
                cl.await();
            } catch (Exception e) {
                e.printStackTrace();
            }

        });




    }





}
