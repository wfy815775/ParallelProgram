package parallelPattern.ParallelLines;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

public class Plus implements Runnable{
    public static BlockingDeque<Msg> bq = new LinkedBlockingDeque<>();

    @Override
    public void run() {
        while (true){
            try {
                Msg msg = bq.take();
                msg.j = msg.i+msg.j;
                Multiply.bq.add(msg);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
