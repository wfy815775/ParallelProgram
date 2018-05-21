package parallelPattern.parellelStream;

import java.util.concurrent.CompletableFuture;

public class EcxeptionCom {

    public static int calc(Integer para){
        return para / 2;

    }

    public static void main(String[] args) {
        CompletableFuture<Void> future = CompletableFuture.supplyAsync(() -> calc(50))
                .exceptionally(ex ->{ System.out.println(ex); return 0;})
                .thenCompose(i -> CompletableFuture.supplyAsync(() -> calc(i)))
                .thenAccept(System.out::println);

          CompletableFuture<Integer> initFuture = CompletableFuture.supplyAsync(() -> calc(50));
          CompletableFuture<Integer> initFuture1 = CompletableFuture.supplyAsync(() -> calc(25));

          CompletableFuture<Void> fu = initFuture.thenCombine(initFuture1,(i,j)->i+j)
                  .thenAccept(System.out::println);



    }


}
