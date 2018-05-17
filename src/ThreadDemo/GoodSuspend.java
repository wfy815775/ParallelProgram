package ThreadDemo;

public class GoodSuspend {

    public static Object u = new Object();

    public static class ChangeObjectThread extends Thread {
        volatile boolean suspendme = false;
        volatile boolean stopdme = false;

        public void stopMe() {

            stopdme = true;
        }

        public void suspendMe() {
            System.out.println("挂起");
            suspendme = true;
        }

        public void resumeMe() {
            System.out.println("继续执行");
            suspendme = false;

            synchronized (this) {
                notify();
            }
        }

        @Override
        public void run() {



            while (true) {

                if (stopdme)
                    break;

                synchronized (this) {
                while (suspendme) {
                    System.out.println("线程要挂起");
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                }


                synchronized (u) {
                    System.out.println("in C");
                }

                Thread.yield();

            }
        }
    }

    public static class ReadObjectThread extends Thread {
        volatile boolean stopdme = false;
        public void stopMe() {

            stopdme = true;
        }

        @Override
        public void run() {

            while (true) {
                if (stopdme)
                    break;
                synchronized (u) {
                    System.out.println("in R");
                }
                Thread.yield();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ChangeObjectThread t1 = new ChangeObjectThread();
        ReadObjectThread t2 = new ReadObjectThread();

        t1.start();
       // Thread.currentThread().sleep(1);
       t2.start();

        Thread.currentThread().sleep(1);

        t1.suspendMe();



        Thread.currentThread().sleep(10);



        t1.resumeMe();

        Thread.sleep(1);

        t1.stopMe();
        t2.stopMe();
    }


}
