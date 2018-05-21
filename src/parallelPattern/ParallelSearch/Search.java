package parallelPattern.ParallelSearch;

import com.sun.org.apache.xerces.internal.dom.PSVIAttrNSImpl;
import com.sun.xml.internal.bind.v2.model.core.ID;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;

public class Search  {
    static int[] arr =new int[10000];

    static ExecutorService service = Executors.newCachedThreadPool();

    static final int Thread_Num =2;
    static AtomicInteger result = new AtomicInteger(-1);

    public static int doSearch(int searchValue,int beginPos,int endPos){
        int i = 0;

        for ( i = beginPos; i < endPos; i++) {
            if (result.get() >=0){
                return result.get();
            }
            if (arr[i] == searchValue){
                if (!result.compareAndSet(-1,i)){
                    return result.get();
                }
              return  i;
            }

        }
        return -1;
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {


        for (int i = 0; i <10000 ; i++) {

            arr[i]=i;
        }

        int subArrSize = arr.length / Search.Thread_Num + 1;

        List<Future<Integer>> re = new ArrayList<>();

        for (int i = 0; i <arr.length; i += subArrSize) {

            int end = i + subArrSize;
            if (end >= arr.length) end = arr.length;
            System.out.println("添加");
            re.add(service.submit(new SearchTask(1,end,500)));

        }

        for (Future<Integer> fu:re){
            System.out.println("查找");
            if (fu.get()>=0)
                System.out.println(fu.get());
        }
    }

}
