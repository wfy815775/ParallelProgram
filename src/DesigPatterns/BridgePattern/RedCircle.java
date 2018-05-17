package DesigPatterns.BridgePattern;

public class RedCircle implements DrawAPI{
    @Override
    public void drawCircle(int raduis, int x, int y) {
        System.out.println("换一个红色的圆形：radius:"+raduis+" x:"+x+"y:"+y);

    }
}
