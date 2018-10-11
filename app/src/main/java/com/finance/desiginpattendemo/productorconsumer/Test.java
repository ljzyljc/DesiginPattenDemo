package com.finance.desiginpattendemo.productorconsumer;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * Created by Jackie on 2018/10/8.
 */
public class Test {

    public static void main(String[] args){
        BlockingQueue<PCData> queue = new LinkedBlockingDeque<>();
        Productor p1= new Productor(queue);
        Productor p2 = new Productor(queue);
        Productor p3 = new Productor(queue);
//        Productor p4 = new Productor(queue);

        Consumer c1 = new Consumer(queue);
        Consumer c2 = new Consumer(queue);
        Consumer c3 = new Consumer(queue);

        ExecutorService service = Executors.newCachedThreadPool();
        service.execute(p1);
        service.execute(p2);
        service.execute(p3);


        service.execute(c1);
        service.execute(c2);
        service.execute(c3);

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        p1.stop();
        p2.stop();
        p3.stop();
    }

}
