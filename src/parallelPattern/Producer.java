package parallelPattern;



import parallelPattern.*;

import java.security.PublicKey;
import java.util.Random;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class Producer implements Runnable {
    private volatile  boolean isRunning = true;
    private BlockingDeque<PCdata> queue;
    private static AtomicInteger count = new AtomicInteger();
    private static  final int SLEEPTIME = 1000;

    public Producer(BlockingDeque<PCdata> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        PCdata PCdata = null;
        Random r = new Random();

        System.out.println("开始生产者："+Thread.currentThread().getId());
        try {
            while (isRunning){
                Thread.sleep(r.nextInt(SLEEPTIME));
                PCdata = new PCdata(count.incrementAndGet());
                if (!queue.offer(PCdata,2, TimeUnit.SECONDS)){
                    System.err.println("压入队列失败："+PCdata);
                }else {
                    System.out.println("压入队列成功");
                }

            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            e.printStackTrace();
        }



    }

    public void stop(){
        isRunning = false;
    }
}
