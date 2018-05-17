package DesigPatterns.PrototypePattern;

public abstract class ColdDrink implements Item{

    @Override
    public Packing packong() {
        return new Bottle();
    }

    @Override
    public abstract float price();
}
