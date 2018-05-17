package ThreadDemo;

import java.awt.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolDemo implements Runnable {
    @Override
    public void run() {
        System.out.println(System.currentTimeMillis()+"Thread ID:"+Thread.currentThread().getId());

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

    public static void main(String[] args) {
        ThreadPoolDemo threadPoolDemo = new ThreadPoolDemo();

        ExecutorService ex = Executors.newCachedThreadPool();



        for (int i = 0; i < 10; i++) {
           ex.submit(threadPoolDemo);

        }
    }


}
