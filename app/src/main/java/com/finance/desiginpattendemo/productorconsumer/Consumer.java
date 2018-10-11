package com.finance.desiginpattendemo.productorconsumer;

import java.text.MessageFormat;
import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Jackie on 2018/10/8.
 */
public class Consumer implements Runnable{
    private BlockingQueue<PCData> queue;
    private static final int SLEEP_TIME = 1000;
    public Consumer(BlockingQueue<PCData> queue){
        this.queue = queue;
    }


    @Override
    public void run() {
        PCData pcData = null;
        Random random = new Random();
        System.out.println("------"+Thread.currentThread().getId());
        while (true) {
            try {
                pcData = queue.take();
                if (pcData != null) {
                    int re = pcData.getData() * pcData.getData();
                    System.out.println(MessageFormat.format("{0}*{1}={2}", pcData.getData(), pcData.getData(), re));
                    Thread.sleep(random.nextInt(SLEEP_TIME));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

    }
}
