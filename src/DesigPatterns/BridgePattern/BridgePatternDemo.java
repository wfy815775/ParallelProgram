package DesigPatterns.BridgePattern;

public class BridgePatternDemo {
    public static void main(String[] args) {
        shape circle = new Circle(10,10,25,new RedCircle());

        circle.draw();
    }
}
