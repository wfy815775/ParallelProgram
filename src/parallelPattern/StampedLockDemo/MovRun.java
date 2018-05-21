package parallelPattern.StampedLockDemo;

import java.util.Random;

public class MovRun implements Runnable {
    Point p = null;
    Random r =new Random(1000);

    public MovRun(Point p) {
        this.p = p;

    }

    @Override
    public void run() {
        p.move(Math.random()*10, Math.random()*10);
    }
}
