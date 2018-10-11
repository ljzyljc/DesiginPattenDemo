package com.finance.desiginpattendemo.productorconsumer;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Jackie on 2018/10/8.
 */
public class Productor implements Runnable{

    private volatile boolean isRunning = true;
    private BlockingQueue<PCData> queue;  //内存缓冲区
    private static AtomicInteger count = new AtomicInteger();//总数
    private static final int SLEEP_TIME = 1000;

    public Productor(BlockingQueue<PCData> queue){
        this.queue = queue;
    }


    @Override
    public void run() {
        PCData pcData = null;
        Random random = new Random();
        System.out.println("------"+Thread.currentThread().getId());
        try {
            while (isRunning){
                Thread.sleep(random.nextInt(SLEEP_TIME));
                pcData = new PCData(count.incrementAndGet());
                System.out.println(pcData + "加入队列");
                if (!queue.offer(pcData,2, TimeUnit.SECONDS)){
                    System.err.println("加入队列失败");
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void stop(){
        isRunning = false;
    }
}
