package DesigPatterns.ProxyPattern;

public class RealImage implements Image {

    @Override
    public void display(String name) {
        System.out.println("展示图片："+ name);
    }
}
