import java.sql.SQLClientInfoException;
import java.util.concurrent.RecursiveAction;

public class Transform extends RecursiveAction {

    int seqThreshold;
    double[] data;

    int start, end;

    public Transform(int seqThreshold, double[] data, int start, int end) {
        this.seqThreshold = seqThreshold;
        this.data = data;
        this.start = start;
        this.end = end;
    }

    @Override
    protected void compute() {
        if ((end - start) < seqThreshold) {
            for (int i = start; i < end; i++) {
                if (data[i] % 2 == 0)
                    data[i] = Math.sqrt(data[i]);
                else
                    data[i] = Math.cbrt(data[i]);
            }

        } else {
            //分治策略
            int middle = (start + end) / 2;

            invokeAll(new Transform(seqThreshold, data, start, middle),
                    new Transform(seqThreshold, data, middle, end));

        }

    }
}
