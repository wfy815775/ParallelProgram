package ThreadDemo;

import java.util.concurrent.locks.ReentrantLock;

public class IntLock implements Runnable {


    protected static ReentrantLock r1 = new ReentrantLock();
    protected static ReentrantLock r2 = new ReentrantLock();

    protected int lock;

    /**
     * 控制加锁顺序，方便构造死锁
     *
     * @param lock
     */
    public IntLock(int lock) {

        this.lock = lock;
      //  new Thread(this).start();

    }

    @Override
    public void run() {

        try {
            if (lock == 1) {
                r1.lockInterruptibly();

                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                r2.lockInterruptibly();

            } else {
                r2.lockInterruptibly();

                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                r1.lockInterruptibly();

            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            if (r1.isHeldByCurrentThread())
                r1.unlock();
            if (r2.isHeldByCurrentThread())
                r2.unlock();

            System.out.println(Thread.currentThread().getId() + ":线程退出");
        }


    }


    public static void main(String[] args) {
        IntLock intLock1 = new IntLock(1);
        IntLock intLock2 = new IntLock(2);

        Thread t1 = new Thread(intLock1);
        Thread t2 = new Thread(intLock2);
        t1.start();
        t2.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t1.interrupt();

    }
}
