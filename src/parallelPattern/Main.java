package parallelPattern;

import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) throws InterruptedException{
        BlockingDeque<PCdata> queue = new LinkedBlockingDeque<>();

        Producer producer1 = new Producer(queue);
        Producer producer2 = new Producer(queue);
        Producer producer3 = new Producer(queue);

        Consumer consumer1 = new Consumer(queue);
        Consumer consumer2 = new Consumer(queue);
        Consumer consumer3 = new Consumer(queue);

        ExecutorService service = Executors.newCachedThreadPool();

        service.execute(producer1);
        service.execute(producer2);
        service.execute(producer3);

        service.execute(consumer1);
        service.execute(consumer2);
        service.execute(consumer3);

        Thread.sleep(10000);

        producer1.stop();
        producer2.stop();
        producer3.stop();

        Thread.sleep(3000);
        service.shutdown();
    }
}
