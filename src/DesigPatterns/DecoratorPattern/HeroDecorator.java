package DesigPatterns.DecoratorPattern;

public abstract class HeroDecorator implements Hero{
    private Hero heroDecorator;

    public HeroDecorator(Hero heroDecorator) {
        this.heroDecorator = heroDecorator;
    }

    @Override
    public void init() {
          heroDecorator.init();
    }



}
