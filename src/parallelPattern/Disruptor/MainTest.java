package parallelPattern.Disruptor;

import com.lmax.disruptor.BlockingWaitStrategy;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;


import java.nio.ByteBuffer;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainTest {
    public static void main(String[] args) throws InterruptedException {

        Executor executor = Executors.newCachedThreadPool();
       PCdataFactory pCdataFactory = new PCdataFactory();

        int buffersize = 1024;

        Disruptor<PCdata1> disruptor = new Disruptor<>(pCdataFactory,
                buffersize,
                executor, ProducerType.MULTI, new BlockingWaitStrategy());

        disruptor.handleEventsWithWorkerPool(
                new Comsumer(),
                new Comsumer(),
                new Comsumer(),
                new Comsumer());

        disruptor.start();

        RingBuffer<PCdata1> ringBuffer = disruptor.getRingBuffer();
        Producer producer = new Producer(ringBuffer);

        ByteBuffer bb = ByteBuffer.allocate(8);
        for (long l = 0; true; l++) {
            bb.putLong(0, l);
            producer.pushData(bb);
            Thread.sleep(100);
            System.out.println("添加数据" + l);

        }


    }
}
