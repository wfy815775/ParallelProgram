package DesigPatterns.BridgePattern;

public class Circle extends shape{
    int x,y,radius;

    public Circle(int x, int y, int radius,DrawAPI drawAPI) {
        super(drawAPI);
        this.x = x;
        this.y = y;
       this.radius = radius;
    }

    @Override
    public void draw() {
        drawAPI.drawCircle(radius,x,y);
    }
}
