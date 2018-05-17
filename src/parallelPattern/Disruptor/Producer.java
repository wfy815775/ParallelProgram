package parallelPattern.Disruptor;

import com.lmax.disruptor.RingBuffer;


import java.nio.ByteBuffer;

public class Producer {
    private final RingBuffer<PCdata1> ringBuffer;

    public Producer(RingBuffer<PCdata1> ringBuffer) {
        this.ringBuffer = ringBuffer;
    }

    public void  pushData(ByteBuffer bb){
        long  sequence = ringBuffer.next();
        System.out.println("sequence:"+sequence);
        try {


            PCdata1 event =ringBuffer.get(sequence);

            event.setIntdata(bb.getLong(0));
        } finally {
            ringBuffer.publish(sequence);
        }


    }
}
