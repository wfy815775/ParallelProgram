package ThreadDemo;

/**
 * volatile 不能代替所，他无法保证符合操作的原子性
 */
public class PlusTask implements Runnable {

    protected static volatile int i = 0;



    @Override
    public void run() {
        for (int j = 0; j < 10000; j++) {
            ++i;
        }

    }


    public static void main(String[] args) {
        Thread[] threads = new Thread[10];

        for (int j = 0; j < 10; j++) {
            threads[j]  = new Thread(new PlusTask());
            threads[j].start();
        }

        for (int j = 0; j < 10; j++) {
            try {
                threads[j].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println(i);
    }
}
