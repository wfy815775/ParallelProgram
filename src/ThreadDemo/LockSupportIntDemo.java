package ThreadDemo;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

import java.util.concurrent.locks.LockSupport;

public class LockSupportIntDemo {
    protected static Object o = new Object();

    protected static ChangeObjectThread t1 = new ChangeObjectThread("T1");
    protected static ChangeObjectThread t2 = new ChangeObjectThread("T2");


    public static class ChangeObjectThread extends Thread{


        public ChangeObjectThread(String name) {
            super.setName(name);
        }

        @Override
        public void run() {

            synchronized (o){
                System.out.println("in"+getName());
                LockSupport.park();

                if (Thread.interrupted())
                System.out.println(getName()+" 被中断了");


            }
            System.out.println(getName()+"执行结束");
        }
    }


    public static void main(String[] args) {
        t1.start();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        t2.start();
        t1.interrupt();

        LockSupport.unpark(t2);
    }
}
