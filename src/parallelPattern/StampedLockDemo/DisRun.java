package parallelPattern.StampedLockDemo;

public class DisRun implements Runnable{
    Point p = null;


    public DisRun(Point p) {
        this.p = p;

    }

    @Override
    public void run() {
        System.out.println( p.distanceFromOrigin());
    }
}
