package DesigPatterns.PrototypePattern;

public class ChinkenBurger extends Burger{

    @Override
    public String name() {
        return "Chicken Burger";
    }

    @Override
    public float price() {
        return 25.5f;
    }
}
