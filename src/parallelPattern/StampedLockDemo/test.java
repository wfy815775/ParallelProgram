package parallelPattern.StampedLockDemo;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.LongAdder;

public class test {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        CountDownLatch countDownLatch = new CountDownLatch(2);
        LongAdder longAdder = new LongAdder();
        AtomicInteger atomicInteger = new AtomicInteger(0);


        Thread longAddrDemo = new Thread(new LongAddrDemo(countDownLatch,longAdder));
        Thread atomicThread = new Thread(new AtomicThread(atomicInteger,countDownLatch));
                longAddrDemo.start();
                atomicThread.start();
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("结束");
    }
}
