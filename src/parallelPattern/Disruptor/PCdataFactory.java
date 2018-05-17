package parallelPattern.Disruptor;

import com.lmax.disruptor.EventFactory;
import parallelPattern.PCdata;

public class PCdataFactory implements EventFactory<PCdata1> {
    @Override
    public PCdata1 newInstance() {
        return new PCdata1();
    }
}
