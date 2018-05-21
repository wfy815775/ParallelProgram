package parallelPattern.parellelStream;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.IntStream;

public class AskThread implements Runnable{

    CompletableFuture<Integer> re = null;

    public AskThread(CompletableFuture<Integer> re) {
        this.re = re;
    }

    @Override
    public void run() {
        int myRe =0;
        try {
            myRe = re.get() * re.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println(myRe);
    }

    public static  Integer clac(Integer para){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return para * para;
    }


    public static void main(String[] args){
//        final CompletableFuture<Integer> future = new CompletableFuture<>();


            final CompletableFuture<Void> future1 = CompletableFuture.supplyAsync(() -> clac(50))
                    .thenApply(i->Integer.toString(i))
                    .thenApply(o -> "\""+o+"\"")
                    .thenAccept(System.out::println);

//        new Thread(new AskThread(future)).start();

//        Thread.sleep(1000);
//        future.complete(60);


//        try {
//            System.out.println(future1.get());
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } catch (ExecutionException e) {
//            e.printStackTrace();
//        }
//        System.out.println(  IntStream.range(1,1000).filter(o->o%2==1).count());
    }
}
