package DesigPatterns.PrototypePattern;

public abstract class Burger implements  Item {
    @Override
    public Packing packong() {
        return new Wrapper();
    }

    @Override
    public abstract float price() ;
}
