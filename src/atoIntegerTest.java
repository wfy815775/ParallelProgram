import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicInteger;

public class atoIntegerTest {
   static Integer i = 0;
   static AtomicInteger z = new AtomicInteger(0);
   static void set(int z){
     //  z.incrementAndGet();
       i=z;
    }

  static   void set1(){
       // z.decrementAndGet();
      i=0;
    }
    public static void main(String[] args) throws InterruptedException {

        ExecutorService ex = Executors.newFixedThreadPool(8);
        ExecutorService ex1 = Executors.newFixedThreadPool(8);


        Runnable runnable = new Runnable() {
            @Override
            public void run() {

                for (int j = 0; j < 100; j++) {
                    atoIntegerTest.set(1);
                  //  atoIntegerTest.set();
                    System.out.println(atoIntegerTest.i);
                }
            }
        };

        Runnable runnable1 = new Runnable() {
            @Override
            public void run() {
                atoIntegerTest.set(0);
                for (int j = 0; j < 100; j++) {
                   // atoIntegerTest.set1();
                    System.out.println(atoIntegerTest.i);
                }


            }
        };
        for (int j = 0; j <100 ; j++) {

            ex.submit(runnable);

                ex.submit(runnable1);
        }

//        for (int j = 0; j <100000 ; j++) {
//            if (j==99998)
//                ex.submit(runnable);
//            else
//                ex.submit(runnable1);
//
//        }
//        ex.submit(runnable1);


    }
}
