package DesigPatterns.ObserverPattern;

import com.sun.org.apache.bcel.internal.generic.NEW;

public class psvm {

    public static void main(String[] args) {
        Subject s = new Subject();

        new OctalObserver(s);
        new BinaryObserver(s);

        s.setState(1);
        s.setState(2);
    }



}
