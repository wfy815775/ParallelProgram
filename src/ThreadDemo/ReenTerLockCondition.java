package ThreadDemo;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ReenTerLockCondition implements Runnable {
    protected static ReentrantLock reentrantLock = new ReentrantLock();
    protected static Condition condition = reentrantLock.newCondition();

    /**
     * 和OBJ.wait() notify()一样condition.await()方法要求线程持有相关的重入锁
     * 调用condition.signal()是也要求获得相关锁
     */
    @Override
    public void run() {

        try {
            reentrantLock.lock();
            condition.await();
            System.out.println("继续执行");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            reentrantLock.unlock();
        }

    }


    public static void main(String[] args) {
        ReenTerLockCondition reenTerLockCondition = new ReenTerLockCondition();

        Thread t = new Thread(reenTerLockCondition);

        t.start();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        reentrantLock.lock();
        condition.signal();
        reentrantLock.unlock();


    }
}
