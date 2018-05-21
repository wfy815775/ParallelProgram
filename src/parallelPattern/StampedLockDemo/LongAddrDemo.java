package parallelPattern.StampedLockDemo;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.LongAdder;

public class LongAddrDemo implements Runnable{

    LongAdder longAddr ;
CountDownLatch countDownLatch;
    public LongAddrDemo(CountDownLatch latch, LongAdder longAddr) {
        this.countDownLatch = latch;

        this.longAddr = longAddr;

    }

    @Override
    public void run() {
       long starttime = System.currentTimeMillis();
        long v = longAddr.sum();
        while (v < 100000000){
            longAddr.increment();
            v = longAddr.sum();
        }

        long endtime = System.currentTimeMillis();

        System.out.println("longaddr时间"+(endtime - starttime) );
        countDownLatch.countDown();

    }
}
