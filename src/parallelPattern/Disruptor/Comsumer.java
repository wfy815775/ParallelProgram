package parallelPattern.Disruptor;

import com.lmax.disruptor.WorkHandler;
import parallelPattern.PCdata;

public class Comsumer implements WorkHandler<PCdata1>{
    @Override
    public void onEvent(PCdata1 pCdata) throws Exception{
        System.out.println(Thread.currentThread().getId()+":Event:--"+pCdata.getIntdata() + pCdata.getIntdata()+"--");


    }
}
