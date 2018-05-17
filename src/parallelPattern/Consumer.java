package parallelPattern;

import java.text.MessageFormat;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.BlockingDeque;

public class Consumer implements Runnable {
    private BlockingDeque<PCdata> queue;
    public static final int SLEEPTIME = 1000;

    public Consumer(BlockingDeque<PCdata> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        System.out.println("消费者开始：id=" + Thread.currentThread().getId());
        Random r = new Random();

        try {
            while (true) {
                PCdata pCdata = queue.take();
                if (null != pCdata) {
                    int re = pCdata.getIntdata() * pCdata.getIntdata();
                    System.out.println(MessageFormat.
                            format("{0}*{1} = {2}", pCdata.getIntdata(), pCdata.getIntdata(), re));
                    Thread.sleep(r.nextInt(SLEEPTIME));
                }
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }


    }
}
