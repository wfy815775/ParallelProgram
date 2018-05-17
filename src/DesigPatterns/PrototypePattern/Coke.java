package DesigPatterns.PrototypePattern;

public class Coke  extends ColdDrink{

    @Override
    public float price() {
        return 10.2f;
    }

    @Override
    public String name() {
        return "Coke";
    }
}
