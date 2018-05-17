package parallelPattern.Disruptor;

public class PCdata1 {
    private  long intdata ;

    public PCdata1() {}

    public PCdata1(long intdata) {
        this.intdata = intdata;
    }

    public void setIntdata(long intdata) {
        this.intdata = intdata;
    }

    public long getIntdata() {
        return intdata;
    }

    @Override
    public String toString() {
        return "data:" + intdata;
    }
}
