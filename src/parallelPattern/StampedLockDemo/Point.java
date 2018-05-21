package parallelPattern.StampedLockDemo;

import com.sun.xml.internal.bind.v2.model.core.ID;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.StampedLock;
//注意：StampedLock 使用类似CAS操作的死循环反复尝试的策略，在挂起线程是使用的是Unsafe.park()函数，而park()函数被中断时
//会直接返回，不跑出异常。StampedLock中没有处理中断的逻辑，如果阻塞在park()函数上的线程被中断时，会再次进入循环，
// 当退出条件不足时会疯狂占用CPU。
public class Point {

    private double x, y;
    private final StampedLock stampedLock = new StampedLock();

    public  void move(double dx, double dy) {
        System.out.println("随机数："+dx+"  "+dy);
        long stamp = stampedLock.writeLock();

        try {
            x += dx;
            y += dy;
        } finally {
            stampedLock.unlockWrite(stamp);
        }

    }

    double distanceFromOrigin() {
        long stamp = stampedLock.tryOptimisticRead();

        double curX = x, curY = y;

        if (!stampedLock.validate(stamp)){
            System.out.println("时间戳检索错误，重新读取");
            stamp = stampedLock.readLock();
            try {
                curX = x;
                curY = y;
            } finally {
                stampedLock.unlockWrite(stamp);
            }
        }

        return  Math.sqrt(curX * curX + curY * curY);
    }




    public static void main(String[] args) {


        Point point = new Point();


        ExecutorService executors = Executors.newCachedThreadPool();
MovRun movRun = new MovRun(point);
DisRun disRun = new DisRun(point);


        for (int i = 0; i < 1000 ; i++) {
            executors.submit(movRun);
        }
        for (int i = 0; i < 1000 ; i++) {
            executors.submit(disRun);
        }


    }
}
