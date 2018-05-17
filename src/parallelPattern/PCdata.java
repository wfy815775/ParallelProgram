package parallelPattern;

public final class PCdata {
    private  int intdata ;

    public PCdata() {}

    public PCdata(int intdata) {
        this.intdata = intdata;
    }




    public int getIntdata() {
        return intdata;
    }

    @Override
    public String toString() {
        return "data:" + intdata;
    }
}
