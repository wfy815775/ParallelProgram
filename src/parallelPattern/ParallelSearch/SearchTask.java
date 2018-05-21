package parallelPattern.ParallelSearch;

import java.util.concurrent.Callable;

public class SearchTask implements Callable<Integer> {

    int begin,end,searchVale;

    public SearchTask(int begin, int end, int searchVale) {
        this.begin = begin;
        this.end = end;
        this.searchVale = searchVale;
    }

    @Override
    public Integer call() throws Exception {

        int re = Search.doSearch(searchVale,begin,end);
        System.out.println("reL:"+re);
        return re;
    }
}
