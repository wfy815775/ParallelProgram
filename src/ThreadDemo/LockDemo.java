package ThreadDemo;

import java.util.concurrent.locks.ReentrantLock;

public class LockDemo implements Runnable {
    protected static ReentrantLock lock = new ReentrantLock(); //重入锁
    protected static int i = 0;

    @Override
    public void run() {

        for (int j = 0; j < 10000; j++) {

            lock.lock();

            try {
                ++i;
            } finally {
                lock.unlock();
            }

        }
    }


    public static void main(String[] args) {
        LockDemo l = new LockDemo();

        Thread t1 = new Thread(l);
        Thread t2 = new Thread(l);
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(i);


    }
}
