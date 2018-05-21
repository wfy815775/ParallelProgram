package parallelPattern.StampedLockDemo;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.LongAdder;

public class AtomicThread implements Runnable {


    AtomicInteger atomicInteger ;
    CountDownLatch countDownLatch;

    public AtomicThread( AtomicInteger atomicInteger, CountDownLatch countDownLatch) {

        this.atomicInteger = atomicInteger;
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        long starttime = System.currentTimeMillis();
        long v = atomicInteger.get();
        while (v < 100000000){

           v= atomicInteger.incrementAndGet();

        }
        long endtime = System.currentTimeMillis();

        System.out.println("ato时间"+(endtime - starttime) +"  "+ v);
        countDownLatch.countDown();
    }
}
